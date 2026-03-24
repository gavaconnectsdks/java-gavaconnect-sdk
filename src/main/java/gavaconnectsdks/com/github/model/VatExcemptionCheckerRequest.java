package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VatExcemptionCheckerRequest {
    @JsonProperty(value="VatExcemptionCertificate")
    private String vatExcemptionCertificate;

    private VatExcemptionCheckerRequest(Builder builder){
        this.vatExcemptionCertificate=builder.vatExcemptioncertificate;
    }

    private static class Builder{
        private String vatExcemptioncertificate;

        public Builder setVatExcemptioncertificate(String vatExcemptioncertificate) {
            this.vatExcemptioncertificate = vatExcemptioncertificate;
            return this;
        }
        
        public VatExcemptionCheckerRequest build(){
            return new VatExcemptionCheckerRequest(this);
        }
        
    }

    public String getVatExcemptionCertificate() {
        return this.vatExcemptionCertificate;
    }

    public static Builder builder(){
        return new Builder();
    }

    
}
