package com.love2code.springcoredemo.common;


import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

@Component // Marks the class as spring bean and makes available for dependency injection
public class CricketCoach implements  Coach{

    public CricketCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }

    //Define our init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println("We are doing startup stuff for: " +  this.getClass().getSimpleName());
    }

    @PreDestroy
    public void doMyCleanupStuff(){
        System.out.println("We are doing cleanup stuff for: " +  this.getClass().getSimpleName());
    }

    //Define our destory method
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }
}
