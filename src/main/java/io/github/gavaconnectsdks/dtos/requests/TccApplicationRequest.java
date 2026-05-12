package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.utils.annotations.Length;
import io.github.gavaconnectsdks.utils.annotations.Pin;

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

    public static class Builder{
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
                throw new BadRequestException("taxpayerPIN is required");
            }
            if (this.reasonForTaxComplianceCertificate==null) {
                throw new BadRequestException("reasonForTaxComplianceCertificate is required");
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
