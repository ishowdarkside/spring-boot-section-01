package com.ishowdarkside.mvc.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//CourseCodeConstraintvalidator je onaj koji ima biznis logiku
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {


    // define default course code
    public String value() default "LUV";

    // define default error message
    public String message() default "must start with LUV";

    // Define default groups
    public Class<?>[] groups() default {};

    // Define default payloads
    public Class <? extends Payload>[] payload()  default {};
}
