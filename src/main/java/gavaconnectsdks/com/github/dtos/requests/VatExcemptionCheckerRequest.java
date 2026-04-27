package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;

public class VatExcemptionCheckerRequest {
    @JsonProperty(value="VatExcemptionCertificateNo")
    private final String vatExcemptionCertificateNumber;

    private VatExcemptionCheckerRequest(Builder builder){
        this.vatExcemptionCertificateNumber=builder.vatExcemptioncertificateNumber;
    }

    private static class Builder{
        private String vatExcemptioncertificateNumber;

        public Builder setVatExcemptioncertificate(String vatExcemptioncertificateNumber) {
            this.vatExcemptioncertificateNumber = vatExcemptioncertificateNumber;
            return this;
        }
        
        public VatExcemptionCheckerRequest build(){
            if (this.vatExcemptioncertificateNumber==null) {
                throw new ValidationException("vatExcemptioncertificateNumber is required");
            }
            return new VatExcemptionCheckerRequest(this);
        }
        
    }

    public String getVatExcemptionCertificateNumber() {
        return this.vatExcemptionCertificateNumber;
    }

    public static Builder builder(){
        return new Builder();
    }

    
}
