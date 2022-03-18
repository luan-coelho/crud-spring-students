package com.students.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_student")
	private Long id;
	
	@NotBlank(message = "Preencha o nome")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "Preencha o sobrenome")
	@Column(nullable = false)
	private String surname;
	
	@Email(message = "Informe um email válido")
	@Column(nullable = false)
	private String email;
	
	@NotBlank(message = "Informe uma senha")
	@Column(nullable = false)
	private String password;
}
