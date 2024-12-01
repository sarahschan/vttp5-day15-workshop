package sg.edu.nus.iss.vttp5a_ssf_day15wsA.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

// Define this annotation to be used for field validation
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DateValidator.class)

public @interface ValidDate {
    String message() default "Invalid date of birth, must be between 10 and 100 years old";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
