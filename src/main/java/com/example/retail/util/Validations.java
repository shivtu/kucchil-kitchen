package com.example.retail.util;

import com.example.retail.controllers.retailer.vegitables_retailer.AddVegitablesRequestBody;
import com.example.retail.controllers.retailer.vegitables_retailer.UpdateVegitablesInventoryRequest;
import com.example.retail.models.customerorders.CustomerOrders;
import com.example.retail.models.customerorders.CustomerOrdersItemsList;
import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.repository.EdibleProductsRepository;
import com.example.retail.models.edibleproducts.services.EdibleProductsService;
import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.models.itemcategories.repository.ItemCategoriesRepository;
import com.example.retail.models.itemcategories.service.ItemCategoriesService;
import com.example.retail.models.taxutility.Taxes;
import com.example.retail.models.taxutility.repository.TaxRepository;
import com.example.retail.models.taxutility.services.TaxService;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.VegitablesInventory;
import com.example.retail.models.vegitables.repository.VegitablesRepository;
import com.example.retail.models.vegitables.services.VegitableInventoryService;
import com.example.retail.models.vegitables.services.VegitablesService;
import com.example.retail.users.profiles.UsersProfile;
import com.example.retail.users.profiles.UsersProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class Validations {

    @Autowired
    CreateResponse createResponse;

    @Autowired
    VegitablesRepository vegitablesRepository;

    @Autowired
    VegitableInventoryService vegitableInventoryService;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    ItemCategoriesService itemCategoriesService;

    @Autowired
    UsersProfileService usersProfileService;

    @Autowired
    TaxService taxService;

    @Autowired
    EdibleProductsRepository edibleProductsRepository;

    public int validationSuccessCode = 1;
    public int unprocessableRequestCode = 422;
    public int badRequestCode = 400;

    public ValidationResponse validateNewVegitables(AddVegitablesRequestBody newVegitables, String vegSubId) {

        Optional<Vegitables> vegitables = vegitablesRepository.findBySubId(vegSubId);
        // If the item already exists
        if(vegitables.isPresent()) {
            return createResponse.createValidationResponse(
                    unprocessableRequestCode,
                    "This item already exists",
                    "Try updating this item instead",
                    vegitables
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

        // Check if applicable taxes are valid
        AtomicReference<Boolean> taxAvailable = new AtomicReference<>(true);
        List<String> applicableTaxes = newVegitables.getVegitableApplicableTaxes();
        applicableTaxes.forEach(applicableTax -> {
            Optional<Taxes> taxes = taxService.findByName(applicableTax);
            if (taxes.isEmpty()) {
                taxAvailable.set(false);
            }
        });

        if(!taxAvailable.get()) {
            return createResponse.createValidationResponse(
                    badRequestCode,
                    "Applied taxes not found",
                    "Create a tax and then apply to the product or apply one of the existing tax",
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
        if (vegitablesInventory.isPresent()) {
            return
                    createResponse.createValidationResponse(
                            400,
                            "This item with provided details already exists",
                            "Try updating the quantity only: /api/v1/retailer/vegitables/update/quantity/<id>/<quantity>",
                            vegitablesInventory
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

            customerDiscount = customerOrdersDiscountServices.findByDiscountName(specialDiscountName);

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
        Optional<CustomerOrdersDiscount> res = customerOrdersDiscountServices.findByDiscountName(discountName);
        if(res.isPresent()) {
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

    public ValidationResponse validateItemCategory(String itemCategorySubId) {
        Optional<ItemCategories> itemCategories = itemCategoriesService.findByItemCategorySubId(itemCategorySubId);
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

    // TODO: Also validate the tax name
    public ValidationResponse validateIfTaxesAvailable(ArrayList<String> taxNameList) {
        AtomicReference<Boolean> taxAvailable = new AtomicReference<>(true);
        taxNameList.forEach(taxName -> {
            Optional<Taxes> taxes = taxService.findByName(taxName);
            if (taxes.isEmpty()) {
                taxAvailable.set(false);
            }
        });
        if(!taxAvailable.get()) {
            return createResponse.createValidationResponse(
                badRequestCode,
                "Applied taxes not found",
                "Create a tax and then apply to the product or apply one of the existing tax",
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

    public ValidationResponse   validateNewEdibleProductExits (String subId) {

        Optional<EdibleProducts> edibleProductBySubId = edibleProductsRepository.findEdibleProductBySubId(subId);

        if(edibleProductBySubId.isPresent()) {
            return createResponse.createValidationResponse(
                unprocessableRequestCode,
                "This product already exists",
                "Try updating the quantity only or create new inventory",
                edibleProductBySubId
            );
        }

        return createResponse.createValidationResponse(
            validationSuccessCode,
            "Product can be created",
            "NA",
            null
        );

    }
}
