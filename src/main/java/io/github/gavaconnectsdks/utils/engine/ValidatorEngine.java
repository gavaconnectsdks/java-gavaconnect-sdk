package io.github.gavaconnectsdks.utils.engine;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.regex.Pattern;

import io.github.gavaconnectsdks.utils.annotations.Adult;
import io.github.gavaconnectsdks.utils.annotations.CountryCode;
import io.github.gavaconnectsdks.utils.annotations.CustomPattern;
import io.github.gavaconnectsdks.utils.annotations.Email;
import io.github.gavaconnectsdks.utils.annotations.IdentificationNumber;
import io.github.gavaconnectsdks.utils.annotations.MobileNumber;
import io.github.gavaconnectsdks.utils.annotations.ObligationCode;
import io.github.gavaconnectsdks.utils.annotations.Pin;
import io.github.gavaconnectsdks.utils.validators.AdultValidator;
import io.github.gavaconnectsdks.utils.validators.CountryCodeValidator;
import io.github.gavaconnectsdks.utils.validators.CustomPatternValidator;
import io.github.gavaconnectsdks.utils.validators.EmailValidator;
import io.github.gavaconnectsdks.utils.validators.IdentificationNumberValidator;
import io.github.gavaconnectsdks.utils.validators.MobileNumberValidator;
import io.github.gavaconnectsdks.utils.validators.ObligationCodeValidator;
import io.github.gavaconnectsdks.utils.validators.PinValidator;

public class ValidatorEngine {
    public static void validate(Object obj) throws  IllegalAccessException{
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            Object value=field.get(obj);

            if (field.isAnnotationPresent(Email.class)) {
                Email email=field.getAnnotation(Email.class);
                if(!EmailValidator.isValid((String) value)){
                    throw new RuntimeException(email.message());
                }
            }
            if (field.isAnnotationPresent(Pin.class)) {
                Pin pin=field.getAnnotation(Pin.class);
                if(!PinValidator.isValidPin((String) value)){
                    throw new RuntimeException(pin.message());
                }
            }
            if (field.isAnnotationPresent(Adult.class)) {
                Adult adult=field.getAnnotation(Adult.class);
                if(!AdultValidator.is18andAbove((LocalDate) value)){
                    throw new RuntimeException(adult.message());
                }
            }
            if (field.isAnnotationPresent(IdentificationNumber.class)) {
                IdentificationNumber identificationNumber=field.getAnnotation(IdentificationNumber.class);
                if(!IdentificationNumberValidator.isValidIdNumber((String) value)){
                    throw new RuntimeException(identificationNumber.message());
                }
            }
            if (field.isAnnotationPresent(MobileNumber.class)) {
                MobileNumber mobileNumber=field.getAnnotation(MobileNumber.class);
                if(!MobileNumberValidator.isValidMobileNumber((String) value)){
                    throw new RuntimeException(mobileNumber.message());
                }
            }

            if (field.isAnnotationPresent(CountryCode.class)) {
                CountryCode countryCode=field.getAnnotation(CountryCode.class);
                if(!CountryCodeValidator.isValid((String) value)){
                    throw new RuntimeException(countryCode.message());
                }
            }
            if (field.isAnnotationPresent(ObligationCode.class)) {
                ObligationCode obligationCode=field.getAnnotation(ObligationCode.class);
                if(!ObligationCodeValidator.isValid((Integer) value)){
                    throw new RuntimeException(obligationCode.message());
                }
            }
             if (field.isAnnotationPresent(CustomPattern.class)) {
                CustomPattern customPattern=field.getAnnotation(CustomPattern.class);
                String pattern=customPattern.pattern();
                if (pattern.isEmpty()||pattern.isBlank()) {
                    throw new RuntimeException("Pattern cannot be empty or null");  
                }
                String toTest=CustomPatternValidator.isValid((String) value);
                Pattern setPattern=Pattern.compile(pattern);
                if(toTest!=null && setPattern.matcher(toTest).matches()){
                    throw new RuntimeException(customPattern.message());
                }
            }
        }
    }    
}
