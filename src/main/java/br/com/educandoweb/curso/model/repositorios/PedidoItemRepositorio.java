package br.com.educandoweb.curso.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.curso.model.entidades.PedidoItem;

public interface PedidoItemRepositorio extends JpaRepository<PedidoItem, Long> {

}
