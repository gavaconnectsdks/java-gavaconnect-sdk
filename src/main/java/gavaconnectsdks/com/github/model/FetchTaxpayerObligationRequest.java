package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class FetchTaxpayerObligationRequest {
    @Pin
    String taxPayerId;


    private FetchTaxpayerObligationRequest(Builder builder){
            this.taxPayerId=builder.taxPayerId;
    }

    private static class Builder{
        @Pin
        String taxPayerId;

        
        public Builder TaxPayerId(String taxPayerId) {
            this.taxPayerId = taxPayerId;
            return this;
        }

        public FetchTaxpayerObligationRequest build(){
            return new FetchTaxpayerObligationRequest(this);
        }
    }

    public String getTaxPayerId() {
        return this.taxPayerId;
    }
    public static Builder builder(){
        return new Builder();
    }
    
}
