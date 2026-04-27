package gavaconnectsdks.com.github.dtos.requests;

import gavaconnectsdks.com.github.exceptions.ValidationException;
import gavaconnectsdks.com.github.utils.annotations.Pin;

public class KnowKraOfficeRequest {
    @Pin
    private final String kraPin;

    private KnowKraOfficeRequest(Builder builder){
        this.kraPin=builder.kraPin;
    }

    private static class Builder{
        @Pin
        private String kraPin;

        public Builder KraPin(String kraPin) {
            this.kraPin = kraPin;
            return this;
        }
        public KnowKraOfficeRequest build(){
            if(this.kraPin==null){
                throw new ValidationException("kraPin is required");
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
