package gavaconnectsdks.com.github.dtos.requests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.utils.annotations.Adult;
import gavaconnectsdks.com.github.utils.annotations.CountryCode;
import gavaconnectsdks.com.github.utils.annotations.Email;
import gavaconnectsdks.com.github.utils.annotations.IdentificationNumber;
import gavaconnectsdks.com.github.utils.annotations.MobileNumber;
import gavaconnectsdks.com.github.utils.enums.TaxpayerTypeEnum;

public class PinRegistrationRequest {
    @CountryCode
    @JsonProperty("TaxPayerType")
    
    private final String taxPayerType;
    @IdentificationNumber
    @JsonProperty("IdentificationNumber")
    private final String identificationNumber;

    @Adult
    @JsonProperty("DateOfBirth")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="dd/MM/yyyy")
    private final LocalDate dateOfBirth;
    @MobileNumber
    @JsonProperty("MobileNumber")
    private final String mobileNumber;
    @Email
    @JsonProperty("EmailAddress")
    private final String emailAddress;

    @JsonProperty("IsPinWithNoOblig")
    private final String isPinWithNoObligation;

    private  PinRegistrationRequest(Builder builder){
        this.dateOfBirth=builder.dateOfBirth;
        this.emailAddress=builder.emailAddress;
        this.identificationNumber=builder.identificationNumber;
        this.mobileNumber=builder.mobileNumber;
        this.taxPayerType=builder.taxPayerType.getTaxpayerType();
        this.isPinWithNoObligation=builder.isPinWithObligation?"YES":"NO";
    }

    private static class Builder{
        private TaxpayerTypeEnum taxPayerType;
        private String identificationNumber;
        private LocalDate dateOfBirth;
        private String mobileNumber;
        private String emailAddress;
        private boolean  isPinWithObligation;

        public Builder dateOfBirth(LocalDate dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public Builder emailAddress(String emailAddress) {
            this.emailAddress = emailAddress;
            return this;
        }

        public Builder identificationNumber(String identificationNumber) {
            this.identificationNumber = identificationNumber;
            return  this;
        }

        public Builder isPinWithObligation(boolean isPinWithObligation) {
            this.isPinWithObligation = isPinWithObligation;
            return this;
        }

        public Builder mobileNumber(String mobileNumber) {
            this.mobileNumber = mobileNumber;
            return this;
        }

        public Builder taxPayerType(TaxpayerTypeEnum taxPayerType) {
            this.taxPayerType = taxPayerType;
            return this;
        }

        public PinRegistrationRequest build(){
            return new PinRegistrationRequest(this);
        }
        
    }

    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getEmailAddress() {
        return this.emailAddress;
    }

    public String getIdentificationNumber() {
        return this.identificationNumber;
    }

    public String getIsPinWithNoObligation() {
        return this.isPinWithNoObligation;
    }

    public String getMobileNumber() {
        return this.mobileNumber;
    }

    public String getTaxPayerType() {
        return this.taxPayerType;
    }

    public static Builder builder(){
        return new Builder();
    }


}
