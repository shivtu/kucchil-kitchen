package com.example.retail.util;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class OpsResponse {

    private int statusCode;
    private String statusMessage;
    private String additionalInfo;
    private List<String> statusArray;
    private Map<String, Object> statusMap;

    public OpsResponse() {}

    public OpsResponse(int statusCode, String statusMessage, String additionalInfo, List<String> statusArray, Map<String, Object> statusMap) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.additionalInfo = additionalInfo;
        this.statusArray = statusArray;
        this.statusMap = statusMap;
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

    public List<String> getStatusArray() {
        return statusArray;
    }

    public void setStatusArray(List<String> statusArray) {
        this.statusArray = statusArray;
    }

    public Map<String, Object> getStatusMap() {
        return statusMap;
    }

    public void setStatusMap(Map<String, Object> statusMap) {
        this.statusMap = statusMap;
    }
}
