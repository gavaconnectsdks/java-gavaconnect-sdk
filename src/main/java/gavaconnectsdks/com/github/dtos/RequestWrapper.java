package gavaconnectsdks.com.github.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestWrapper<T> {
    @JsonProperty("REQUEST")
    private T request;

    public T getRequest() {
        return request;
    }
    public void setRequest(T request) {
        this.request = request;
    }
}
