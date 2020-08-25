package com.example.retail.util;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.controllers.retailer.vegitables_retailer.UpdateVegitablesInventoryRequest;
import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.CustomerOrdersItemsList;
import com.example.retail.models.customerorders.repository.CustomerOrdersRepository;
import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.repository.CustomerOrdersDiscountRepository;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.models.itemcategories.repository.ItemCategoriesRepository;
import com.example.retail.models.taxutility.Taxes;
import com.example.retail.models.taxutility.repository.TaxRepository;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.VegitablesInventory;
import com.example.retail.models.vegitables.services.VegitableInventoryService;
import com.example.retail.models.vegitables.services.VegitablesService;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class Validations {

    @Autowired
    CreateResponse createResponse;

    @Autowired
    VegitablesService vegitablesService;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    CustomerOrdersDiscountRepository customerOrdersDiscountRepository;

    @Autowired
    ItemCategoriesRepository itemCategoriesRepository;

    @Autowired
    UsersProfileService usersProfileService;

    public int validationSuccessCode = 1;
    public int unprocessableRequestCode = 422;
    public int badRequestCode = 400;

    public ValidationResponse validateNewVegitables(AddVegitablesRequestBody newVegitables, String vegSubId) {

        Optional<Vegitables> vegitables = vegitablesService.findBySubId(vegSubId);

        // If the item already exists
        if(!vegitables.isEmpty()) {

                return createResponse.createValidationResponse(
                        unprocessableRequestCode,
                            "This item already exists",
                            "Try updating this item instead",
                        null
                    );

        }

        // Check if max discount in inventory table is less than offered discount
        if (newVegitables.getVegitableInventoryMaxDiscount() < newVegitables.getVegitableOfferedDiscount()) {

            return     createResponse.createValidationResponse(
                    badRequestCode,
                            "Offered discount is set more than the max discount",
                            "Offered discount must always be less than the maximum discount set for an item",
                    null
                    );
        }

        // Check if discounts are negative numbers
        if (newVegitables.getVegitableInventoryMaxDiscount() < 0 || newVegitables.getVegitableOfferedDiscount() < 0) {
            return
                    createResponse.createValidationResponse(
                            badRequestCode,
                            "Invalid format for discounts",
                            "Discounts are expressed in %, please provide a positive number",
                            null

            );
        }

        // Check if selling price is less than cost price
        if (newVegitables.getVegitableSellingPrice() < newVegitables.getVegitableInventoryCostPrice()) {

              return createResponse.createValidationResponse(
                      badRequestCode,
                            "Selling price of the vegitable is less than the cost price",
                            "Selling price must be more than cost price to make a profit",
                      null
                    );

        }

        return createResponse.createValidationResponse(
                validationSuccessCode,
                "OK",
                "NA",
                null

        );

    }

    public ValidationResponse validateInventory(String vegSubId, UpdateVegitablesInventoryRequest updateVegitablesInventoryRequest) {
        Optional<VegitablesInventory> vegitablesInventory = vegitableInventoryService.findVegitableInventoryBySubId(vegSubId);
        if (!vegitablesInventory.isEmpty()) {
            return
                createResponse.createValidationResponse(
                400,
            "This item with provided details already exists",
            "Try updating the quantity only: /api/v1/retailer/vegitables/update/quantity/<id>/<quantity>",
                        null
            );
        }

        if(updateVegitablesInventoryRequest.getVegitableSellingPrice() < updateVegitablesInventoryRequest.getVegitableInventoryCostPrice()) {
            return createResponse.createValidationResponse(
                    badRequestCode,
                    "Selling price of the vegitable is less than the cost price",
                    "Selling price must be more than cost price to make a profit",
                    null
            );
        }

        return createResponse.createValidationResponse(validationSuccessCode, "OK", null, null);
    }

    public ValidationResponse validateCustomerOrder (CustomerOrders customerOrders) {
        List<CustomerOrdersItemsList> orderedItemsList = customerOrders.getCustomerOrdersItemsList();
        int ordersItemsListLength = orderedItemsList.size();
        Set<Long> validatorSet = new HashSet<>();

        for (int i = 0; i < ordersItemsListLength; i++) {
            if(!validatorSet.add(orderedItemsList.get(i).getProductTableId())) {
                return createResponse.createValidationResponse(422, "Duplicate items in the list", "Increase the quantity of the items in the list instead of adding duplicates", null);
            }
        }

        String specialDiscountName = customerOrders.getSpeacialDiscountName();
        Optional<CustomerOrdersDiscount> customerDiscount = Optional.empty();

        /* If user has added a discount */
        if(specialDiscountName != null) {

            customerDiscount = customerOrdersDiscountRepository.findByDiscountName(specialDiscountName);

            /* If applied discount is not active */
            if(customerDiscount.isPresent() && !customerDiscount.get().getDiscountActive()) {
                return createResponse.createValidationResponse(400, "Special discount applied is not active",
                        "Apply an active discount or remove it to default to 0", null);
            }

            /* if there is no customer discount found with given discount names */
            if(customerDiscount.isEmpty() && !specialDiscountName.equals("loyaltyDiscount")) {
                return createResponse.createValidationResponse(400, "Special discount applied does not exist",
                        "Apply a valid discount or remove it to default to 0", null);
            }
        }

        return createResponse.createValidationResponse(validationSuccessCode, "OK", null, customerDiscount);
    }

    public  ValidationResponse validateNewDiscount (CustomerOrdersDiscount customerOrdersDiscount) {

        String discountName = customerOrdersDiscount.getDiscountName();
        Optional<CustomerOrdersDiscount> res = customerOrdersDiscountRepository.findByDiscountName(discountName);
        if(!res.isEmpty()) {
            return createResponse.createValidationResponse(422, "The discount with name " + discountName + " already exists",
                    "Try creating a discount with another name or ammend the existing one", null);
        }
        return createResponse.createValidationResponse(validationSuccessCode, discountName + " is available", "The search for existing names is case sensetive", null);
    }

    public ValidationResponse validateDeliveryChargeConstraint(DeliveryCharges deliveryCharges) {
        Float amountGreaterThan = deliveryCharges.getSalesAmountGreaterThan();
        Float amountLessThan = deliveryCharges.getSalesAmountLessThan();
        if(amountGreaterThan >= amountLessThan) {
            return createResponse.createValidationResponse(400, "Incorrect range",
                    "Range must be from a smaller number to greater number", null);
        }

        if (amountGreaterThan < 0 || amountLessThan < 0) {
            return createResponse.createValidationResponse(400, "Incorrect range",
                    "Range cannot have values less than 0", null);
        }

        return createResponse.createValidationResponse(validationSuccessCode, "validation success", "NA", null);
    }

    public ValidationResponse validateNewTax(Taxes taxes) {
//        if (taxes.getItemCategories().length > 0) {
//            return createResponse.createValidationResponse(422, "Tax needs to be created first before adding list of categories",
//                    "Please create the type of tax first and then add categories", null);
//        }
        return createResponse.createValidationResponse(validationSuccessCode, "validation success", "NA", null);
    }

    public ValidationResponse validateItemCategory(String itemClassification) {
        Optional<ItemCategories> itemCategories = itemCategoriesRepository.findItemCategoryByClassification(itemClassification);
        if(itemCategories.isEmpty()) {
            return createResponse.createValidationResponse(422, "Item category/classification not found", "Provide a valid classification name or create a classification and then add to the product", null);
        }
        return createResponse.createValidationResponse(validationSuccessCode, "Classification can be applied", "NA", null);
    }

    public ValidationResponse validateNewUser(String userName, Long userProfilePhoneNumber) {
        Optional<UsersProfile> userProfileByUserName = usersProfileService.findByUserName(userName);
        Optional<UsersProfile> userProfileByPhoneNumber = usersProfileService.findByUserProfilePhoneNumber(userProfilePhoneNumber);
        if(userProfileByUserName.isPresent()) {
            return createResponse.createValidationResponse(422, "User profile already exists with user ID: " +userName,
                    "Duplicate email Ids are not allowed", userProfileByUserName);
        }

        if (userProfileByPhoneNumber.isPresent()) {
            return createResponse.createValidationResponse(422, "User profile already exists with phone number: " +userProfilePhoneNumber,
                    "Duplicate phone numbers are not allowed", userProfileByPhoneNumber);
        }
        return createResponse.createValidationResponse(validationSuccessCode, "User validated",
                "NA", null);
    }
}
