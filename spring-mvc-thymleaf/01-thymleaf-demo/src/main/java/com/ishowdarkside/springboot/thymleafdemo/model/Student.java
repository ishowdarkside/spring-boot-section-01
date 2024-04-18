package com.ishowdarkside.springboot.thymleafdemo.model;

public class Student {

    private String firstName;
    private String lastName;


    public Student(){};

    public String getFirstName(){
        return  this.firstName;
    }

    public String getLastName(){
        return  this.lastName;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
