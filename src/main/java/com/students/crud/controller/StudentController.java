package com.students.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.students.crud.model.Student;
import com.students.crud.service.StudentService;

@RestController
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping
	public String findAll(Model model) {
		model.addAttribute("students", studentService.findAll());
		
		return "students";
	}
	
	@GetMapping("/register")
	public String registerStudent(Model model) {
		model.addAttribute("student", new Student());
		
		return "register-student.html";
	}
	
	@PostMapping
	public String saveStudent(@ModelAttribute("student") Student student) {
		studentService.save(student);
		
		return "redirect:/students.html";
	}
	
	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") Long id, Model model) {
		model.addAttribute("student", studentService.findById(id));
		
		return "edit-student.html";
	}
	
	@PostMapping("/{id}")
	public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student ,Model model) {
		Student studentExists = studentService.findById(id);
		
		if(studentExists != null) {
			studentExists = student;
			studentService.update(studentExists);
		}
		
		return "redirect:/students.html";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.delete(id);
		
		return "redirect:/students.html";
	}
}
