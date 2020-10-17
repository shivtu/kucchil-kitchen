package com.example.retail.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CreateResponse {

    @Autowired
    ErrorResponse errorResponse;

    @Autowired
    SuccessResponse successResponse;

    @Autowired
    ValidationResponse validationResponse;

    @Autowired
    OpsResponse opsResponse;

    public ErrorResponse createErrorResponse (int errorCode, String errorMessage, String additionalInfo){
        errorResponse.setStatusCode(errorCode);
        errorResponse.setStatusMessage(errorMessage);
        errorResponse.setAdditionalInfo(additionalInfo);

        return errorResponse;
    }

    public SuccessResponse createSuccessResponse (int successCode, String successMessage, Object result) {
        successResponse.setStatusCode(successCode);
        successResponse.setStatusMessage(successMessage);
        successResponse.setResult(result);
        return successResponse;
    }

    public ValidationResponse createValidationResponse (int statusCode, String statusMessage, String additionalInfo, Object additionalObjectsReturned) {
        validationResponse.setStatusCode(statusCode);
        validationResponse.setStatusMessage(statusMessage);
        validationResponse.setAdditionalInfo(additionalInfo);
        validationResponse.setAdditionalObjectsReturned(additionalObjectsReturned);
        return validationResponse;
    }

    public OpsResponse createOpsResponse(int statusCode, String statusMessage, String additionalInfo, List<String> statusArray,
                                         Map<String, Object> statusMap) {
        opsResponse.setStatusCode(statusCode);
        opsResponse.setStatusMessage(statusMessage);
        opsResponse.setAdditionalInfo(additionalInfo);
        opsResponse.setStatusArray(statusArray);
        opsResponse.setStatusMap(statusMap);

        return opsResponse;
    }
}
