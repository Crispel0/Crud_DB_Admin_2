package com.example.practica.curso.controllers;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.curso.dao.CursosDao;
import com.example.practica.curso.models.Cursos;

@RestController
public class AuthController {
	
	private CursosDao cursoDao;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST) //specify that is method of type delete in the moment of delete some course with id
	public boolean login(@RequestBody Cursos curso) {
		if(cursoDao.verificar(curso)) {
			System.out.println("OK");
			return true;
		}
		System.out.println("Fail");
		return false;
	}

}

