package com.example.retail.models.itemcategories.service;

import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.models.itemcategories.repository.ItemCategoriesRepository;
import com.example.retail.util.CreateResponse;
import com.example.retail.util.JWTDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ItemCategoriesService {

    @Autowired
    ItemCategoriesRepository itemCategoriesRepository;

    @Autowired
    CreateResponse createResponse;

    @Autowired
    JWTDetails jwtDetails;

    public ItemCategories createItemCategory(HttpServletRequest request, ItemCategories newItemCategory) {

        LocalDateTime lastUpdatedOn = LocalDateTime.now();
        String lastUpdatedBy = jwtDetails.userName(request);

        newItemCategory.setItemCategoryLastUpdatedBy(lastUpdatedBy);
        newItemCategory.setItemCategoryLastUpdatedOn(lastUpdatedOn);

        return itemCategoriesRepository.save(newItemCategory);
    }

    public Optional<ItemCategories> findItemClassificationByCode(String itemClassificationCode) {
        return itemCategoriesRepository.findItemCategoryByClassificationCode(itemClassificationCode);
    }
}
