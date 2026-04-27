package gavaconnectsdks.com.github.dtos.requests;


import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class ImportCertCheckerByPinRequest {
    @Pin
    @JsonProperty(value="pin_no")
    private final String pinNo;

    private ImportCertCheckerByPinRequest (Builder builder){
        this.pinNo=builder.pinNo;
    }

    private static class Builder{
        private String pinNo;

        public Builder PinNo(String pinNo) {
            this.pinNo = pinNo;
            return this;
        }

        public ImportCertCheckerByPinRequest build(){
            if(this.pinNo==null){
                throw new ValidationException("pinNo is required");
            }
            return new ImportCertCheckerByPinRequest(this);
        }
        
    }

    public String getPinNo() {
        return this.pinNo;
    }

    public static Builder builder(){
        return  new Builder();
    }    
}
