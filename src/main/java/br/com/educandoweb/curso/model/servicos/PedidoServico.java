package br.com.educandoweb.curso.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.curso.model.entidades.Pedido;
import br.com.educandoweb.curso.model.repositorios.PedidoRepositorio;

@Service
public class PedidoServico {
	@Autowired
	private PedidoRepositorio repositorio;
	
	public List<Pedido> findAll(){
		return repositorio.findAll();
	}
	
	public Pedido findById(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}

}
