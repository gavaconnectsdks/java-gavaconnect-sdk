package gavaconnectsdks.com.github.utils;

public class PinValidator {
    public static boolean isValid(String pinToValidate){
        String pinRegex="^[A-Z]\\d{9}[A-Z]$";
        return pinToValidate.matches(pinRegex);
    }
}
