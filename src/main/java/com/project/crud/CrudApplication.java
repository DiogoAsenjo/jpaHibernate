package com.project.crud;

import com.project.crud.dao.StudentDAO;
import com.project.crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
			createStudent(studentDAO);
		};
	}

	private void remove(StudentDAO studentDAO, Student student) {
		studentDAO.delete(student);
	}

	private void update(StudentDAO studentDAO, Student student) {
		studentDAO.update(student);
	}

	private void createStudent(StudentDAO studentDAO) {
		Student student = new Student("Diogo", "Asenjo", "diogoasenjo@outlook.com");
		studentDAO.save(student);
	}

	private Student findStudentById(StudentDAO studentDAO) {
		Student student = studentDAO.findById(10);
		System.out.println(student);
		return student;
	}

	private void getAllStudentes(StudentDAO studentDAO) {
		List<Student> studentList = studentDAO.getAll();
		studentList.forEach(student -> {
			System.out.println(student.toString());
		});
	}
}
