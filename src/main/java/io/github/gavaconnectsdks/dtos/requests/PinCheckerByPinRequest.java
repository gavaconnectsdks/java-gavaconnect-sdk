package io.github.gavaconnectsdks.dtos.requests;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.exceptions.ValidationException;
import io.github.gavaconnectsdks.utils.annotations.Pin;

public class PinCheckerByPinRequest {
    @Pin
    @JsonProperty("KRAPIN")
    private final String kraPin;

    private PinCheckerByPinRequest(Builder builder){
        this.kraPin=builder.kraPin;
    }

    public static class Builder{
        private String kraPin;

        public Builder KraPin(String kraPin) {
            this.kraPin = kraPin;
            return this;
        }
        public  PinCheckerByPinRequest build(){
            if (this.kraPin==null) {
                throw new ValidationException("kraPin is mrequired.");
            }
            return new PinCheckerByPinRequest(this);
        }
    }

    public String getKraPin() {
        return this.kraPin;
    }
    
    public static Builder builder(){
        return new Builder();
    }
    
    
}
