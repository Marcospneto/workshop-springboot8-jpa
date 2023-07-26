package br.com.educandoweb.curso.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.educandoweb.curso.model.entidades.Categoria;
import br.com.educandoweb.curso.model.entidades.Pagamento;
import br.com.educandoweb.curso.model.entidades.Pedido;
import br.com.educandoweb.curso.model.entidades.PedidoItem;
import br.com.educandoweb.curso.model.entidades.Produto;
import br.com.educandoweb.curso.model.entidades.Usuario;
import br.com.educandoweb.curso.model.entidades.enums.PedidoStatus;
import br.com.educandoweb.curso.model.repositorios.CategoriaRepositorio;
import br.com.educandoweb.curso.model.repositorios.PedidoItemRepositorio;
import br.com.educandoweb.curso.model.repositorios.PedidoRepositorio;
import br.com.educandoweb.curso.model.repositorios.ProdutoRepositorio;
import br.com.educandoweb.curso.model.repositorios.UsuarioRepositorio;

@Configuration
@Profile("test")
public class TesteConfig implements CommandLineRunner{
	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	@Autowired
	private PedidoRepositorio pedidoRepositorio;
	@Autowired
	private CategoriaRepositorio categoriaRepositorio;
	@Autowired
	private ProdutoRepositorio produtoRepositorio;
	@Autowired
	private PedidoItemRepositorio pedidoItemRepositorio;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Eletronicos");
		Categoria cat2 = new Categoria(null, "Computadores");
		Categoria cat3 = new Categoria(null, "Livros");
		categoriaRepositorio.saveAll(Arrays.asList(cat1, cat2));
		
		Produto produto1 = new Produto(null, "Senhor dos Aneis", "Saga 1", 90.5, null);
		Produto produto2 = new Produto(null, "Smart TV", "43 Polegadas", 2452.5, null);
		Produto produto3 = new Produto(null, "Pc Gamer", "i3 10100", 3450.0, null);
		produtoRepositorio.saveAll(Arrays.asList(produto1, produto2, produto3));
		
		produto1.getCategorias().add(cat3);
		produto2.getCategorias().add(cat1);
		produto3.getCategorias().add(cat2);
		
		produtoRepositorio.saveAll(Arrays.asList(produto1, produto2, produto3));

		Usuario u1 = new Usuario(null, "Marcos", "marcos@gmail.com", "123456");
		Usuario u2 = new Usuario(null, "Larissa", "larissa@gmail.com", "654321");
		usuarioRepositorio.saveAll(Arrays.asList(u1, u2));
		
		Pedido p1 = new Pedido(null, Instant.parse("2023-07-20T19:53:22Z"), PedidoStatus.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2023-05-03T09:47:11Z"), PedidoStatus.CANCELADO, u2);
		pedidoRepositorio.saveAll(Arrays.asList(p1, p2));
		
		PedidoItem pi1 = new PedidoItem(p1, produto3, 1, produto3.getPreco());
		PedidoItem pi2 = new PedidoItem(p1, produto2, 2, produto2.getPreco());
		PedidoItem pi3 = new PedidoItem(p2, produto1, 1, produto1.getPreco());
		pedidoItemRepositorio.saveAll(Arrays.asList(pi1, pi2, pi3));
		
		Pagamento pag1 = new Pagamento(null, Instant.parse("2023-07-20T21:53:22Z"), p1);
		p1.setPagamento(pag1);
		pedidoRepositorio.save(p1);
		
		
	}
	
}
