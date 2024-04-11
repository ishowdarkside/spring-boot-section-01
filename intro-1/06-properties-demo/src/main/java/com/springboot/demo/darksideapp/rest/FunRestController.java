package com.springboot.demo.darksideapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@RestController
public class FunRestController {

    //inject properties for:coach.name and team.name
    @Value("${coach.name}")
    private String coachName;
    @Value("${team.name}")
    private String teamName;


    // expose new enpoint for "teaminfo"
    @GetMapping("/teaminfo")
    public String teamInfo(){
        return  coachName + " Team Name:" + teamName;
    }


    //expose "/" that returns "Hello World"
    @GetMapping("/")
    public String HelloWorld(){
        return "Hello World i guess";
    }
    //endopoint for "workout"
    @GetMapping ("/workout")
    public String getDailyWrokout(){
        return "Run a hard 5k!";
    }

    //expose a new endpoint for "fortune"
    @GetMapping("/fortune")
    public String getFortune(){
        ArrayList<String> fortunes = new ArrayList<>(List.of("Today is your lucky day","Como complemenda"));
        return  fortunes.get((int)Math.round(Math.random() * 3 -1));
    }
}
