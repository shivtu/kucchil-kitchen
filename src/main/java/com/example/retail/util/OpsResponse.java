package com.example.retail.util;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
@Component
public class OpsResponse {

    private int responseCode;
    private String responseMessage;
    private HashMap responseObject;
    private ArrayList opsResponseArray;

    public OpsResponse(){}

    public OpsResponse(int responseCode, String responseMessage, HashMap responseObject, ArrayList opsResponseArray) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseObject = responseObject;
        this.opsResponseArray = opsResponseArray;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public HashMap getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(HashMap responseObject) {
        this.responseObject = responseObject;
    }

    public ArrayList getOpsResponseArray() {
        return opsResponseArray;
    }

    public void setOpsResponseArray(ArrayList opsResponseArray) {
        this.opsResponseArray = opsResponseArray;
    }
}
