package gavaconnectsdks.com.github.dtos.responses;

public class TccApplicationResponse {
    private String ResponseCode;
    private String Message;
    private String Status;
    private String AckNumber;
    private String TCCNumber;

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

    public void setTCCNumber(String TCCNumber) {
        this.TCCNumber = TCCNumber;
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

    public String getTCCNumber() {
        return this.TCCNumber;
    }

    
}
