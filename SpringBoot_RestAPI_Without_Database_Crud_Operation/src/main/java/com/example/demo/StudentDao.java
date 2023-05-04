package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
public class StudentDao implements StudentService {

	List<Student> students = new ArrayList<>();

	public List<Student> getall() {

		students.add(new Student(1, "Vishnu", "Bihar"));
		students.add(new Student(2, "Mohan", "Patna"));
		students.add(new Student(3, "sohan", "Hyderabad"));

		return students;
	}

	public Student insert(Student s) {
		students.add(s);
		return s;
	}

	public void delete(int id) {

		students = students.stream().filter(st -> st.getStudentId() != id).collect(Collectors.toList());

	}

	public void update(Student student, int sId) {

		students.stream().map(b->{
			if(b.getStudentId()==sId) {
				b.setStudentName(student.getStudentName());
				b.setStudentAddress(student.getStudentAddress());
			}
			return b;
		}).collect(Collectors.toList());
	}
	
	
	public Student getById(int id) {
		
		Student student = null;
		student = students.stream().filter(e->e.getStudentId()==id).findFirst().get();
		
		return student;
	}

}
