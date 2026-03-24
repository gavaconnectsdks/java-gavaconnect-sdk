package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class KnowKraOfficeRequest {
    @Pin
    private String kraPin;

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
