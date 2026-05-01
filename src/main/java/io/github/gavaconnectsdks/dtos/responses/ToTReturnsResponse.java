package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ToTReturnsResponse {
    @JsonProperty("ResponseCode")
    private String respondeCode;

    @JsonProperty("Message")
    private String message;

    @JsonProperty("Status")
    private String status;

    @JsonProperty("AckNumber")
    private String acknowldegementNumber;

    @JsonProperty("PRN")
    private String paymentReferenceRNumber;

    @JsonProperty("ComputedTax")
    private Float computedTax;

    @JsonProperty("UtilizedCredit")
    private Float utilizedCredit;

    @JsonProperty("TaxPayable")
    private Float taxPayable;

    public void setAcknowldegementNumber(String acknowldegementNumber) {
        this.acknowldegementNumber = acknowldegementNumber;
    }

    public void setComputedTax(Float computedTax) {
        this.computedTax = computedTax;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPaymentReferenceRNumber(String paymentReferenceRNumber) {
        this.paymentReferenceRNumber = paymentReferenceRNumber;
    }

    public void setRespondeCode(String respondeCode) {
        this.respondeCode = respondeCode;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTaxPayable(Float taxPayable) {
        this.taxPayable = taxPayable;
    }

    public void setUtilizedCredit(Float utilizedCredit) {
        this.utilizedCredit = utilizedCredit;
    }

    public String getAcknowldegementNumber() {
        return this.acknowldegementNumber;
    }

    public Float getComputedTax() {
        return this.computedTax;
    }
    
    public String getMessage() {
        return this.message;
    }

    public String getPaymentReferenceRNumber() {
        return this.paymentReferenceRNumber;
    }

    public String getRespondeCode() {
        return this.respondeCode;
    }

    public String getStatus() {
        return this.status;
    }

    public Float getTaxPayable() {
        return this.taxPayable;
    }

    public Float getUtilizedCredit() {
        return this.utilizedCredit;
    }
    
}
