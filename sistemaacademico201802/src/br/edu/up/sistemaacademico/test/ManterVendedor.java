package br.edu.up.sistemaacademico.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.sistemaacademico.entity.Vendedor;
import br.edu.up.sistemaacademico.service.VendedorService;
import br.edu.up.sistemaacademico.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterVendedor {
	
	static Long id;
	
	@Test
	public void deveriaCadastrarUmVendedor() {
		Vendedor v = new Vendedor();
		v.setId(null);
		v.setNome("Cleverson");
		
		try {
			new VendedorService().salvar(v);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		assertEquals(true, v.getId() != null);
		id = v.getId();
	}
	
	@Test
	public void deveriaAlterarUmVendedor() {
		Vendedor v = new VendedorService().buscar(id);
		v.setNome("ABC");
		
		try {
			new VendedorService().salvar(v);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		v = new VendedorService().buscar(id);
		assertEquals(true, v.getNome().equals("ABC"));		
	}
	
	@Test
	public void deveriaListarOsVendedors() {
		List<Vendedor> produtos = new VendedorService().listar();
		assertEquals(true, produtos != null && produtos.size() > 0);
	}
	
	@Test
	public void deveriaExcluirOVendedor() {
		Vendedor v = new VendedorService().buscar(id);
		new VendedorService().excluir(v);
		
		Vendedor pExcluido = new VendedorService().buscar(id);
		assertEquals(true, pExcluido == null);
	}
}
