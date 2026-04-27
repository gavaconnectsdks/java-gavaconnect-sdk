package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.Length;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class TccApplicationRequest {
    @Pin
    @JsonProperty("TaxpayerPIN")
    private final String taxpayerPIN;

    @Length(max=400)
    @JsonProperty("ReasonForTCC")
    private final String reasonForTaxComplianceCertificate;

    private TccApplicationRequest(Builder builder){
        this.reasonForTaxComplianceCertificate=builder.reasonForTaxComplianceCertificate;
        this.taxpayerPIN=builder.taxpayerPIN;
    }

    private static class Builder{
        private String taxpayerPIN;
        private String reasonForTaxComplianceCertificate;

        public Builder reasonForTaxComplianceCertificate(String reasonForTaxComplianceCertificate) {
            this.reasonForTaxComplianceCertificate = reasonForTaxComplianceCertificate;
            return this;
        }

        public Builder taxpayerPIN(String taxpayerPIN) {
            this.taxpayerPIN = taxpayerPIN;
            return this;
        }

        public TccApplicationRequest build(){
            if(this.taxpayerPIN==null){
                throw new ValidationException("taxpayerPIN is required");
            }
            if (this.reasonForTaxComplianceCertificate==null) {
                throw new ValidationException("reasonForTaxComplianceCertificate is required");
            }
            return  new TccApplicationRequest(this);
        }   
    }

    public String getTaxpayerPIN() {
        return this.taxpayerPIN;
    }

    public String getReasonForTaxComplianceCertificate() {
        return this.reasonForTaxComplianceCertificate;
    }

    

    public static Builder builder(){
        return new Builder();
    }
}
