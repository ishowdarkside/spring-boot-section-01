package com.ishowdarkside.demo.dao;


import com.ishowdarkside.demo.entity.Course;
import com.ishowdarkside.demo.entity.Instructor;
import com.ishowdarkside.demo.entity.InstructorDetail;
import com.ishowdarkside.demo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.TransactionScoped;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List<Course> findCoursesByInstructorId(int id) {


        // create query
        TypedQuery<Course> typedQuery = this.entityManager.createQuery(
                "from Course where instructor.id = :data",Course.class);
        typedQuery.setParameter("data",id);

        List<Course> courseList = typedQuery.getResultList();
        return courseList;

    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> typedQuery = this.entityManager.createQuery(
                "select e from Instructor e " +
                        "JOIN FETCH e.courses " +
                "where e.id = :data",Instructor.class);

        typedQuery.setParameter("data",id);
        return typedQuery.getSingleResult();



    }

    @Override
    @Transactional
    public void update(Instructor instructor) {

        this.entityManager.merge(instructor);

    }

    @Override
    @Transactional
    public void update(Course course) {

        this.entityManager.merge(course);

    }

    @Override
    public Course findCourseById(int id) {
        return this.entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {

        Instructor instructor = this.entityManager.find(Instructor.class,id);
        List<Course> courseList = instructor.getCourses();

        courseList.stream().forEach(e -> e.setInstructor(null));
        this.entityManager.remove(instructor);

    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {

        Course course = this.entityManager.find(Course.class,id);
        this.entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {

        this.entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id =:data",Course.class);
        query.setParameter("data",id);
        return query.getSingleResult();
    }

    @Override
    public Course findCourseAndStudentsByCourseId(int id) {

        // create query
        TypedQuery<Course> courseTypedQuery = this.entityManager.createQuery("select c from Course c JOIN FETCH c.students where c.id =:data",Course.class);
        courseTypedQuery.setParameter("data",id);
        // execute query
        return courseTypedQuery.getSingleResult();

    }

    @Override
    public Student findCoursesAndStudentByStudentId(int id) {

        TypedQuery<Student> studentTypedQuery = this.entityManager.createQuery("select s from Student s JOIN FETCH s.courses where s.id = :data",Student.class);
        studentTypedQuery.setParameter("data",id);
        return studentTypedQuery.getSingleResult();

    }

    @Override
    @Transactional
    public void update(Student student) {

        this.entityManager.merge(student);

    }

    @Override
    @Transactional
    public void deleteStudentById(int id) {

        Student student = this.entityManager.find(Student.class,id);
        this.entityManager.remove(student);

    }


}
