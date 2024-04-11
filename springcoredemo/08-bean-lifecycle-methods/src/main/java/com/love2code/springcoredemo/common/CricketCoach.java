package com.love2code.springcoredemo.common;
import org.springframework.stereotype.Component;

@Component // Marks the class as spring bean and makes available for dependency injection
public class CricketCoach implements  Coach{

    public CricketCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    //Define our init method

    //Define our destory method
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
