package com.ishowdarkside.demo.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {


    // define the fields

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;


    @Column(name = "youtube_channel")
    private String youtubeChannel;

    @Column(name = "hobby")
    private String hobby;



    // add @OneToOne annotation
    @OneToOne(mappedBy = "instructorDetail",cascade = {CascadeType.DETACH,CascadeType.PERSIST,CascadeType.REFRESH})
    private Instructor instructor;


    // create constructors
    public InstructorDetail(){};
    public InstructorDetail(String youtubeChannel, String hobby){

        this.youtubeChannel = youtubeChannel;
        this.hobby = hobby;

    };

    // generate getter / setter methods

    public Instructor getInstructor(){
        return  this.instructor;
    }

    public void setInstructor(Instructor instructor){
        this.instructor = instructor;
    }
    public String getYoutubeChannel(){
        return  this.youtubeChannel;
    }

    public String getHobby(){
        return  this.hobby;
    }

    public int getId(){
        return  this.id;
    }

    public void setYoutubeChannel(String input){
        this.youtubeChannel = input;
    }

    public void setHobby(String input){
        this.hobby = input;
    }

    public void setId(int id){
        this.id = id;
    }
    // generate toString() method


    @Override
    public String toString() {
        return "InstructorDetail{" +
                "id=" + id +
                ", youtubeChannel='" + youtubeChannel + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }
}


