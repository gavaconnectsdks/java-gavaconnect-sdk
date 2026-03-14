package gavaconnectsdks.com.github.utils.validators;

import java.util.regex.Pattern;

public class IdentificationNumberValidator {
     private static final Pattern ID_PATTERN=Pattern.compile("^\\d{8,12}$");

     public static boolean isValidIdNumber(String identificationNumberToTest){
        return identificationNumberToTest!=null && ID_PATTERN.matcher(identificationNumberToTest).matches();
    }
}
