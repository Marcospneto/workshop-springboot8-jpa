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

	public List<Pedido> findAll() {
		return repositorio.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> obj = repositorio.findById(id);
		return obj.get();
	}

	public Pedido insert(Pedido obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public Pedido update(Long id, Pedido obj) {
		Pedido entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Pedido entity, Pedido obj) {
		entity.setCliente(obj.getCliente());
		entity.setMomento(obj.getMomento());
		entity.setPagamento(obj.getPagamento());
		entity.setPedidoStatus(obj.getPedidoStatus());
		
	}

}
