package com.ishowdarkside.cruddemo;

import com.ishowdarkside.cruddemo.dao.StudentDAO;
import com.ishowdarkside.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {

			createStudent(studentDAO);
			//readStudent(studentDAO);
			//queryForStudents(studentDAO);
			//getByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO){
		int numOfDeletions = studentDAO.deleteAll();
		System.out.println(numOfDeletions);

	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 3134;
		System.out.println("Dleteing student id: " + studentId);
		studentDAO.delete(studentId);
		System.out.println("Deleting the student..");


	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		System.out.println("Updating sutdent...");
		// change first name to "Ajdin"
		myStudent.setFirstName("Ajdin");

		// update student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);
	}

	private void getByLastName(StudentDAO studentDAO) {

		List<Student> omerovicStudents = studentDAO.findByLastName("Omerovic");

		for(Student std : omerovicStudents){
			System.out.println(std);
		}

	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> studentList = studentDAO.findAll();

		for(Student std : studentList) {
			System.out.println(std);
		}


		//display lsit of students

	}



	private void readStudent(StudentDAO studentDAO) {

		Student newStudent = new Student("Ajdin","Omerovic","Ajdin.work@gmail.com");
		studentDAO.save(newStudent);

		Student retreivedStudent =  studentDAO.findById(newStudent.getId());
		System.out.println(retreivedStudent);


	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		Student student = new Student("Jakarta","Jaksimovic","jakarta@gmail.com");
		Student student1 = new Student("Jakarta","Jaksimovic","jakarta@gmail.com");
		Student student2 = new Student("Jakarta","Jaksimovic","jakarta@gmail.com");
		studentDAO.save(student);
		studentDAO.save(student1);
		studentDAO.save(student2);
		// save the student object

		//display id of the saved student
		System.out.println("Saved student." +  student.getId());
	}

}
