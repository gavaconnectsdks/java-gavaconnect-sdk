package gavaconnectsdks.com.github.utils.validators;

import gavaconnectsdks.com.github.utils.enums.Country;

public class CountryCodeValidator {
    public static boolean isValid(String code){
        return  Country.isValid(code);
    }
}
