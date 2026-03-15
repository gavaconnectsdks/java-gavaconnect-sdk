package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.Length;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class TccApplicationRequest {
    @Pin
    String TaxPayerPIN;

    @Length(max=400)
    String ReasonForTCC;

    private TccApplicationRequest(Builder builder){
        this.ReasonForTCC=builder.ReasonForTCC;
        this.TaxPayerPIN=builder.TaxPayerPIN;
    }

    private static class Builder{
        private String TaxPayerPIN;
        private String ReasonForTCC;

        public Builder ReasonForTCC(String ReasonForTCC) {
            this.ReasonForTCC = ReasonForTCC;
            return this;
        }

        public Builder TaxPayerPIN(String TaxPayerPIN) {
            this.TaxPayerPIN = TaxPayerPIN;
            return this;
        }

        public TccApplicationRequest build(){
            return  new TccApplicationRequest(this);
        }

        
    }

    public String getReasonForTCC() {
        return this.ReasonForTCC;
    }

    public String getTaxPayerPIN() {
        return this.TaxPayerPIN;
    }

    
}
