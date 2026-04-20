package gavaconnectsdks.com.github.utils.validators;

import gavaconnectsdks.com.github.utils.enums.ObligationCodeEnum;

public class ObligationCodeValidator {
    public static boolean isValid(Integer code){

        return  ObligationCodeEnum.isValid(code);
    }
}
