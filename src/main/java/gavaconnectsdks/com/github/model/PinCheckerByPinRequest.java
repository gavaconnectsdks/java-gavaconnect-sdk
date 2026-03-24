package gavaconnectsdks.com.github.model;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class PinCheckerByPinRequest {
    @Pin
    private String kraPin;

    private PinCheckerByPinRequest(Builder builder){
        this.kraPin=builder.kraPin;
    }

    private static class Builder{
        @Pin
        private String kraPin;

        public Builder KraPin(String kraPin) {
            this.kraPin = kraPin;
            return this;
        }
        public  PinCheckerByPinRequest build(){
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
