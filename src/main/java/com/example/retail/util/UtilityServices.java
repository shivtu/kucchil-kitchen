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

    public List<?> findAllUtilities () {
        List<Taxes> taxes = taxService.findAll();
        List<CustomerOrdersDiscount> customerOrdersDiscounts = customerOrdersDiscountServices.findAllDiscounts();
        List<ItemCategories> itemCategories = itemCategoriesService.findAll();
        List <DeliveryCharges> deliveryCharges = deliveryChargeServices.findAll();

        int count = taxes.size() + customerOrdersDiscounts.size() + itemCategories.size() + deliveryCharges.size();

        Map<String, Object> res = new HashMap<>();

        res.put("taxes", taxes);
        res.put("customerOrdersDiscounts", customerOrdersDiscounts);
        res.put("itemCategories", itemCategories);
        res.put("deliveryCharges", deliveryCharges);

        List<Map<String, Object>> finalRes = new ArrayList<>();
        finalRes.add(res);

        return finalRes;
    }

    public List<?> findAllProducts() {

            List<Vegitables> vegitables = vegitablesService.findAllVegitables();
            List<FMCGProducts> fmcgProducts = fmcgProductsServices.findAll();
            List<EdibleProducts> edibleProducts = edibleProductsService.findAll();
            // TODO: write method to find all nonVeg products
            List<NonVegProducts> nonVegProducts = null;

            Map<String, Object>  res = new HashMap<>();
            res.put("vegitables", vegitables);
            res.put("FMCGProducts", fmcgProducts);
            res.put("edibleProducts", edibleProducts);

            List<Object> finalRes = new ArrayList<>();
            finalRes.add(res);

            return finalRes;
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
