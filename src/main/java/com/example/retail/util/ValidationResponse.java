package com.example.retail.util;

import org.springframework.stereotype.Component;

@Component
public class ValidationResponse {

    private int statusCode;
    private String statusMessage;
    private String additionalInfo;

    public ValidationResponse() {}

    public ValidationResponse(int statusCode, String statusMessage, String additionalInfo) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.additionalInfo = additionalInfo;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
