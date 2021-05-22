package com.example.retail.util;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.services.deliveryutility.DeliveryChargeServices;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.services.discounts.CustomerOrdersDiscountServices;
import com.example.retail.services.edibleproducts.EdibleProductsService;
import com.example.retail.services.fmcgproducts.FMCGProductsServices;
import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.services.itemcategories.ItemCategoriesService;
import com.example.retail.models.nonvegproducts.NonVegProducts;
import com.example.retail.services.nonvegproducts.NonVegProductsService;
import com.example.retail.models.taxutility.Taxes;
import com.example.retail.services.taxutility.TaxService;
import com.example.retail.services.variantandcategory.VariantAndCategoryService;
import com.example.retail.services.vegetables.VegetablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UtilityServices {

    @Autowired
    TaxService taxService;

    @Autowired
    CustomerOrdersDiscountServices customerOrdersDiscountServices;

    @Autowired
    ItemCategoriesService itemCategoriesService;

    @Autowired
    DeliveryChargeServices deliveryChargeServices;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    VariantAndCategoryService variantAndCategoryService;

    @Autowired
    VegetablesService vegetablesService;

    @Autowired
    FMCGProductsServices fmcgProductsServices;

    @Autowired
    EdibleProductsService edibleProductsService;

    @Autowired
    NonVegProductsService nonVegProductsService;

    @Autowired
    Constants constants;

    @Autowired
    Utils utils;

    public Map<String, List<?>> findAllUtilities () {
        List<Taxes> taxes = taxService.findAll();
        List<CustomerOrdersDiscount> customerOrdersDiscounts = customerOrdersDiscountServices.findAllDiscounts();
        List<ItemCategories> itemCategories = itemCategoriesService.findAll();
        List <DeliveryCharges> deliveryCharges = deliveryChargeServices.findAll();

        Map<String, List<?>> res = new HashMap<>();
        res.put(constants.taxes, taxes);
        res.put(constants.customerOrderDiscount, customerOrdersDiscounts);
        res.put(constants.itemCategories, itemCategories);
        res.put(constants.deliveryCharges, deliveryCharges);

        return res;
    }

    public Map<String, List<?>> findAllProducts() {

            List<?> vegetablesAndInventory = vegetablesService.findAllVegetablesWithInventory();
            List<?> fmcgProducts = fmcgProductsServices.findAllFMCGProductsWithInventory();
            List<?> edibleProducts = edibleProductsService.findAllEdibleProductsWithInventory();
            // TODO: write method to find all nonVeg products
            List<NonVegProducts> nonVegProducts = new ArrayList<>();

            Map<String, List<?>> res = new HashMap<>();

            res.put(constants.vegetableAndInventoryList, vegetablesAndInventory);
            res.put(constants.FMCGProductAndInventoryList, fmcgProducts);
            res.put(constants.edibleProductAndInventoryList,edibleProducts);
            res.put(constants.nonVegProductInventoryList, nonVegProducts);

            return res;
    }

//    public ResponseEntity<?> findAllVariantsBySubId (String itemCategorySubId) {
//        Optional<VariantAndCategory> variantAndCategory = variantAndCategoryService.findBySubId(itemCategorySubId);
//        int resSize = variantAndCategory.get().getVariantsList().size();
//        List<String> res = new ArrayList<>(variantAndCategory.get().getVariantsList());
//        return ResponseEntity.status(200).body(
//            createResponse.createSuccessResponse(
//                200,
//                "Found " + resSize + " results",
//                res
//            )
//        );
//    }
}
