package com.example.retail.util;

import org.springframework.stereotype.Component;

@Component
public class SuccessResponse {
    private int responseCode;
    private String message;
    private String additionalInfo;

    public SuccessResponse() {}

    public SuccessResponse(int responseCode, String message, String additionalInfo) {
        this.responseCode = responseCode;
        this.message = message;
        this.additionalInfo = additionalInfo;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}