package com.love2code.springcoredemo.common;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{


    public TrackCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "PONOSNU I LIJEPU KO U SNOVIMA";
    }
}
