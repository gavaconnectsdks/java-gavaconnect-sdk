package io.github.gavaconnectsdks.exceptions;

public class ForbiddenException extends GavaConnectException {
    public ForbiddenException(String message) {
        super(message, "AUTH_ERR_403");
    }
}
