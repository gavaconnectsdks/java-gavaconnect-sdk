package gavaconnectsdks.com.github.model;

import java.time.LocalDate;

import gavaconnectsdks.com.github.utils.annotations.Adult;
import gavaconnectsdks.com.github.utils.annotations.CountryCode;
import gavaconnectsdks.com.github.utils.annotations.Email;
import gavaconnectsdks.com.github.utils.annotations.IdentificationNumber;
import gavaconnectsdks.com.github.utils.annotations.MobileNumber;

public class PinRegistrationRequest {
    @CountryCode
    private String TaxPayerType;
    @IdentificationNumber
    private String IdentificationNumber;
    @Adult
    private LocalDate DateOfBirth;
    @MobileNumber
    private String MobileNumber;
    @Email
    private String EmailAddress;
    private String isPinWithOblig;

    private  PinRegistrationRequest(Builder builder){
        this.DateOfBirth=builder.DateOfBirth;
        this.EmailAddress=builder.EmailAddress;
        this.IdentificationNumber=builder.IdentificationNumber;
        this.MobileNumber=builder.MobileNumber;
        this.TaxPayerType=builder.TaxPayerType;
        this.isPinWithOblig=builder.isPinWithOblig?"YES":"NO";
    }

    private static class Builder{
        private String TaxPayerType;
        private String IdentificationNumber;
        private LocalDate DateOfBirth;
        private String MobileNumber;
        private String EmailAddress;
        private boolean  isPinWithOblig;

        public Builder DateOfBirth(LocalDate DateOfBirth) {
            this.DateOfBirth = DateOfBirth;
            return this;
        }

        public Builder EmailAddress(String EmailAddress) {
            this.EmailAddress = EmailAddress;
            return this;
        }

        public Builder IdentificationNumber(String IdentificationNumber) {
            this.IdentificationNumber = IdentificationNumber;
            return  this;
        }

        public Builder IsPinWithOblig(boolean isPinWithOblig) {
            this.isPinWithOblig = isPinWithOblig;
            return this;
        }

        public Builder MobileNumber(String MobileNumber) {
            this.MobileNumber = MobileNumber;
            return this;
        }

        public Builder TaxPayerType(String TaxPayerType) {
            this.TaxPayerType = TaxPayerType;
            return this;
        }

        public PinRegistrationRequest build(){
            return new PinRegistrationRequest(this);
        }
        
    }

}
