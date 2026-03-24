package gavaconnectsdks.com.github.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VatExcemptionCheckerResponse {
    @JsonProperty(value="response_message")
    private String responseMessage;

    @JsonProperty(value="response_code")
    private String responseCode;

    List<VatExcemptionCertificateDetail> vatExcemptionCertificateDetails;

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setVatExcemptionCertificateDetails(List<VatExcemptionCertificateDetail> vatExcemptionCertificateDetails) {
        this.vatExcemptionCertificateDetails = vatExcemptionCertificateDetails;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public List<VatExcemptionCertificateDetail> getVatExcemptionCertificateDetails() {
        return this.vatExcemptionCertificateDetails;
    }

    
}
