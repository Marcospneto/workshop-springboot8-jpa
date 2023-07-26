package br.com.educandoweb.curso.control.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.educandoweb.curso.model.entidades.Produto;
import br.com.educandoweb.curso.model.servicos.ProdutoServico;

@RestController
@RequestMapping (value = "/produtos")
public class ProdutoResource {
	@Autowired
	private ProdutoServico servico;
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> list = servico.findAll();
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value = "/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Long id){
		Produto obj = servico.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
