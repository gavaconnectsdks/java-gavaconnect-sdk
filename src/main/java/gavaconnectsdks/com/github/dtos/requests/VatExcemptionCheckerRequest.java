package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VatExcemptionCheckerRequest {
    @JsonProperty(value="VatExcemptionCertificateNo")
    private String vatExcemptionCertificateNumber;

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
