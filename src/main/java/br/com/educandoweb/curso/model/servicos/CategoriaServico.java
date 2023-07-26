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

}
