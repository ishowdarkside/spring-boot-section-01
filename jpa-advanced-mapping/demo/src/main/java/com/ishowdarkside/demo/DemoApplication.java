package com.ishowdarkside.demo;

import com.ishowdarkside.demo.dao.AppDAO;
import com.ishowdarkside.demo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {

		return runner -> {


//			createCourseAndStudents(appDAO);

		//	findCourseAndStudents(appDAO);

			//findStudentAndCourses(appDAO);

		//	addMoreCoursesForStudent(appDAO);

			//deleteCourseById(appDAO);

			deleteStudent(appDAO);
		};

	}

	private void deleteStudent(AppDAO appDAO) {

		int id = 1;
		appDAO.deleteStudentById(id);


	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {

		int id = 1;
		Student student = appDAO.findCoursesAndStudentByStudentId(id);
		student.addCourse(new Course("Ultimativna jebacina"));

		appDAO.update(student);


	}

	private void findStudentAndCourses(AppDAO appDAO) {

		int id = 1;
		Student student = appDAO.findCoursesAndStudentByStudentId(id);
		System.out.println(student.getCourses());
	}

	private void findCourseAndStudents(AppDAO appDAO) {

		int id = 10;
		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println(course.getStudents());
		System.out.println("Done!");

	}

	private void createCourseAndStudents(AppDAO appDAO) {

		// create a course
		Course course = new Course("Ultimate React Course 2024: Redux, ContextAPI and more!");
		// create the students
		Student student = new Student("Ajdin","Omerovic","ajdin@gmail.com");

		// add students to the course
		course.addStudent(student);
		// save the course and associated students
		appDAO.save(course);



	}

	private void deleteCourseAndReviews(AppDAO appDAO) {

		int id = 10;
		appDAO.deleteCourseById(id);


	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {

		// get the course and reviews
		Course course = appDAO.findCourseAndReviewsByCourseId(10);

		System.out.println(course);
		//print the course

		// print reviews
		System.out.println(course.getReviews());

	}

	private void createCourseAndReviews(AppDAO appDAO) {

		// create a course
		Course course = new Course("Ultimate Javascript Course");
		// add some reviews
		Instructor instructor = new Instructor("Jonas","Schmedttmann","hello@jonas.io");
		course.setInstructor(instructor);


		course.addReview(new Review("Najbolji kurs za javascript"));
		course.addReview(new Review("KURSINA KURCINA UU"));


		appDAO.save(course);
		// save the course

	}

	private void deleteCourseById(AppDAO appDAO) {

		int courseId = 14;
		appDAO.deleteCourseById(courseId);
		System.out.println("Guitar kurs obrisan");
	}

	private void updateCourse(AppDAO appDAO) {

		int courseId = 13;
		Course course = appDAO.findCourseById(courseId);
		course.setTitle("REACT 2025 NAJNOVIJI KURS");
		appDAO.update(course);


	}

	private void updateInstructor(AppDAO appDAO) {

		Instructor instructor = appDAO.findInstructorById(2);
		instructor.setFirstName("AJDINKOOO APDEJTOVANI");
		appDAO.update(instructor);

	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {

		int id = 2;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());

	}

	private void findCoursesForInstructor(AppDAO appDAO) {

		int id = 2;
		Instructor instructor = appDAO.findInstructorById(id);
		List<Course> courseList = appDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courseList);
		System.out.println(instructor.getCourses());


	}

	private void findInstructorWithCourses(AppDAO appDAO) {

	int id = 2;
	System.out.println("Finding instructor id: " + id);
	Instructor instructor = appDAO.findInstructorById(id);

	System.out.println("instructor: "+ instructor);
	System.out.println("the associated courses: "+ instructor.getCourses());
	System.out.println("DONE");

	}

	private void createInstructorWithCourses(AppDAO appDAO) {

		Instructor instructor = new Instructor("Ajdin","Omerovic","Ajdin.work@gmail.com");
		Course course = new Course("Ultimate React Course: Redux, React Query and More!");
		instructor.add(course);

		InstructorDetail instructorDetail = new InstructorDetail("youtub_link","weight-lifting");
		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air guitar - The Ultimate Guide");
		Course course2 = new Course("DIVA GRABOVECA - KURS");

		instructor.add(course1);
		instructor.add(course2);


		// save the instructor
		// Note : this will ALSO save the courses
		// because of CascadeType.PERSIST
		System.out.println("Saving the instructor: "+ instructor);
		System.out.println("The courses: "+ instructor.getCourses());
		appDAO.save(instructor);

	}

	private void deleteInstructorDetail(AppDAO appDAO) {

		int id = 3;
		appDAO.deleteInstructorDetailById(id);
		System.out.println("OBRISANO!");

	}

	private void findInstructorDetail(AppDAO appDAO) {

		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);
		System.out.println(instructorDetail);

	}

	private void deleteInstructor(AppDAO appDAO) {

		int id = 2;
		appDAO.deleteInstructorById(id);
		System.out.println("Luke skywalker obrisan");

	}

	private void findInstructor(AppDAO appDAO) {

		int theId = 2;
		System.out.println("finding the instructor id: " + theId);
		Instructor instructor = appDAO.findInstructorById(theId);

		System.out.println("instructor: " + instructor);
		System.out.println("associate instruvtorDetail only: " + instructor.getInstructorDetail());


	}

	public void createInstructor(AppDAO appDAO){

		Instructor instructor = new Instructor("Luke","Skywalker","Luke@darkside.com");
		InstructorDetail instructorDetail = new InstructorDetail("youtube.com/darkside","fighting");
		// associate the objects
		instructor.setInstructorDetail(instructorDetail);
		System.out.println(instructor);
		appDAO.save(instructor);

	}
}
