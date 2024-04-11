package com.love2code.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component // Marks the class as spring bean and makes available for dependency injection
public class CricketCoach implements  Coach{

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
