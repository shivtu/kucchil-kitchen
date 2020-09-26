package com.example.retail.controllers.retailer.itemcategory_retailer;

import com.example.retail.models.itemcategories.ItemCategories;
import com.example.retail.models.itemcategories.service.ItemCategoriesService;
import com.example.retail.util.CreateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/retailer/itemCategory")
public class ItemCategoryRetailerController {

    @Autowired
    ItemCategoriesService itemCategoriesService;

    @Autowired
    CreateResponse createResponse;

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> createItemCategory(HttpServletRequest request, @RequestBody ItemCategories newItemCategory) {
        try {
            ItemCategories result = itemCategoriesService.createItemCategory(request, newItemCategory);
            List<ItemCategories> itemCategoriesList = new ArrayList<ItemCategories>();
            itemCategoriesList.add(result);
            return ResponseEntity.status(201).body(
                    createResponse.createSuccessResponse(
                            201,
                            "Created",
                            itemCategoriesList
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(500).body(
                    createResponse.createErrorResponse(
                            500,
                            e.getMessage(),
                            "NA"
                    )
            );
        }
    }
}
