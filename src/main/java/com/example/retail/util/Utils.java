package com.example.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.util.*;

@Component
public class Utils {

    private static Utils utilInstance = new Utils();

    private Utils (){}

    public static Utils getUtilInstance() {
        return utilInstance;
    }

    @Autowired
   CreateResponse createResponse;

    final public String vegSaveImageError = "Unable to save file";
    final public String vegSaveImageTypeError = "File type not allowed";
    final public String vegSaveImageSuccess = "Image saved";
    final public String vegImageSizeError = "File size not allowed";
    final public Long vegImageMaxSizeBytes = 30000L;
    final public int opsSuccess = 1;
    final public String imagesLocationKey = "imagesLocation";
    final public String defaultSwitchCase = "This operation is not provisioned";

    public ResponseEntity<Object> saveFiles(ArrayList<MultipartFile> images, String caseType) {
        switch(caseType) {
            case "vegitableImages":
                final ArrayList<String> userFiles = new ArrayList<>();
                try {
                    for(MultipartFile mf: images) {
                        if (Objects.equals(mf.getContentType(), "image/jpeg") || Objects.equals(mf.getContentType(), "image/png")) {
                            if (mf.getSize() > vegImageMaxSizeBytes) {
                                return ResponseEntity.status(0).body(createResponse.createErrorResponse(
                                        400,
                                        vegImageSizeError,
                                        "File size cannot exceed " + vegImageMaxSizeBytes
                                ));
                            } else {
                                String imageNamePrefix = LocalDateTime.now().toString();
                                String imageLocation = new File("src/main/resources/assets/veg-images").getAbsolutePath() + "/" + imageNamePrefix + mf.getOriginalFilename();
                                FileOutputStream fout = new FileOutputStream(imageLocation);
                                fout.write(mf.getBytes());
                                fout.close();
                                ResponseEntity.status(1).body(new ArrayList<String>(Collections.singleton(imageLocation)));
                            }
                        } else {
                            return ResponseEntity.status(0).body(
                                    createResponse.createErrorResponse(
                                            400,
                                            vegSaveImageTypeError,
                                            "Allowed types are jpeg and png"
                                    )
                            );
                        }
                    }
                } catch (Exception e) {
                    return ResponseEntity.status(1).body(
                            createResponse.createErrorResponse(
                                    500,
                                    e.getMessage(),
                                    "Unable to save file"
                            )
                    );
                }

            default:
                return ResponseEntity.status(422).body(createResponse.createErrorResponse(
                        422,
                        defaultSwitchCase,
                        ""
                ));
        }

    }
}
