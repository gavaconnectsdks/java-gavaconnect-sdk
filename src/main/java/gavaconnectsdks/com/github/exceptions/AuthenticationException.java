package gavaconnectsdks.com.github.exceptions;

public class AuthenticationException extends GavaConnectException {
    
    public AuthenticationException(String message){
        super(message,"AUTH_ERR_001");
    }
}
