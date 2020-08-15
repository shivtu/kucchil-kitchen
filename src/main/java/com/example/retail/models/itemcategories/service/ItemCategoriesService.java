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

    public ResponseEntity<Object> findItemCategoryByClassification(String itemClassification) {

        try{
            Optional<ItemCategories> res = itemCategoriesRepository.findItemCategoryByClassification(itemClassification);
            List<Object> finalRes = new ArrayList<>();
            finalRes.add(res);

            if (res.isPresent()) {
                return ResponseEntity.status(200).body(
                        createResponse.createSuccessResponse(200, "Record found", finalRes)
                );
            } else {
                return ResponseEntity.status(404).body(
                        createResponse.createSuccessResponse(404, "Record not found", finalRes)
                );
            }

        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }

    }

    public ResponseEntity<Object> createItemCategory(HttpServletRequest request, ItemCategories newItemCategory) {
        try{
            LocalDateTime lastUpdatedOn = LocalDateTime.now();
            String lastUpdatedBy = jwtDetails.userName(request);

            newItemCategory.setItemCategoryLastUpdatedBy(lastUpdatedBy);
            newItemCategory.setItemCategoryLastUpdatedOn(lastUpdatedOn);

            ItemCategories createdItemCategory = itemCategoriesRepository.save(newItemCategory);

            List<Object> finalRes = new ArrayList<>();
            finalRes.add(createdItemCategory);

            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(201, "Item category created", finalRes)
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(500, e.getMessage(), "NA")
            );
        }

    }
}
