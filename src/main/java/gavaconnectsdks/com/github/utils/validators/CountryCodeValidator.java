package gavaconnectsdks.com.github.utils.validators;

import gavaconnectsdks.com.github.utils.enums.CountryEnum;

public class CountryCodeValidator {
    public static boolean isValid(String code){
        return  CountryEnum.isValid(code);
    }
}
