package com.ishowdarkside.demo.dao;

import com.ishowdarkside.demo.entity.Course;
import com.ishowdarkside.demo.entity.Instructor;
import com.ishowdarkside.demo.entity.InstructorDetail;
import jakarta.persistence.TypedQuery;

import java.util.List;

public interface AppDAO {


    void save(Instructor instructor);


    Instructor findInstructorById(int id);



    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);

    List<Course> findCoursesByInstructorId(int id);

    Instructor findInstructorByIdJoinFetch(int id);

    void update(Instructor instructor);

    void update(Course course);

    Course findCourseById(int id);

    void deleteInstructorById(int id);

    void deleteCourseById(int id);

}
