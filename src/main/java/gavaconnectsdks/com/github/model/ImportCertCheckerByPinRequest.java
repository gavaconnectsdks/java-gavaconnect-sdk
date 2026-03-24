package gavaconnectsdks.com.github.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class ImportCertCheckerByPinRequest {
    @Pin
    private String pinNo;

    private ImportCertCheckerByPinRequest (Builder builder){
        this.pinNo=builder.pinNo;
    }

    private static class Builder{
        @JsonProperty(value="pin_no")
        private String pinNo;

        public Builder PinNo(String pinNo) {
            this.pinNo = pinNo;
            return this;
        }

        public ImportCertCheckerByPinRequest build(){
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
