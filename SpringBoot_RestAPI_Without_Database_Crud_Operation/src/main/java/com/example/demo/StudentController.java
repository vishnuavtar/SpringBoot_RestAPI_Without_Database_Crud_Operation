package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StudentController {
	
	@Autowired
	private StudentDao dao;
	
	
	@GetMapping("/get")
	public List<Student> getall() {
		return dao.getall();
	}
	
	
	@PostMapping("/insert")
	public Student insert(@RequestBody Student s) {
	
		return dao.insert(s);
	}

	
	@DeleteMapping("/student/{studentId}")
	public void delete(@PathVariable("studentId") int studentId) {
		
	      dao.delete(studentId);
	}
	
	@PutMapping("/student/{studentId}")
	public Student update(@RequestBody Student student, @PathVariable("studentId") int studentId ) {
		
		dao.update(student,studentId);
		return student;
	}
	
	@GetMapping("/get/{studentId}")
	public Student getById(@PathVariable("studentId") int studentId) {
		
		return dao.getById(studentId);
	}
	
}
