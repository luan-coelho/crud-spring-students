package com.students.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.crud.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
	
}
