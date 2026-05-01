package io.github.gavaconnectsdks.dtos.responses;

public class PinRegistrationResponse {
    private String ResponseCode;
    private String Message;
    private String Status;
    private String PIN;

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setPIN(String PIN) {
        this.PIN = PIN;
    }

    public void setResponseCode(String ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getMessage() {
        return this.Message;
    }

    public String getPIN() {
        return this.PIN;
    }

    public String getResponseCode() {
        return this.ResponseCode;
    }

    public String getStatus() {
        return this.Status;
    }   
}
