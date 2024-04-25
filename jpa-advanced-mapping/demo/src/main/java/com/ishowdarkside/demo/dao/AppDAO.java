package com.ishowdarkside.demo.dao;

import com.ishowdarkside.demo.entity.Instructor;
import com.ishowdarkside.demo.entity.InstructorDetail;

public interface AppDAO {


    void save(Instructor instructor);


    Instructor findInstructorById(int id);


    void deleteInstructoById(int id);

    InstructorDetail findInstructorDetailById(int id);

    void deleteInstructorDetailById(int id);
}
