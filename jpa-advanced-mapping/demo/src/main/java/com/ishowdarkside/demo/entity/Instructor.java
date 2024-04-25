package com.ishowdarkside.demo.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "instructor")
public class Instructor {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instructor_detail_id")
    public InstructorDetail instructorDetail;

    @OneToMany(mappedBy = "instructor",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<Course> courses;
    public Instructor(){};

    public Instructor(String firstName, String lastName, String  email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;

    }


    public String getFirstName(){
        return  this.firstName;
    }

    public  String getLastName(){
        return  this.lastName;
    }

    public String  getEmail(){
        return  this.email;
    }

    public int getId(){
        return  this.id;
    }

    public void setFirstName(String input){
        this.firstName = input;
    }

    public void setLastName(String input){
        this.lastName = input;
    }

    public void setEmail(String input){
        this.email = input;
    }

    public void setId(int id){
        this.id = id;
    }

    public InstructorDetail getInstructorDetail(){
        return  this.instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail){
        this.instructorDetail = instructorDetail;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // add convenience methods for bi-directional relationship

    public void add(Course course){
        if(courses == null) this.courses = new ArrayList<>();

        courses.add(course);
        course.setInstructor(this);

    }

    @Override
    public String toString() {
        return "Instructor{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", instructorDetail=" + instructorDetail +
                '}';
    }
}
