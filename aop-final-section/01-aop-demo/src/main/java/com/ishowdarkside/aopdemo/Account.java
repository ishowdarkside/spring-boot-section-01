package com.ishowdarkside.aopdemo;



public class Account {


    private String name;
    private String level;

    public Account(String name,String level){
        this.name = name;
        this.level = level;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public String getName(){
        return  this.name;
    }

    public String getLevel(){
        return  this.level;
    }
}
