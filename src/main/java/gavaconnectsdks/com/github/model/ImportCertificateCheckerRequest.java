package gavaconnectsdks.com.github.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ImportCertificateCheckerRequest {
    @JsonProperty(value="certificate_no")
    private String certificateNumber;

    private ImportCertificateCheckerRequest(Builder builder){
        this.certificateNumber=builder.certificateNumber;
    }

    private static class Builder{
        @JsonProperty(value="certificate_no")
        private String certificateNumber;

        public Builder CertificateNumber(String certificateNumber) {
            this.certificateNumber = certificateNumber;
            return this;
        }

        public ImportCertificateCheckerRequest build(){
            return  new ImportCertificateCheckerRequest(this);
        }

        
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public Builder builder(){
        return new Builder();
    }
    
}
