package io.github.gavaconnectsdks.exceptions;

public class GavaConnectException extends RuntimeException {
    private final String errorCode;
    public GavaConnectException(String message,String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
