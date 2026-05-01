package io.github.gavaconnectsdks.utils.validators;

import io.github.gavaconnectsdks.utils.enums.CountryEnum;

public class CountryCodeValidator {
    public static boolean isValid(String code){
        return  CountryEnum.isValid(code);
    }
}
