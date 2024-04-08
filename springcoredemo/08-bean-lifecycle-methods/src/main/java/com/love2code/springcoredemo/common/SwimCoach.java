package com.love2code.springcoredemo.common;




public class SwimCoach implements Coach{



    public SwimCoach(){
        System.out.println("Swim coach is being instantiated");

    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up";
    }
}
