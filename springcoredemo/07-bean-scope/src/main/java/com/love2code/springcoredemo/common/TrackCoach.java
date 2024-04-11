package com.love2code.springcoredemo.common;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class TrackCoach implements Coach{


    public TrackCoach(){
        System.out.println("In constructor: " + this.getClass().getSimpleName());
    }


    @Override
    public String getDailyWorkout() {
        return "PONOSNU I LIJEPU KO U SNOVIMA";
    }
}
