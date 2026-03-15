package gavaconnectsdks.com.github.model;

public class NilReturnResponse {
    private String ResponseCode;
    private String Message;
    private String Status;
    private String AckNumber;

    public void setAckNumber(String AckNumber) {
        this.AckNumber = AckNumber;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setResponseCode(String ResponseCode) {
        this.ResponseCode = ResponseCode;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getAckNumber() {
        return this.AckNumber;
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

    
}
