package com.example.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;

@Component
public class Utils {

    public String vegSaveImageError = "Unable to save file";
    public String vegSaveImageTypeError = "File type not allowed";
    public String vegSaveImageSuccess = "Image saved";
    public String vegImageSizeError = "File size not allowed";
    public Long vegImageMaxSizeBytes = 30000L;
    public int opsSuccess = 200;
    public String imagesLocationKey = "imagesLocation";

    public OpsResponse saveVegitableImages(ArrayList<MultipartFile> images) {
        final ArrayList userFiles = new ArrayList();
        final OpsResponse opsResponse = new OpsResponse();
        try {
            for(MultipartFile mf: images) {
                if (mf.getContentType().equals("image/jpeg") || mf.getContentType().equals("image/png")) {
                    if(mf.getSize() > vegImageMaxSizeBytes) {
                        opsResponse.setResponseCode(422);
                        opsResponse.setResponseMessage(vegImageSizeError);
                        opsResponse.setOpsResponseArray(userFiles);
                        break;
                    } else {
                        String imageLocation = new File("ProductImages").getAbsolutePath() + "\\" + mf.getOriginalFilename();
                        FileOutputStream fout = new FileOutputStream(imageLocation);
                        fout.write(mf.getBytes());
                        fout.close();
                        userFiles.add(imageLocation);
                        opsResponse.setResponseCode(opsSuccess);
                        opsResponse.setResponseMessage(vegSaveImageSuccess);
                        opsResponse.setOpsResponseArray(userFiles);
                    }
                } else {
                    opsResponse.setResponseCode(422);
                    opsResponse.setResponseMessage(vegSaveImageTypeError);
                    opsResponse.setOpsResponseArray(userFiles);
                    break;
                }
            }
            return opsResponse;
        } catch (Exception e) {
            opsResponse.setResponseCode(500);
            opsResponse.setResponseMessage(vegSaveImageError);
            return opsResponse;
        }

    }
}
