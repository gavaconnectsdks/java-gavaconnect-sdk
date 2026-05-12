package io.github.gavaconnectsdks.exceptions;

public class ServerException extends  GavaConnectException {
    public ServerException(String message) {
        super(message, "SRV_ERR_500");
    }
}
