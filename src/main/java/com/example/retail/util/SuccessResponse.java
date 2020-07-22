package com.example.retail.util;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SuccessResponse {
    private int statusCode;
    private String statusMessage;
    private List<Object> result;

    public SuccessResponse() {}

    public SuccessResponse(int statusCode, String statusMessage, List<Object> result) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.result = result;
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

    public List<Object> getResult() {
        return result;
    }

    public void setResult(List<Object> result) {
        this.result = result;
    }
}