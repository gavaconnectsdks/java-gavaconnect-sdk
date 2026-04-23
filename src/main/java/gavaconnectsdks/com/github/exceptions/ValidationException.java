package gavaconnectsdks.com.github.exceptions;

public class ValidationException extends GavaConnectException {

    public ValidationException(String message) {
        super(message, "VAL_ERR_400");
    }
    
}
