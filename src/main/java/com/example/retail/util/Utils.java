package com.example.retail.util;

import com.example.retail.users.SignUpRequestBody;
import com.example.retail.users.profiles.UsersProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.swing.text.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;

import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Component
public class Utils {

    private static Utils utilInstance = new Utils();

    private Utils (){}

    public static Utils getUtilInstance() {
        return utilInstance;
    }

    @Autowired
    OpsResponse opsResponse;

    final public String vegSaveImageError = "Unable to save file";
    final public String vegSaveImageTypeError = "File type not allowed";
    final public String vegSaveImageSuccess = "Image saved";
    final public String vegImageSizeError = "File size not allowed";
    final public Long vegImageMaxSizeBytes = 30000L;
    final public int opsSuccess = 1;
    final public String imagesLocationKey = "imagesLocation";
    final public String defaultSwitchCase = "This operation is not provisioned";

    public OpsResponse setFileSaveError (int errorCode, String errorMessage) {
        opsResponse.setResponseCode(errorCode);
        opsResponse.setResponseMessage(errorMessage);
        return opsResponse;
    }

    public OpsResponse saveFiles(ArrayList<MultipartFile> images, String caseType) {
        switch(caseType) {
            case "vegitableImages":
                final ArrayList<String> userFiles = new ArrayList<>();
                try {
                    for(MultipartFile mf: images) {
                        if (Objects.equals(mf.getContentType(), "image/jpeg") || Objects.equals(mf.getContentType(), "image/png")) {
                            if(mf.getSize() > vegImageMaxSizeBytes) {
                                return setFileSaveError(422, vegImageSizeError);
                            } else {
                                String imageNamePrefix = LocalDateTime.now().toString();
                                String imageLocation = new File("src/main/resources/assets/veg-images").getAbsolutePath()+"/" +imageNamePrefix+ mf.getOriginalFilename();
                                FileOutputStream fout = new FileOutputStream(imageLocation);
                                fout.write(mf.getBytes());
                                fout.close();
                                userFiles.add(imageLocation);
                                opsResponse.setResponseCode(opsSuccess);
                                opsResponse.setResponseMessage(vegSaveImageSuccess);
                                opsResponse.setOpsResponseArray(userFiles);
                            }
                        } else {
                            return setFileSaveError(422, vegSaveImageTypeError);
                        }
                    }
                    return opsResponse;
                } catch (Exception e) {
                    return setFileSaveError(500, vegSaveImageError);
                }

            default:
                return setFileSaveError(400, defaultSwitchCase);
        }

    }
}
