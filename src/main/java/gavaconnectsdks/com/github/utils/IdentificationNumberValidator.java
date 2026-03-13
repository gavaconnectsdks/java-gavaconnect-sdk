package gavaconnectsdks.com.github.utils;

public class IdentificationNumberValidator {
    public static boolean isValidIdNumber(String identificationNumberToTest){
        String idRegex="^\\d{8,12}$";
        return identificationNumberToTest.matches(idRegex);
    }
    
}
