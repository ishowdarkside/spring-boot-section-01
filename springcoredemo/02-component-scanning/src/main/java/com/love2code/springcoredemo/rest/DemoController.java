package com.love2code.springcoredemo.rest;


import com.love2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define private field for depedency
    private Coach myCoach;

   //Define constructor for dependency injection

   @Autowired  //annotation that tells spring to inject a dependency
    public DemoController(Coach coach) {
        this.myCoach = coach;
    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return this.myCoach.getDailyWorkout();
    }
}
