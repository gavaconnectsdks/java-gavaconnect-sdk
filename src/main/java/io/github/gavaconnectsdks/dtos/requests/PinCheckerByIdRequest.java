package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.utils.enums.TaxpayerTypeEnum;

public class PinCheckerByIdRequest {
    @JsonProperty("TaxpayerType")
    private final String taxpayerType;

    @JsonProperty("TaxpayerID")
    private final String taxpayerId;

    private PinCheckerByIdRequest(Builder builder){
        this.taxpayerId=builder.taxpayerId;
        this.taxpayerType=builder.taxpayerType.getTaxpayerType();
    }

    public static class Builder{
        private TaxpayerTypeEnum taxpayerType;
        private String taxpayerId;

        public Builder taxpayerId(String taxpayerId) {
            this.taxpayerId = taxpayerId;
            return this;
        }

        public Builder taxpayerType(TaxpayerTypeEnum taxpayerType) {
            this.taxpayerType = taxpayerType;
            return this;
        }

        public PinCheckerByIdRequest build(){
            if(this.taxpayerId==null){
                throw  new BadRequestException("taxpayerId is required.");
            }
            if (this.taxpayerType==null) {
                throw new BadRequestException("taxpayerType is required.");
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
