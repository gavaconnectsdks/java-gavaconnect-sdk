package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.BadRequestException;
import io.github.gavaconnectsdks.utils.annotations.Pin;

public class KnowKraOfficeRequest {
    @Pin
    @JsonProperty("kraPIN")
    private final String kraPin;

    private KnowKraOfficeRequest(Builder builder){
        this.kraPin=builder.kraPin;
    }

    public static class Builder{
        @Pin
        
        private String kraPin;

        public Builder kraPin(String kraPin) {
            this.kraPin = kraPin;
            return this;
        }
        public KnowKraOfficeRequest build(){
            if(this.kraPin==null){
                throw new BadRequestException("kraPin is required");
            }
            return new KnowKraOfficeRequest(this);
        }

        
    }

    public String getKraPin() {
        return this.kraPin;
    }

    public static Builder builder(){
        return new Builder();
    }

}
