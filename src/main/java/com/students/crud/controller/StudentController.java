package com.students.crud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.students.crud.model.Student;
import com.students.crud.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping
	public String findAll(Model model) {
		
		List <Student> students = studentService.findAll();
		students.forEach(student -> student.setPassword(student.getPassword().replaceAll(".", "*")));
				
		model.addAttribute("students", students);

		return "students.html";
	}

	@GetMapping("/register")
	public String registerStudent(Model model) {
		model.addAttribute("student", new Student());

		return "register-student.html";
	}

	@PostMapping
	public String saveStudent(@ModelAttribute("student") @Valid Student student) {
		studentService.save(student);

		return "redirect:/students";
	}

	@GetMapping("/edit/{id}")
	public String editStudent(@PathVariable("id") Long id, Model model) {
				
		Student student = null;
		
		try {
			student = studentService.findById(id);
		} catch (Exception e) {
			return "redirect:/students";
		}
		
		model.addAttribute("student", student);
		return "edit-student.html";
	}

	@PostMapping("/{id}")
	public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student,
			Model model){
		
			Student studentExists = null;
			try {
				studentExists = studentService.findById(id);
			} catch (Exception e) {
				e.printStackTrace();
			}

		if (studentExists != null) {
			String password = studentExists.getPassword();
			studentExists = student;
			studentExists.setPassword(password);
			studentService.update(studentExists);
		}

		return "redirect:/students";
	}

	@GetMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		studentService.delete(id);

		return "redirect:/students";
	}
}
