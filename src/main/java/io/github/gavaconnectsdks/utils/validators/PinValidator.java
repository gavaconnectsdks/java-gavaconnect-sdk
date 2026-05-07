package io.github.gavaconnectsdks.utils.validators;

import java.util.regex.Pattern;

public class PinValidator {
    private static final Pattern PIN_PATTERN=Pattern.compile("^[A-Z]\\d{9}[A-Z]$");
     
     public static boolean isValidPin(String pinToValidate){
        return pinToValidate!=null && PIN_PATTERN.matcher(pinToValidate).matches();
    }
}
