package br.com.educandoweb.curso.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.curso.model.entidades.Usuario;
import br.com.educandoweb.curso.model.repositorios.UsuarioRepositorio;

@Service
public class UsuarioServico {
	@Autowired
	private UsuarioRepositorio repositorio;
	
	public List<Usuario> findAll(){
		return repositorio.findAll();
	}
	
	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.get();
	}

}