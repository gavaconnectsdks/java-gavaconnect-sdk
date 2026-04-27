package gavaconnectsdks.com.github.dtos.requests;

import gavaconnectsdks.com.github.utils.annotations.Pin;

public class ITExceptionCheckerRequest {
    @Pin
    private final String pin;
    private ITExceptionCheckerRequest(Builder builder){
        this.pin=builder.pin;
    }

    private static class Builder{
        @Pin
        private String pin;

        public Builder Pin(String pin) {
            this.pin = pin;
            return this;
        }

        public ITExceptionCheckerRequest build(){
            return new ITExceptionCheckerRequest(this);
        }
    }
    public String getPin() {
        return this.pin;
    }
    public static Builder builder(){
        return new Builder();
    }
}

