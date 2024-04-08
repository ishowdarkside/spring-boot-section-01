package com.love2code.springcoredemo.rest;


import com.love2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //Define private field for depedency
    private Coach myCoach;


   //Define constructor for dependency injection

    @Autowired
    public DemoController(@Qualifier("trackCoach") Coach coach) {

        System.out.println("In cosnstructor: " + getClass().getSimpleName());
        this.myCoach = coach;

    }



    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return "PONOSNU I LIJEPU KO U SNOVIMA";
    }


}
