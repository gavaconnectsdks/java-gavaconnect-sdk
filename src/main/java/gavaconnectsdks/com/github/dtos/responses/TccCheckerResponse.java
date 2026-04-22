package gavaconnectsdks.com.github.dtos.responses;

import com.fasterxml.jackson.annotation.JsonProperty;

import gavaconnectsdks.com.github.dtos.TCCData;

public class TccCheckerResponse {
    private String ResponseCode;
    private String Message;
    private String Status;

    @JsonProperty(value="TCCData")
    private TCCData tccData;

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setResponseCode(String ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setTccData(TCCData tccData) {
        this.tccData = tccData;
    }

    public String getMessage() {
        return this.Message;
    }

    public String getResponseCode() {
        return this.ResponseCode;
    }

    public String getStatus() {
        return this.Status;
    }

    public TCCData getTccData() {
        return this.tccData;
    }

    
}
