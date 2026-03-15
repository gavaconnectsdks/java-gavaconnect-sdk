package gavaconnectsdks.com.github.utils.engine;

import java.lang.reflect.Field;
import java.time.LocalDate;
import java.util.regex.Pattern;

import gavaconnectsdks.com.github.utils.annotations.Adult;
import gavaconnectsdks.com.github.utils.annotations.CountryCode;
import gavaconnectsdks.com.github.utils.annotations.CustomPattern;
import gavaconnectsdks.com.github.utils.annotations.Email;
import gavaconnectsdks.com.github.utils.annotations.IdentificationNumber;
import gavaconnectsdks.com.github.utils.annotations.MobileNumber;
import gavaconnectsdks.com.github.utils.annotations.ObligationCode;
import gavaconnectsdks.com.github.utils.annotations.Pin;
import gavaconnectsdks.com.github.utils.validators.AdultValidator;
import gavaconnectsdks.com.github.utils.validators.CountryCodeValidator;
import gavaconnectsdks.com.github.utils.validators.CustomPatternValidator;
import gavaconnectsdks.com.github.utils.validators.EmailValidator;
import gavaconnectsdks.com.github.utils.validators.IdentificationNumberValidator;
import gavaconnectsdks.com.github.utils.validators.MobileNumberValidator;
import gavaconnectsdks.com.github.utils.validators.ObligationCodeValidator;
import gavaconnectsdks.com.github.utils.validators.PinValidator;

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
