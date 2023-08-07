package com.example.practica.curso.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.practica.curso.models.Cursos;

@Repository
@Transactional
public interface CursosDao {

	List<Cursos> getCursos();
	void registrar(Cursos curso);
	void eliminar(int id);
	Cursos verificar(Cursos cursos);
}

