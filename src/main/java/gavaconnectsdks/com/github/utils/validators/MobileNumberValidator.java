package gavaconnectsdks.com.github.utils.validators;

import java.util.regex.Pattern;

public class MobileNumberValidator {
     private static final Pattern MOBILE_NUMBER_PATTERN=Pattern.compile("^(07|01)\\\\d{8}$");
     
     public static boolean isValidMobileNumber(String mobileNumberToValidate){
        return mobileNumberToValidate!=null && MOBILE_NUMBER_PATTERN.matcher(mobileNumberToValidate).matches();
    }
}
