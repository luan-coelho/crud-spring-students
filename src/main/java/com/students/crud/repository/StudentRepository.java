package com.students.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.crud.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
