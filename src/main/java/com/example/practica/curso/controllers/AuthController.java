package com.example.practica.curso.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.curso.dao.CursosDao;
import com.example.practica.curso.models.Cursos;
import com.example.practica.curso.util.JwtUtil.JWTUtil;

@RestController
public class AuthController {
	
	@Autowired
	private CursosDao cursoDao;
	
	@Autowired
	private JWTUtil Jwtutil;
	
	@RequestMapping(value = "api/login", method = RequestMethod.POST) //specify that is method of type delete in the moment of delete some course with id
	public String login(@RequestBody Cursos curso) {
		
		Cursos verificacionCurso = cursoDao.verificar(curso);
		
		if(verificacionCurso != null) { //verifica el token obteniendo el id de cursos con el email del mismo
			String token = Jwtutil.create(String.valueOf(verificacionCurso.getId()), verificacionCurso.getEmail());
			return token;
		}
		
		return "no concuerdan credenciales";
		
	}

}

