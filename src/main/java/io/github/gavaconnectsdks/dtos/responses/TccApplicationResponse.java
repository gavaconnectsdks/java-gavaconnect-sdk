package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TccApplicationResponse {
    @JsonProperty("ResponseCode")
    private String responseCode;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("AckNumber")
    private String acknowledgmentNumber;

    @JsonProperty("TCCNumber")
    private String taxComplianceCertificateNumber;

    

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setAcknowledgmentNumber(String acknowledgmentNumber) {
        this.acknowledgmentNumber = acknowledgmentNumber;
    }

    public String getAcknowledgmentNumber() {
        return this.acknowledgmentNumber;
    }

    public String getMessage() {
        return this.message;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.status;
    }

    public String getTaxComplianceCertificateNumber() {
        return this.taxComplianceCertificateNumber;
    }

    public void setTaxComplianceCertificateNumber(String taxComplianceCertificateNumber) {
        this.taxComplianceCertificateNumber = taxComplianceCertificateNumber;
    }

    
    
}
