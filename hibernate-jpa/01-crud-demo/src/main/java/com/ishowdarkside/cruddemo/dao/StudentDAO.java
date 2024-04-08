package com.ishowdarkside.cruddemo.dao;

import com.ishowdarkside.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);

    Student findById(int id);

    List<Student> findAll();

    List<Student> findByLastName(String input);

    void update(Student student);

    void delete(int id);

    int deleteAll();
}
