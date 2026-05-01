package io.github.gavaconnectsdks.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.gavaconnectsdks.dtos.PinData;

public class PinCheckerByPinResponse {
    @JsonProperty(value="ResponseCode")
    private String responseCode;

    @JsonProperty(value="Message")
    private String message;

    @JsonProperty(value="status")
    private String Status;

    @JsonProperty(value="PINDATA")
    private PinData pinData;

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPinData(PinData pinData) {
        this.pinData = pinData;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return this.message;
    }

    public PinData getPinData() {
        return this.pinData;
    }

    public String getResponseCode() {
        return this.responseCode;
    }

    public String getStatus() {
        return this.Status;
    }

    

}
