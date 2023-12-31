package br.com.educandoweb.curso.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.curso.model.entidades.Categoria;
import br.com.educandoweb.curso.model.repositorios.CategoriaRepositorio;

@Service
public class CategoriaServico {
	@Autowired
	private CategoriaRepositorio repositorio;
	
	public List<Categoria> findAll(){
		return repositorio.findAll();
	}
	
	public Categoria findById(Long id) {
		Optional<Categoria> obj = repositorio.findById(id);
		return obj.get();
	}

	public Categoria insert (Categoria obj) {
		return repositorio.save(obj);
	}
	
	public void delete (Long id) {
		repositorio.deleteById(id);
	}
	
	public Categoria update (Long id, Categoria obj) {
		Categoria entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Categoria entity, Categoria obj) {
		entity.setNome(obj.getNome());
		
	}
}
