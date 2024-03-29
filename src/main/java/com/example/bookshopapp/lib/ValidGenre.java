package com.example.bookshopapp.lib;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.NotBlank;

@Constraint(validatedBy = GenreValidator.class)
@Target({FIELD, PARAMETER})
@Retention(RUNTIME)
@NotBlank
@ReportAsSingleViolation
public @interface ValidGenre {
    String message() default "'${validatedValue}' is not a valid genre";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
