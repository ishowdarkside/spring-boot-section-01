package com.ishowdarkside.cruddemo.dao;

import com.ishowdarkside.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;


@Repository
public class StudentDAOimpl implements StudentDAO{


    // define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor
    public StudentDAOimpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    // implement save method
    @Override
    @Transactional
    public void save(Student student) {

        entityManager.persist(student);

    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);

    }

    @Override
    public List<Student> findAll() {

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student",Student.class);
        return  theQuery.getResultList();
    }

    public List<Student> findByLastName(String input){

        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName=:parameter",Student.class);
        theQuery.setParameter("parameter",input);
        return  theQuery.getResultList();


    }

    @Override
    @Transactional
    public void update(Student student) {

        entityManager.merge(student);

    }

    @Override
    @Transactional
    public void delete(int id) {

        // retreive student
        Student student = entityManager.find(Student.class,id);

        // delete student
        entityManager.remove(student);


    }

    @Override
    @Transactional
    public int deleteAll() {


        int deletedCount = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return deletedCount;


    }


}
