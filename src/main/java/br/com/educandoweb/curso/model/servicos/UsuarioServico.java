package br.com.educandoweb.curso.model.servicos;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.educandoweb.curso.model.entidades.Usuario;
import br.com.educandoweb.curso.model.repositorios.UsuarioRepositorio;
import br.com.educandoweb.curso.model.servicos.exceptions.ResourceNotFoundException;

@Service
public class UsuarioServico {
	@Autowired
	private UsuarioRepositorio repositorio;

	public List<Usuario> findAll() {
		return repositorio.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> obj = repositorio.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public Usuario insert(Usuario obj) {
		return repositorio.save(obj);
	}

	public void delete(Long id) {
		repositorio.deleteById(id);
	}
	
	public Usuario update(Long id, Usuario obj) {
		Usuario entity = repositorio.getReferenceById(id);
		updateData(entity, obj);
		return repositorio.save(entity);
	}

	private void updateData(Usuario entity, Usuario obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		}

}
