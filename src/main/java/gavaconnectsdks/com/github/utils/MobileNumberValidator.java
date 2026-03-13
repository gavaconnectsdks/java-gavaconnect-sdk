package gavaconnectsdks.com.github.utils;

public class MobileNumberValidator {
    public static boolean isValidMobileNumber(String mobileNumberToValidate){
        String mobileNumberRegex="^(07|01)\\d{8}$";
        return mobileNumberToValidate.matches(mobileNumberRegex);
    }
    
}
