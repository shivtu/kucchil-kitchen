package com.example.retail.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;
    private String additionalInfo;

    public ErrorResponse() {}

    public ErrorResponse(int errorCode, String errorMessage, String additionalInfo) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.additionalInfo = additionalInfo;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }
}
