package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PinCheckerByIdResponse {
    @JsonProperty(value = "ResponseCode")
    private String responseCode;

    @JsonProperty(value="TaxpayerPIN")
    private String taxPayerPin;

    @JsonProperty(value="TaxpayerName")
    private String taxPayerName;

    public void setTaxPayerName(String taxPayerName) {
        this.taxPayerName = taxPayerName;
    }

    public void setTaxPayerPin(String taxPayerPin) {
        this.taxPayerPin = taxPayerPin;
    }

    public String getTaxPayerName() {
        return this.taxPayerName;
    }

    public String getTaxPayerPin() {
        return this.taxPayerPin;
    }

    public String getResponseCode() {
        return this.responseCode;
    }
    public void setResponseCode(String responseCode) {
            this.responseCode = responseCode;
    }
}
