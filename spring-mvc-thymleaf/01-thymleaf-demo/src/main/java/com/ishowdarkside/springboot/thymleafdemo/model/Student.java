package com.ishowdarkside.springboot.thymleafdemo.model;

import java.util.List;

public class Student {

    private String firstName;
    private String lastName;

    private String country;

    private String favouriteLanguage;

    private List<String> operatingSystem;



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


    public String getCountry(){
        return this.country;
    }

    public void setCountry(String country){
        this.country = country;
    }

    public void setOperatingSystem(List<String> input){
        this.operatingSystem = input;
    }

    public List<String> getOperatingSystem(){
        return  this.operatingSystem;
    }

    public String getFavouriteLanguage(){
        return  this.favouriteLanguage;
    }

    public void setFavouriteLanguage(String language){
        this.favouriteLanguage = language;
    }
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }
}
