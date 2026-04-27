package gavaconnectsdks.com.github.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

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
