package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.utils.enums.CustomDeclarationStatus;

public class CustDecStatusCheckerResponse {
    @JsonProperty(value="response_code")
    private String responseCode;

    @JsonProperty(value="status")
    private CustomDeclarationStatus status;

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStatus(CustomDeclarationStatus status) {
        this.status = status;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public CustomDeclarationStatus getStatus() {
        return this.status;
    }

    
}
