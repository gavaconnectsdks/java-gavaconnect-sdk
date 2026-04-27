package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class ExciseLicenseCheckerByPinRequest {
    @Pin
    @JsonProperty(value="PINNo")
    private final String pinNo;

    private ExciseLicenseCheckerByPinRequest(Builder builder){
        this.pinNo=builder.pinNo;
    }

    private static class Builder{
        @Pin
        private String pinNo;

        public Builder PinNo(String pinNo) {
            this.pinNo = pinNo;
            return this;
        }

        public ExciseLicenseCheckerByPinRequest build(){
            if(this.pinNo==null){
                throw new ValidationException("pinNo is required");
            }
            return new ExciseLicenseCheckerByPinRequest(this);
        }
    
    }
    public String getPinNo() {
        return this.pinNo;
    }

    public  static Builder builder(){
        return new Builder();
    }
        
}
