package com.example.retail.util;

import org.springframework.stereotype.Component;

@Component
public class ValidationResponse {

    private int statusCode;
    private String statusMessage;
    private String additionalInfo;
    private Object additionalObjectsToReturned;

    public ValidationResponse() {}

    public ValidationResponse(int statusCode, String statusMessage, String additionalInfo, Object additionalObjectsToReturned) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.additionalInfo = additionalInfo;
        this.additionalObjectsToReturned = additionalObjectsToReturned;
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

    public Object getAdditionalObjectsToReturned() {
        return additionalObjectsToReturned;
    }

    public void setAdditionalObjectsToReturned(Object additionalObjectsToReturned) {
        this.additionalObjectsToReturned = additionalObjectsToReturned;
    }
}
