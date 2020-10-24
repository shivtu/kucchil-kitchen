package com.example.retail.util;

import com.example.retail.controllers.retailer.fmcg_retailer.FMCGProductsRequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Component
public class Utils {

    @Autowired
   CreateResponse createResponse;

    @Autowired
    Constants constants;

    final public int opsSuccess = 1;
    final public String defaultSwitchCase = "This operation is not provisioned";

    private OpsResponse saveProductImage (List<MultipartFile> images, String folderName) throws IOException{

            final List<String> savedFileResArray = new ArrayList<>();
            for (MultipartFile mf : images) {
                long productImageMaxSizeBytes = 30000L;
                if (mf.getSize() > productImageMaxSizeBytes) {
                    String productImageSizeError = "File size not allowed";
                    return createResponse.createOpsResponse(400, productImageSizeError, "Allowed size is less than " + productImageSizeError,
                            null, null);
                } else {
                    String imageNamePrefix = LocalDateTime.now().toString();
                    String savedImagePath = "src/main/resources/assets/"+folderName;
                    String imageLocation = new File(savedImagePath).getAbsolutePath() + "/" + imageNamePrefix + mf.getOriginalFilename();
                    FileOutputStream fout = new FileOutputStream(imageLocation);
                    fout.write(mf.getBytes());
                    fout.close();
                    savedFileResArray.add(imageLocation);
                    return createResponse.createOpsResponse(opsSuccess, "File saved", "NA",
                            savedFileResArray, null);
                }
            }
        String saveImageError = "Unable to save file";
        return createResponse.createOpsResponse(500, "Unable to save image", saveImageError, null, null);
    }

    public OpsResponse saveFiles(List<MultipartFile> images, String caseType) throws IOException {
        switch(caseType) {
            case "vegitableImages":
                return saveProductImage(images, constants.vegitableImageLocationFolderName);
            case "edibleProductImages":
                return saveProductImage(images, constants.edibleProductImageLocationFolderName);
            case "FMCGProductImages":
                return saveProductImage(images, constants.FMCGProductImageLocationFolderName);
            default:
                return createResponse.createOpsResponse(
                    422,
                    defaultSwitchCase,
                    "NA",
                    null,
                    null
                );
        }
    }

    public Float calcLoyaltyDiscount () {

        /* TODO:
            loayalty points = average sales / 12
            average sales = total sales / number of orders
            CONSTRAINTS : atleast 3 orders or 1 order per month in the last 3 months
         */
        return 0F;
    }

    public String createItemCategorySubId (String itemCategory, String itemSubCategory) {
        return itemCategory.toLowerCase() +"-" + itemSubCategory.toLowerCase();
    }

    public String createVegitableSubId (String vegitableName, String vegitableVariant, Float vegitableInventoryFixedCost, Float vegitableInventoryCostPrice) {
        return vegitableName.toLowerCase() + "-" + vegitableVariant.toLowerCase() + "-" + vegitableInventoryFixedCost.toString() + "-" + vegitableInventoryCostPrice.toString();
    }

    public String createEdibleProductSubId(
            String edibleProductManufacturer,
            String edibleProductName,
            String edibleProductVariant,
            String edibleProductFlavor,
            Float edibleProductDenomination,
            LocalDate edibleProductInventoryExpiry
    ) {
        return edibleProductManufacturer.toLowerCase()
                + edibleProductName.toLowerCase()
                + edibleProductVariant.toLowerCase()
                + edibleProductFlavor.toLowerCase()
                + edibleProductDenomination.toString().toLowerCase()
                + edibleProductInventoryExpiry.toString().toLowerCase();
    }

    public String createFMCGProductSubId (
            String manufacturerName, String productName, String variant, Float denomination, Float costPrice,
            Float fixedCost) {

        return manufacturerName.toLowerCase() + productName.toLowerCase() + variant.toLowerCase() + denomination.toString()
            + costPrice.toString() + fixedCost.toString();
    }

    public Map<String, Object> buildStringListMap (String key, Object value) {
        Map<String, Object> res = new HashMap<>();
        res.put(key, value);
        return res;
    }
}
