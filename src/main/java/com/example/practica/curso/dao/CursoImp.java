package com.example.practica.curso.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.practica.curso.models.Cursos;

import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CursoImp implements CursosDao {
	
	@Autowired
	private EntityManager entityManager; //make connection with the BD also is a dependency where used this in differents method of the the class
	@Override
	public List<Cursos> getCursos() { //consulta base datos
		String query = "FROM cursos";
		List<Cursos> cursos = entityManager.createQuery(query).getResultList();//take the query where call the information of the BD and convert this in a resultList
		System.out.println(cursos.toArray());
		return cursos;

	}

	@Override
	public void eliminar(int id) {
		Cursos curso = entityManager.find(Cursos.class, id); //search in the db depend of the Curso selected and your ID
		entityManager.remove(curso);
	}

	@Override
	public void registrar(Cursos curso) {
		entityManager.merge(curso);
		
	}

	

	@Override
	public boolean verificar(Cursos cursos) {
		String query = "FROM Cursos WHERE email = :email AND password = :password";
		List<Cursos> lista = entityManager.createQuery(query).setParameter("email", cursos.getEmail())
            .setParameter("password", cursos.getPassword())
            .getResultList();
		
		return !lista.isEmpty();
		
				
	}

	
}

