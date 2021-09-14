package com.SpringDemo.demo;

import com.SpringDemo.demo.entity.Student;
import com.SpringDemo.demo.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringdemoApplicationTests {

	@Autowired
	private StudentRepository studentRepository;

	@Test
	void saveStudent(){
		Student student= Student.builder()
				.firstName("Dang")
				.lastName("Vu")
				.email("khanhdang250320@gmail.com")
				.build();
		Student student2= Student.builder()
				.firstName("Dinh")
				.lastName("Khanh")
				.email("vudang.it@gmail.com")
				.build();
		studentRepository.save(student);
		studentRepository.save(student2);
	}

	@Test
	void printAllStudent(){
		List<Student> studentList=studentRepository.findAll();
		System.out.println("list-student" + studentList);
	}

	@Test
	void deleteStudentById(){
		studentRepository.deleteById(1L);
	}

	@Test
	void updateStudentById(){
		Student student=studentRepository.getById(2L);
		Student studentUp = studentRepository.save(new Student(student.getId(),
				student.getFirstName()+"",student.getLastName()+"","vudang24.it@gmail.com"));
	}

}
