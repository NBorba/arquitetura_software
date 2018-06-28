package br.com.rblstudios.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.rblstudios.entity.Produto;
import br.com.rblstudios.facade.DogaoOnDemandFacade;
import br.com.rblstudios.service.ProdutoService;
import br.com.rblstudios.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterProduto {
	
	static Long id;
	DogaoOnDemandFacade dogaoOnDemandFacade = new DogaoOnDemandFacade();
	
	@Test
	public void deveriaCadastrarUmProduto() {
		Produto p = new Produto();
		p.setId(null);
		p.setNome("Pendrive");
		p.setEstoque(0);
		p.setValor(0.0);
		
		try {
			dogaoOnDemandFacade.salvarProduto(p);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		assertEquals(true, p.getId() != null);
		id = p.getId();
	}
	
	@Test
	public void deveriaAlterarUmProduto() {
		Produto p = dogaoOnDemandFacade.buscarProduto(id);
		p.setNome("SSD");
		p.setEstoque(1);
		p.setValor(1.0);
		
		try {
			dogaoOnDemandFacade.salvarProduto(p);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		p = dogaoOnDemandFacade.buscarProduto(id);
		assertEquals(true, p.getNome().equals("SSD"));		
	}
	
	@Test
	public void deveriaListarOsProdutos() {
		List<Produto> produtos = dogaoOnDemandFacade.listarProdutos();
		assertEquals(true, produtos != null && produtos.size() > 0);
	}
	
	@Test
	public void deveriaExcluirOProduto() {
		Produto p = dogaoOnDemandFacade.buscarProduto(id);
		dogaoOnDemandFacade.excluirProduto(p);
		
		Produto pExcluido = dogaoOnDemandFacade.buscar(id);
		assertEquals(true, pExcluido == null);
	}
}
