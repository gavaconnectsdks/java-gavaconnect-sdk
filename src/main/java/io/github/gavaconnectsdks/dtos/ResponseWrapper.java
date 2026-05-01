package io.github.gavaconnectsdks.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseWrapper<T> {
    @JsonProperty("RESPONSE")
    private T response;

    public T getResponse() {
        return this.response;
    }

    public void setResponse(T response) {
        this.response = response;
    }    
}
