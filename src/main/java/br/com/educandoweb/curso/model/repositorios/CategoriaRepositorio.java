package br.com.educandoweb.curso.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.curso.model.entidades.Categoria;

public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {

}
