package com.example.retail.util;

import com.example.retail.models.deliveryutility.DeliveryCharges;
import com.example.retail.models.deliveryutility.services.DeliveryChargeServices;
import com.example.retail.models.discounts.CustomerOrdersDiscount;
import com.example.retail.models.discounts.services.CustomerOrdersDiscountServices;
import com.example.retail.models.edibleproducts.EdibleProducts;
import com.example.retail.models.edibleproducts.services.EdibleProductsService;
import com.example.retail.models.fmcgproducts.FMCGProducts;
import com.example.retail.models.fmcgproducts.services.FMCGProductsServices;
import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.models.itemcategories.service.ItemCategoriesService;
import com.example.retail.models.nonvegproducts.NonVegProducts;
import com.example.retail.models.nonvegproducts.services.NonVegProductsService;
import com.example.retail.models.taxutility.Taxes;
import com.example.retail.models.taxutility.services.TaxService;
import com.example.retail.models.variantandcategory.VariantAndCategory;
import com.example.retail.models.variantandcategory.services.VariantAndCategoryService;
import com.example.retail.models.vegitables.Vegitables;
import com.example.retail.models.vegitables.services.VegitablesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    VegitablesService vegitablesService;

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

            List<?> vegitablesAndInventory = vegitablesService.findAllVegitablesWithInventory();
            List<?> fmcgProducts = fmcgProductsServices.findAllFMCGProductsWithInventory();
            List<?> edibleProducts = edibleProductsService.findAllEdibleProductsWithInventory();
            // TODO: write method to find all nonVeg products
            List<NonVegProducts> nonVegProducts = new ArrayList<>();

            Map<String, List<?>> res = new HashMap<>();

            res.put(constants.vegitableAndInventoryList, vegitablesAndInventory);
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
