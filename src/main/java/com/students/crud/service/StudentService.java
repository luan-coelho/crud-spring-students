package com.students.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.students.crud.model.Student;
import com.students.crud.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository repository;

	public List<Student> findAll() {
		return repository.findAll();
	}

	public Student findById(Long id) {
		return repository.findById(id).get();
	}
	
	public Student save(Student student) {
		return repository.save(student);
	}
	
	public Student update(Student student) {
		return repository.save(student);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
}
