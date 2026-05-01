package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.dtos.TCCData;

public class TccCheckerResponse {

    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Status")
    private String status;

    @JsonProperty(value="TCCData")
    private TCCData taxComplianceCertificateData;

    public String getMessage() {
        return this.message;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.status;
    }

    public TCCData getTaxComplianceCertificateData() {
        return this.taxComplianceCertificateData;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTaxComplianceCertificateData(TCCData taxComplianceCertificateData) {
        this.taxComplianceCertificateData = taxComplianceCertificateData;
    }

    
    
    
}
