package com.love2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class TrackCoach implements Coach{

    @Override
    public String getDailyWorkout() {
        return "PONOSNU I LIJEPU KO U SNOVIMA";
    }
}
