package io.github.gavaconnectsdks.utils.validators;

import io.github.gavaconnectsdks.utils.enums.ObligationCodeEnum;

public class ObligationCodeValidator {
    public static boolean isValid(Integer code){

        return  ObligationCodeEnum.isValid(code);
    }
}
