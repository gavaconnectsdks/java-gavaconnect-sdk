package io.github.gavaconnectsdks.exceptions;

public class NetworkTimeoutException extends GavaConnectException {

    public NetworkTimeoutException(String message) {
        super(message, "NET_ERR_408");
    }
    
}
