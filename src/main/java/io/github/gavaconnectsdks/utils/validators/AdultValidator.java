package io.github.gavaconnectsdks.utils.validators;

import java.time.LocalDate;
import java.time.Period;

public class AdultValidator {
    public static boolean is18andAbove(LocalDate dateOfBirth){
    LocalDate today=LocalDate.now();
    Period age=Period.between(dateOfBirth,today);
    int ageInYears=age.getYears();
    System.out.println(ageInYears);
    return ageInYears>=18;
   } 
}
