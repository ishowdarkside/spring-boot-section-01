package com.ishowdarkside.demo.rest;


import com.ishowdarkside.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {


    private List<Student> theStudents = new ArrayList<>();

    @PostConstruct
    public void loadData(){
        theStudents.add(new Student("Ajdinko","Maksimilian"));
        theStudents.add(new Student("Nedimko","Usrankovic"));
        theStudents.add(new Student("Aki","Kawasaki"));

    }

    @GetMapping("/students")
    public List<Student> getStudents(){

        return theStudents;
    }

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        //check if index is out of bounds
        if(studentId >= theStudents.size() || studentId < 0) throw new StudentNotFoundException("Student not found - " + studentId);
        return theStudents.get(studentId);

    }




}
