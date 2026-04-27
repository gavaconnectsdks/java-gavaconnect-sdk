package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.enums.TaxpayerTypeEnum;

public class PinCheckerByIdRequest {
    @JsonProperty("TaxpayerType")
    private final String taxpayerType;

    @JsonProperty("TaxpayerID")
    private final String taxpayerId;

    private PinCheckerByIdRequest(Builder builder){
        this.taxpayerId=builder.taxpayerId.getTaxpayerType();
        this.taxpayerType=builder.taxpayerType;
    }

    private static class Builder{
        private String taxpayerType;
        private TaxpayerTypeEnum taxpayerId;

        public Builder taxpayerId(TaxpayerTypeEnum taxpayerId) {
            this.taxpayerId = taxpayerId;
            return this;
        }

        public Builder taxpayerType(String taxpayerType) {
            this.taxpayerType = taxpayerType;
            return this;
        }

        public PinCheckerByIdRequest build(){
            if(this.taxpayerId==null){
                throw  new ValidationException("taxpayerId is required.");
            }
            if (this.taxpayerType==null) {
                throw new ValidationException("taxpayerType is required.");
            }
            return new PinCheckerByIdRequest(this);
        }
        
        
    }

    public String getTaxpayerId() {
        return this.taxpayerId;
    }

    public String getTaxpayerType() {
        return this.taxpayerType;
    }

    public static  Builder builder(){
        return new Builder();
    }
}
