package gavaconnectsdks.com.github.utils.validators;

import gavaconnectsdks.com.github.utils.enums.ObligationCode;

public class ObligationCodeValidator {
    public static boolean isValid(Integer code){

        return  ObligationCode.isValid(code);
    }
}
