package br.com.educandoweb.curso.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.curso.model.entidades.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
