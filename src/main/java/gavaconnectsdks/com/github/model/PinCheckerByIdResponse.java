package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PinCheckerByIdResponse {
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

    
}
