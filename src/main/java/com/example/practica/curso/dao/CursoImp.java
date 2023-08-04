package com.example.practica.curso.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.practica.curso.models.Cursos;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import de.mkammerer.argon2.Argon2Factory.Argon2Types;
import jakarta.persistence.EntityManager;

@Repository
@Transactional
public class CursoImp implements CursosDao {
	
	@Autowired
	private EntityManager entityManager; //make connection with the BD also is a dependency where used this in differents method of the the class
	
	@Override
	public List<Cursos> getCursos() { //consulta base datos
		String query = "FROM cursos";
		return entityManager.createQuery(query).getResultList();//take the query where call the information of the BD and convert this in a resultList
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
	public Cursos verificar(@RequestBody Cursos cursos) {
		
		String query = "FROM Cursos WHERE email = :email ";
		List<Cursos> lista = entityManager.createQuery(query).setParameter("email", cursos.getEmail())
            .getResultList();
		
		if(lista.isEmpty()) { //verify if the list is empty if no obtein a email, in another hand follow with the process avoid a null punter exception
			return null;}
		
		String contrasenaRecuperada = lista.get(0).getPassword();
		Argon2 Argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
		if(Argon2.verify(contrasenaRecuperada, cursos.getPassword())) { //verifica si el hash creado es igual contraseña retorna, retorna cursos
			return lista.get(0);
		}
		else 
			return null;

	}

}

