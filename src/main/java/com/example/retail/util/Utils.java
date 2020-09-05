package com.example.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Component
public class Utils {

//    private static Utils utilInstance = new Utils();
//
//    private Utils (){}
//
//    public static Utils getUtilInstance() {
//        return utilInstance;
//    }

    @Autowired
   CreateResponse createResponse;

    final public String vegSaveImageError = "Unable to save file";
    final public String vegSaveImageTypeError = "File type not allowed";
    final public String vegImageSizeError = "File size not allowed";
    final public Long vegImageMaxSizeBytes = 30000L;
    final public int opsSuccess = 1;
    private String savedImagePath = "src/main/resources/assets/veg-images";
    final public String defaultSwitchCase = "This operation is not provisioned";

    public OpsResponse saveFiles(ArrayList<MultipartFile> images, String caseType) {
        switch(caseType) {
            case "vegitableImages":
                try {
                    final List<String> savedFileResArray = new ArrayList<>();
                    for (MultipartFile mf : images) {
                        if (Objects.equals(mf.getContentType(), "image/jpeg") || Objects.equals(mf.getContentType(), "image/png")) {
                            if (mf.getSize() > vegImageMaxSizeBytes) {
                                return createResponse.createOpsResponse(400, vegImageSizeError, "Allowed size is less than " + vegImageMaxSizeBytes,
                                        null, null);
                            } else {
                                String imageNamePrefix = LocalDateTime.now().toString();
                                String imageLocation = new File(savedImagePath).getAbsolutePath() + "/" + imageNamePrefix + mf.getOriginalFilename();
                                FileOutputStream fout = new FileOutputStream(imageLocation);
                                fout.write(mf.getBytes());
                                fout.close();
                                savedFileResArray.add(imageLocation);
                                return createResponse.createOpsResponse(opsSuccess, "File saved", "NA",
                                        savedFileResArray, null);
                            }
                        } else {
                            return createResponse.createOpsResponse(400, vegSaveImageTypeError,
                                    "Allowed types are jpeg and png", null, null
                            );
                        }
                    }
                } catch (Exception e) {
                    return createResponse.createOpsResponse(500, e.getMessage(), vegSaveImageError, null, null);
                }
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
}
