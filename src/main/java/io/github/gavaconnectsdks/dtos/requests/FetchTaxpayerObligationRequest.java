package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.utils.annotations.Pin;

public class FetchTaxpayerObligationRequest {
    @Pin
    @JsonProperty("taxPayerPin")
    private final String taxPayerPIN;


    private FetchTaxpayerObligationRequest(Builder builder){
            this.taxPayerPIN=builder.taxPayerPIN;
    }

    public static class Builder{
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
