package com.example.retail.models.variantandcategory.repository;

import java.util.List;

public interface VariantAndCategoryRepositoryCustom {
    int addVariants(String itemCategorySubId, List<String> variantList);
}
