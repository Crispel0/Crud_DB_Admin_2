package com.example.practica.curso.controllers;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties.Jwt;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.curso.dao.CursosDao;
import com.example.practica.curso.models.Cursos;
import com.example.practica.curso.util.JWTUtil;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class ControllersCursos {
	
	@Autowired
	private CursosDao cursoDao;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	@RequestMapping(value="api/cursos", method = RequestMethod.GET)
	public List<Cursos> getCursos (@RequestHeader(value ="Authorization") String token){
		
		if(!validarToken(token)) {
			return null;
		}
		
		return cursoDao.getCursos();

	}
	public boolean validarToken(String token) {
		String usuarioID = jwtUtil.getKey(token);
		return usuarioID != null;		
	}
	
	@RequestMapping(value = "api/cursos/{id}", method = RequestMethod.DELETE) //specify that is method of type delete in the moment of delete some course with id
	public void eliminar(@PathVariable int id, @RequestHeader(value="Authorization") String token) { //receive for the route of the PathVV
		
		if(!validarToken(token)) {
			return;
		}
		cursoDao.eliminar(id);
	}
	
	@RequestMapping(value = "api/cursos", method = RequestMethod.POST) //specify that is method of type delete in the moment of delete some course with id
	public void registrar(@RequestBody Cursos curso ) { //send the request for the body of the function
		
			Argon2 creacionHash = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			
			String hashPassword = creacionHash.hash(1, 1024, 1, curso.getPassword());
			curso.setPassword(hashPassword);
			cursoDao.registrar(curso);
			
	}
}