package io.github.gavaconnectsdks.exceptions;

public class NotFoundException extends GavaConnectException {
    public NotFoundException(String message) {
        super(message, "RES_ERR_404");
    }   
}
