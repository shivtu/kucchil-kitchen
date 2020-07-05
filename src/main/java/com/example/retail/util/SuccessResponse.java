package com.example.retail.util;

import org.springframework.stereotype.Component;

@Component
public class SuccessResponse {
    private int successCode;
    private String successMessage;
    private String additionalInfo;

    public SuccessResponse() {}

    public SuccessResponse(int responseCode, String message, String additionalInfo) {
        this.successCode = responseCode;
        this.successMessage = message;
        this.additionalInfo = additionalInfo;
    }

    public int getResponseCode() {
        return successCode;
    }

    public void setResponseCode(int responseCode) {
        this.successCode = responseCode;
    }

    public String getMessage() {
        return successMessage;
    }

    public void setMessage(String message) {
        this.successMessage = message;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}