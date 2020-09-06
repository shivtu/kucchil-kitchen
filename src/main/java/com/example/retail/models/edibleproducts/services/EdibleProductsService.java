package com.example.retail.models.edibleproducts.services;

import com.example.retail.controllers.retailer.edibleproducts_retailer.AddEdibleProductsRequestBody;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.DiscountCalculator;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.EdibleProductsInventory;
import com.example.retail.models.edibleproducts.repository.EdibleProductsInventoryRepository;
import com.example.retail.models.edibleproducts.repository.EdibleProductsRepository;
import com.example.retail.models.taxutility.TaxCalculator;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import com.example.retail.util.ValidationResponse;
import com.example.retail.util.Validations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EdibleProductsService {

    @Autowired
    EdibleProductsRepository edibleProductsRepository;

    @Autowired
    EdibleProductsInventoryRepository edibleProductsInventoryRepository;

    @Autowired
    Validations validations;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    DiscountCalculator discountCalculator;

    @Autowired
    TaxCalculator taxCalculator;

    @Autowired
    JWTDetails jwtDetails;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    public String genearteEdibleProductSubId(
            String edibleProductManufacturer,
            String edibleProductName,
            String edibleProductVariant,
            String edibleProductFlavor,
            Float edibleProductDenomination,
            LocalDate edibleProductInventoryExpiry
    ) {
        return edibleProductManufacturer.toLowerCase()
                + edibleProductName.toLowerCase()
                + edibleProductVariant.toLowerCase()
                + edibleProductFlavor.toLowerCase()
                + edibleProductDenomination.toString().toLowerCase()
                + edibleProductInventoryExpiry.toString().toLowerCase();
    }

    public List<EdibleProducts> getAllProducts(){
        return  edibleProductsRepository.findAll();
    }

    public Optional<EdibleProducts> getProductById(Long productId) {
        return edibleProductsRepository.findById(productId);
    }

    public Iterable<EdibleProducts> addAllEdibleProducts(List<EdibleProducts> newProducts) {
        return edibleProductsRepository.saveAll(newProducts);
    }

    public ResponseEntity<Object> addEdibleProduct(HttpServletRequest request, AddEdibleProductsRequestBody newEdibleProduct){

        LocalDate expiryDate = LocalDate.parse(newEdibleProduct.getEdibleProductInventoryExpiry());
        String edibleProductAddedBy = jwtDetails.userName(request);

        // Get the Sub ID
        String subid = genearteEdibleProductSubId(
            newEdibleProduct.getEdibleProductManufacturer(),
            newEdibleProduct.getEdibleProductName(),
            newEdibleProduct.getEdibleProductVariant(),
            newEdibleProduct.getEdibleProductFlavor(),
            newEdibleProduct.getEdibleProductDenomination(),
            expiryDate

        );

        /**
         * Create the edible products model
         * */
        EdibleProducts edibleProducts = new EdibleProducts();

        edibleProducts.setEdibleProductManufacturer(newEdibleProduct.getEdibleProductManufacturer());
        edibleProducts.setEdibleProductName(newEdibleProduct.getEdibleProductName());
        edibleProducts.setEdibleProductVariant(newEdibleProduct.getEdibleProductVariant());
        edibleProducts.setEdibleProductFlavor(newEdibleProduct.getEdibleProductFlavor());
        edibleProducts.setEdibleProductType(newEdibleProduct.getEdibleProductType());
        edibleProducts.setEdibleProductDescription(newEdibleProduct.getEdibleProductDescription());
        edibleProducts.setEdibleProductGenericName(newEdibleProduct.getEdibleProductGenericName());
        edibleProducts.setEdibleProductAlternaleName(newEdibleProduct.getEdibleProductAlternaleName());
        edibleProducts.setItemClassificationName(newEdibleProduct.getItemClassificationName());

        /*
        * Validate the classification code
        * Return Error response from validation if validation fails
        * */
        ValidationResponse itemClassifictionValidation = validations.validateItemClassificationCode(newEdibleProduct.getItemClassificationCode());
        if(itemClassifictionValidation.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(itemClassifictionValidation.getStatusCode()).body(
                itemClassifictionValidation
            );
        }
        edibleProducts.setItemClassificationCode(newEdibleProduct.getItemClassificationCode());
        edibleProducts.setEdibleProductForMinors(newEdibleProduct.getEdibleProductForMinors());
        edibleProducts.setEdibleProductAvailable(newEdibleProduct.getEdibleProductAvailable());
        edibleProducts.setEdibleProductMrp(newEdibleProduct.getEdibleProductMrp());
        edibleProducts.setEdibleProductOfferedDiscount(newEdibleProduct.getEdibleProductOfferedDiscount());
        edibleProducts.setEdibleProductsDiscountName(newEdibleProduct.getEdibleProductsDiscountName());

        /**
         * Check if discount exists
         **/
        Optional<CustomerOrdersDiscount> proposedDiscount =
                customerOrdersDiscountServices.findByDiscountName(newEdibleProduct.getEdibleProductsDiscountName());

        /**
         * If discount does not exist, set the discount proposed in the payload
         **/
        Float discountedPrice = 0F;
        if(proposedDiscount.isEmpty()) {
            /**
             * Calculate the discounted price from the payload
             **/
            discountedPrice  = discountCalculator.calcDiscountedPrice(
                newEdibleProduct.getEdibleProductMrp(), newEdibleProduct.getEdibleProductOfferedDiscount()
            );
        }  else {
            /**
             * Calculate the discounted price from the DB record
             **/
            discountedPrice = discountCalculator.calcDiscountedPrice(
                newEdibleProduct.getEdibleProductMrp(), proposedDiscount.get().getDiscountPercentage()
            );
        }

        /**
         * Finally set the discounted price
         **/
        edibleProducts.setEdibleProductDiscountedPrice(discountedPrice);
        edibleProducts.setEdibleProductApplicableTaxes(newEdibleProduct.getEdibleProductApplicableTaxes());

        /**
         * Validate the taxes in request body
         **/
        ValidationResponse taxValidation = validations.validateTaxes(newEdibleProduct.getEdibleProductApplicableTaxes());

        if(taxValidation.getStatusCode() != validations.validationSuccessCode) {
            return ResponseEntity.status(taxValidation.getStatusCode()).body(
                taxValidation
            );
        }

        /**
         * Calculate taxed price after discount
         **/
        edibleProducts.setEdibleProductTaxedPrice(taxCalculator.calcAmountAfterTax(newEdibleProduct.getEdibleProductApplicableTaxes(), discountedPrice));
        edibleProducts.setEdibleProductQuantity(newEdibleProduct.getEdibleProductQuantity());
        edibleProducts.setEdibleProductsMeasureMentUnit(newEdibleProduct.getEdibleProductsMeasureMentUnit());
        edibleProducts.setEdibleProductDenomination(newEdibleProduct.getEdibleProductDenomination());
        edibleProducts.setEdibleProductSubId(subid);

        edibleProductsRepository.save(edibleProducts);

        /**
         * Create the edible products inventory model
         * */
        EdibleProductsInventory edibleProductsInventory = new EdibleProductsInventory();

        edibleProductsInventory.setEdibleProductCostPrice(newEdibleProduct.getEdibleProductCostPrice());
        edibleProductsInventory.setEdibleProductFixedCost(newEdibleProduct.getEdibleProductFixedCost());
        edibleProductsInventory.setEdibleProductSellingPrice(discountedPrice);
        edibleProductsInventory.setEdibleProductInventoryExpiry(expiryDate);
        edibleProductsInventory.setEdibleProductInventoryAddedBy(edibleProductAddedBy);
        edibleProductsInventory.setEdibleProductInventoryAddedOn(LocalDateTime.now());
        edibleProductsInventory.setEdibleProductInventoryQtyAdded(newEdibleProduct.getEdibleProductQuantity());
        edibleProductsInventory.setEdibleProductSubId(subid);

        edibleProductsInventoryRepository.save(edibleProductsInventory);

        List<Object> res = new ArrayList<>();

        res.add(edibleProducts);
        res.add(edibleProductsInventory);

        return ResponseEntity.status(201).body(
            createResponse.createSuccessResponse(
                200,
                "Product created",
                res
                )
        );
    }

}
