package com.example.practica.curso.models;


import jakarta.persistence.Column;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
@Table(name = "cursos")
@Entity(name="cursos")
public class Cursos {
	
	@Getter @Setter
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private int id;
	
	@Column(name = "nombre")
	@Getter @Setter
	private String nombre;
	
	@Column(name = "tiempo")
	@Getter @Setter
	private int tiempo;
	
	@Column(name= "email")
	@Getter @Setter
	private String email;
	
	@Column(name = "instructor")
	@Getter @Setter
	private String instructor;
	
	@Column(name = "password")
	@Getter @Setter
	private String password;
	
}
