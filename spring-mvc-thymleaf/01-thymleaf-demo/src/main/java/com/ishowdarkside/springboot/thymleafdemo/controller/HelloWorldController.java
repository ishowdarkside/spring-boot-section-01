package com.ishowdarkside.springboot.thymleafdemo.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {


    // need a controller method to show initial HTML form

    @GetMapping("/showForm")
    public String showForm(){
        return "helloworld-form";
    }

    // need a controller method to proccess the HTML form
    @RequestMapping("/processForm")
    public String processForm(){
        return "helloworld";
    }

    // need a controller method to rread data and
    // add data to the model


    @RequestMapping("/processFormVersionTwo")
    public String letsShoutDude(HttpServletRequest request, Model model){

        // read the request parametar from the HTML form
        String name = request.getParameter("studentName");
        // convert data to all caps
        name = name.toUpperCase();
        // create the message
        String message = "Yo! " + name;
        // add message to the model
        model.addAttribute("message",message);
        return "helloworld";

    }

    @PostMapping("/processFormVersionThree")
    public String letsShoutWithRequestParamAnnotation(@RequestParam("studentName") String studentName, Model model){

        // read the request parametar from the HTML form

        // convert data to all caps
        String name = studentName.toUpperCase();
        // create the message
        String message = "Yo! " + name;
        // add message to the model
        model.addAttribute("message",message);
        return "helloworld";

    }

}
