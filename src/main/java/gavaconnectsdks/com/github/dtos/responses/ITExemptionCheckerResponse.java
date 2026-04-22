package gavaconnectsdks.com.github.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ITExemptionCheckerResponse {
    @JsonProperty(value="response_message")
    private String responseMessage;

    @JsonProperty(value="response_code")
    private String responseCode;

    @JsonProperty(value="status_code")
    private String statuscode;

    @JsonProperty(value="cert_no")
    private String certificateNumber;

    @JsonProperty(value="cert_expiry_date")
    private String certificateExpiryDate;

    @JsonProperty(value="cert_eff_date")
    private String certificateEffectiveDate;

    @JsonProperty(value="cert_issue_date")
    private String certificateIssueDate;

    public void setCertificateEffectiveDate(String certificateEffectiveDate) {
        this.certificateEffectiveDate = certificateEffectiveDate;
    }

    public void setCertificateExpiryDate(String certificateExpiryDate) {
        this.certificateExpiryDate = certificateExpiryDate;
    }

    public void setCertificateIssueDate(String certificateIssueDate) {
        this.certificateIssueDate = certificateIssueDate;
    }

    public void setCertificateNumber(String certificateNumber) {
        this.certificateNumber = certificateNumber;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public void setStatuscode(String statuscode) {
        this.statuscode = statuscode;
    }

    public String getCertificateEffectiveDate() {
        return this.certificateEffectiveDate;
    }

    public String getCertificateExpiryDate() {
        return this.certificateExpiryDate;
    }

    public String getCertificateIssueDate() {
        return this.certificateIssueDate;
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getResponseMessage() {
        return this.responseMessage;
    }

    public String getStatuscode() {
        return this.statuscode;
    }

}
