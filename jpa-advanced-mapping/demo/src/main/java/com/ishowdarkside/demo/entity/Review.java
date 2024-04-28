package com.ishowdarkside.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @Column(name = "course_id")
    private Course course;
}
