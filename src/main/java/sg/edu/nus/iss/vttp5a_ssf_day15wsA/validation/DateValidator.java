package sg.edu.nus.iss.vttp5a_ssf_day15wsA.validation;

import java.time.LocalDate;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class DateValidator implements ConstraintValidator<ValidDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate dob, ConstraintValidatorContext context){
        if(dob == null){
            return false;
        }
        
        // check if year is valid(should not be more than 4 digits)
        int year = dob.getYear();
        if (year > 9999 || year < 1000) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate("Year must be a 4-digit number")
                   .addConstraintViolation();
            return false;
        }

        // check if age is between 10 and 100
        LocalDate currentDate = LocalDate.now();
        int age = currentDate.getYear() - dob.getYear();
            // make adjustment for birthday that hasn't passed yet
            if (dob.getDayOfYear() > currentDate.getDayOfYear()) {
                age--;
            }
        return (age >= 10 && age <= 100);
        
    }
}
