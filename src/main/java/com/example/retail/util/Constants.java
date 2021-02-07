package com.example.retail.util;

import org.springframework.stereotype.Component;

@Component
public class Constants {
    public final String edibleProduct = "edibleProduct";
    public final String edibleProductList = "edibleProductsList";
    public final String edibleProductInventory = "edibleProductInventory";
    public final String edibleProductInventoryList = "edibleProductInventoryList";
    public final String edibleProductAndInventoryList = "edibleProductAndInventoryList";
    public final String vegetable = "vegetable";
    public final String vegetableList = "vegetablesList";
    public final String vegetableInventory = "vegetableInventory";
    public final String vegetableInventoryList = "vegetableInventoryList";
    public final String vegetableAndInventoryList = "vegetableAndInventoryList";
    public final String FMCGProduct = "FMCGProduct";
    public final String FMCGProductList = "FMCGProductList";
    public final String FMCGProductInventory = "FMCGProductInventory";
    public final String FMCGProductInventoryList = "FMCGProductInventoryList";
    public final String FMCGProductAndInventoryList = "FMCGProductAndInventoryList";
    public final String nonVegProduct = "nonVegProduct";
    public final String nonVegProductList = "nonVegProductList";
    public final String nonVegProductInventory = "nonVegProductInventory";
    public final String nonVegProductInventoryList = "nonVegProductInventoryList";
    public final String customerOrderDiscount = "customerOrderDiscount";
    public final String taxes = "taxes";
    public final String itemCategories = "itemCategories";
    public final String deliveryCharges = "deliveryCharges";
    public final String allProducts = "allProducts";
    public final String utilities = "utilities";

    // Image locatoin strings
    public final String FMCGProductImageLocationFolderName = "fmcg-product-images";
    public final String vegetableImageLocationFolderName = "edible-product-images";
    public final String edibleProductImageLocationFolderName = "edible-product-images";

    // Save image switch case type
    public final String saveImageSwitchCaseVegetables = "vegetableImages";
    public final String saveImageSwitchCaseFMCGProducts = "FMCGProductImages";
    public final String saveImageSwitchCaseEdibleProducts = "edibleProductImages";

    public final String result = "result";
}
