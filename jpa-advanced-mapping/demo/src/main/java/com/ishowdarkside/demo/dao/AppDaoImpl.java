package com.ishowdarkside.demo.dao;


import com.ishowdarkside.demo.entity.Instructor;
import com.ishowdarkside.demo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AppDaoImpl implements  AppDAO {


    private EntityManager entityManager;

    @Autowired
    public AppDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructoById(int id) {
        Instructor instructor = this.entityManager.find(Instructor.class,id);

        this.entityManager.remove(instructor);

    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class,id);
        return  instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail instructorDetail = this.entityManager.find(InstructorDetail.class,id);

        // remove the associated object reference
        Instructor instructor = instructorDetail.getInstructor();
        instructor.setInstructorDetail(null);

        this.entityManager.remove(instructorDetail);
    }
}
