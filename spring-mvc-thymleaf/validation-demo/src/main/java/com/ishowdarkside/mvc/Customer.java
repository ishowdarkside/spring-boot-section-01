package com.ishowdarkside.mvc;

import com.ishowdarkside.mvc.validation.CourseCode;
import jakarta.validation.constraints.*;


public class Customer {

    @NotNull(message = "is required")
    private String firstName;

    @NotNull(message = "is required")
    @Size(min = 1, message = "is required")

    private String lastName;


    @CourseCode(value = "LUV",message = "Must start with LUV")
    private String courseCode;

    @NotNull(message = "free pass is required")
    @Min(value = 0,message = "Free passses cant be less than 0")
    @Max(value = 10,message = "Maximum passes cant be greater than 10")
    private Integer freePasses;


    @NotNull(message = "is required")
    @Pattern(regexp = "^\\d{5}(?:[-\\s]\\d{4})?$",message = "Invalid postal code")
    private String postalCode;
    public String getFirstName(){
        return  this.firstName;
    }

    public String getLastName(){
        return  this.lastName;
    }

    public void setFirstName(String input){
        this.firstName = input;
    }


    public Integer getFreePasses(){
        return  this.freePasses;
    }

    public void setFreePasses(Integer input){
        this.freePasses = input;
    }

    public  void setLastName(String input){
        this.lastName=  input;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String  postalCode) {
        this.postalCode = postalCode;
    }
}
