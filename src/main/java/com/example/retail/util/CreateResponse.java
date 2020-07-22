package com.example.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CreateResponse {

    @Autowired
    ErrorResponse errorResponse;

    @Autowired
    SuccessResponse successResponse;

    public ErrorResponse createErrorResponse (int errorCode, String errorMessage, String additionalInfo){
        errorResponse.setStatusCode(errorCode);
        errorResponse.setStatusMessage(errorMessage);
        errorResponse.setAdditionalInfo(additionalInfo);

        return errorResponse;
    }

    public SuccessResponse createSuccessResponse (int successCode, String successMessage, List<Object> result) {
        successResponse.setStatusCode(successCode);
        successResponse.setStatusMessage(successMessage);
        successResponse.setResult(result);
        return successResponse;
    }
}
