package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.ValidationException;

public class ImportCertificateCheckerRequest {
    @JsonProperty(value="certificate_no")
    private final String certificateNumber;

    private ImportCertificateCheckerRequest(Builder builder){
        this.certificateNumber=builder.certificateNumber;
    }

    private static class Builder{
        private String certificateNumber;

        public Builder certificateNumber(String certificateNumber) {
            this.certificateNumber = certificateNumber;
            return this;
        }

        public ImportCertificateCheckerRequest build(){
            if(this.certificateNumber==null){
                throw new ValidationException("certificateNumber is required.");
            }
            return  new ImportCertificateCheckerRequest(this);
        }

        
    }

    public String getCertificateNumber() {
        return this.certificateNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
