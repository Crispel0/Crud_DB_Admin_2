package com.example.practica.curso.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.practica.curso.dao.CursosDao;
import com.example.practica.curso.models.Cursos;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class ControllersCursos {
	
	@Autowired
	private CursosDao cursoDao;
	
	
	@RequestMapping(value="api/cursos", method = RequestMethod.GET)
	public List<Cursos> getCursos () {
		return cursoDao.getCursos();

	}
	
	@RequestMapping(value = "api/cursos/{id}", method = RequestMethod.DELETE) //specify that is method of type delete in the moment of delete some course with id
	public void eliminar(@PathVariable int id) { //receive for the route of the PathVV
		cursoDao.eliminar(id);
	}
	
	@RequestMapping(value = "api/cursos", method = RequestMethod.POST) //specify that is method of type delete in the moment of delete some course with id
	public void registrar(@RequestBody Cursos curso ) { //send the request for the body of the function
		
			Argon2 creacionHash = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
			
			String hashPassword = creacionHash.hash(1, 1024, 1, curso.getPassword());
			System.out.print("contra " + hashPassword);//hash the password making a iteration with 1024 kb for memory and 1 thread of execution
			curso.setPassword(hashPassword);
			cursoDao.registrar(curso);
			
	}
}