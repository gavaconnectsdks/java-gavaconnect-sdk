package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class FetchTaxpayerObligationRequest {
    @Pin
    @JsonProperty("taxPayerPin")
    private final String taxPayerPIN;


    private FetchTaxpayerObligationRequest(Builder builder){
            this.taxPayerPIN=builder.taxPayerPIN;
    }

    private static class Builder{
        String taxPayerPIN;

        
        public Builder taxPayerPIN(String taxPayerPIN) {
            this.taxPayerPIN = taxPayerPIN;
            return this;
        }

        public FetchTaxpayerObligationRequest build(){
            if(this.taxPayerPIN==null){
                throw new ValidationException("taxPayerPIN is required");
            }
            return new FetchTaxpayerObligationRequest(this);
        }
    }

    public String getTaxPayerId() {
        return this.taxPayerPIN;
    }
    public static Builder builder(){
        return new Builder();
    }
    
}
