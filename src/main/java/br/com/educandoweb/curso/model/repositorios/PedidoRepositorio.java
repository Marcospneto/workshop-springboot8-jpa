package br.com.educandoweb.curso.model.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.educandoweb.curso.model.entidades.Pedido;

public interface PedidoRepositorio extends JpaRepository<Pedido, Long> {

}
