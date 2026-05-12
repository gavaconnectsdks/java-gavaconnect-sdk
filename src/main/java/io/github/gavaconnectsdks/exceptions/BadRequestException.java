package io.github.gavaconnectsdks.exceptions;

public class BadRequestException extends GavaConnectException {

    public BadRequestException(String message) {
        super(message, "VAL_ERR_400");
    }
    
}
