package com.ishowdarkside.mvc.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class CourseCodeConstraintValidator  implements ConstraintValidator<CourseCode,String> {


    private String coursePrefix;

    @Override
    public void initialize(CourseCode theCourseCode) {

        coursePrefix = theCourseCode.value();

    }

    @Override
    public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {

        if(theCode == null) return false;
        boolean result = theCode.startsWith(coursePrefix);
        if(result) return  true;
        return false;

    }
}
