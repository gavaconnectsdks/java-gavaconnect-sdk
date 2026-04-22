package gavaconnectsdks.com.github.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.utils.enums.CustomDeclarationStatus;

public class CustDecStatusCheckerResponse {
    @JsonProperty(value="response_code")
    private String ResponseCode;

    @JsonProperty(value="status")
    private CustomDeclarationStatus Status;

    public void setResponseCode(String ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public void setStatus(CustomDeclarationStatus Status) {
        this.Status = Status;
    }

    public String getResponseCode() {
        return this.ResponseCode;
    }

    public CustomDeclarationStatus getStatus() {
        return this.Status;
    }

    
}
