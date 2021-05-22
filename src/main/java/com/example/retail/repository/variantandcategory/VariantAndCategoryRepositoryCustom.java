package com.example.retail.repository.variantandcategory;

import java.util.List;

public interface VariantAndCategoryRepositoryCustom {
    int addVariants(String itemCategorySubId, List<String> variantList);
}
