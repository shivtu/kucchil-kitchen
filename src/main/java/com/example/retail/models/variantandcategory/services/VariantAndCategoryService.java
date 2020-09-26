package com.example.retail.models.variantandcategory.services;

import com.example.retail.models.variantandcategory.VariantAndCategory;
import com.example.retail.models.variantandcategory.repository.VariantAndCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class VariantAndCategoryService {

    @Autowired
    VariantAndCategoryRepository variantAndCategoryRepository;

    public VariantAndCategory save(VariantAndCategory variantAndCategory) {
        return variantAndCategoryRepository.save(variantAndCategory);
    }

    public Optional<VariantAndCategory> findBySubId (String itemCategorySubId) {
        return variantAndCategoryRepository.findBySubId(itemCategorySubId);
    }

    public Integer addVariants(String itemCategorySubId, List<String> variantList) {
        return variantAndCategoryRepository.updateVariantList(variantList, itemCategorySubId);
    }
}