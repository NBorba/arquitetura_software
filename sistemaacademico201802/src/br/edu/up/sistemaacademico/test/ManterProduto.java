package br.edu.up.sistemaacademico.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.sistemaacademico.entity.Produto;
import br.edu.up.sistemaacademico.service.ProdutoService;
import br.edu.up.sistemaacademico.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterProduto {
	
	static Long id;
	
	@Test
	public void deveriaCadastrarUmProduto() {
		Produto p = new Produto();
		p.setId(null);
		p.setNome("Cleverson");
		
		try {
			new ProdutoService().salvar(p);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		assertEquals(true, p.getId() != null);
		id = p.getId();
	}
	
	@Test
	public void deveriaAlterarUmProduto() {
		Produto p = new ProdutoService().buscar(id);
		p.setNome("ABC");
		
		try {
			new ProdutoService().salvar(p);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		p = new ProdutoService().buscar(id);
		assertEquals(true, p.getNome().equals("ABC"));		
	}
	
	@Test
	public void deveriaListarOsProdutos() {
		List<Produto> produtos = new ProdutoService().listar();
		assertEquals(true, produtos != null && produtos.size() > 0);
	}
	
	@Test
	public void deveriaExcluirOProduto() {
		Produto p = new ProdutoService().buscar(id);
		new ProdutoService().excluir(p);
		
		Produto pExcluido = new ProdutoService().buscar(id);
		assertEquals(true, pExcluido == null);
	}
}
