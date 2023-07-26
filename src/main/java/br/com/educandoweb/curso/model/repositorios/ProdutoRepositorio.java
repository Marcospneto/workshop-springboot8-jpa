package br.com.educandoweb.curso.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.curso.model.entidades.Produto;

public interface ProdutoRepositorio extends JpaRepository<Produto, Long> {

}
