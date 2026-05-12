package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.BadRequestException;

public class ExciseLicenceCheckerByCertNoRequest {
    @JsonProperty(value="ExciseLicenceNo")
    private final String exciseLicenceNumber;

    private ExciseLicenceCheckerByCertNoRequest(Builder builder){
        this.exciseLicenceNumber=builder.exciseLicenceNumber;
    }

    public static class Builder{
        private String exciseLicenceNumber;

        public Builder exciseLicenceNumber(String exciseLicenceNumber) {
            this.exciseLicenceNumber = exciseLicenceNumber;
            return this;
        }

        public  ExciseLicenceCheckerByCertNoRequest build(){
            if(this.exciseLicenceNumber==null){
                throw new BadRequestException("exciseLicnceNumber is required");
            }
            return  new ExciseLicenceCheckerByCertNoRequest(this);
        }
        
    }

    public String getExciseLicenseNumber() {
        return this.exciseLicenceNumber;
    }

    public static Builder builder(){
        return new Builder();
    }
    
}
