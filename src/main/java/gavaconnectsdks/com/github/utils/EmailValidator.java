package gavaconnectsdks.com.github.utils;

public class EmailValidator {
    public static boolean isValidEmail(String emailToValidate){
        String emailRegex="^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$";
        return emailToValidate.matches(emailRegex);
    }
}
