package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PinDetail {
    @JsonProperty(value="PINNo")
    private String pinNumber;
    @JsonProperty(value="TaxpayerName")
    private String taxPayerName;
    @JsonProperty(value="Trading_Business_Name")
    private String tradingBusinessName;

    public void setPinNumber(String pinNumber) {
        this.pinNumber = pinNumber;
    }

    public void setTaxPayerName(String taxPayerName) {
        this.taxPayerName = taxPayerName;
    }

    public void setTradingBusinessName(String tradingBusinessName) {
        this.tradingBusinessName = tradingBusinessName;
    }

    public String getPinNumber() {
        return this.pinNumber;
    }

    public String getTaxPayerName() {
        return this.taxPayerName;
    }

    public String getTradingBusinessName() {
        return this.tradingBusinessName;
    }

    
}
