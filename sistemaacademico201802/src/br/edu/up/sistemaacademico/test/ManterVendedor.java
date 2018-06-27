package br.edu.up.sistemaacademico.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.sistemaacademico.entity.Vendedor;
import br.edu.up.sistemaacademico.facade.DogaoOnDemandFacade;
import br.edu.up.sistemaacademico.service.VendedorService;
import br.edu.up.sistemaacademico.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterVendedor {
	
	static Long id;
	DogaoOnDemandFacade dogaoOnDemandFacade = new DogaoOnDemandFacade();
	
	@Test
	public void deveriaCadastrarUmVendedor() {
		Vendedor v = new Vendedor();
		v.setId(null);
		v.setNome("Renan Vendedor");
		
		try {
			dogaoOnDemandFacade.salvarVendedor(v);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		assertEquals(true, v.getId() != null);
		id = v.getId();
	}
	
	@Test
	public void deveriaAlterarUmVendedor() {
		Vendedor v = new VendedorService().buscar(id);
		v.setNome("Renan Vendedor Dois");
		
		try {
			dogaoOnDemandFacade.salvarVendedor(v);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		v = dogaoOnDemandFacade.buscarVendedor(id);
		assertEquals(true, v.getNome().equals("Renan Vendedor Dois"));		
	}
	
	@Test
	public void deveriaListarOsVendedores() {
		List<Vendedor> produtos = dogaoOnDemandFacade.listarVendedores();
		assertEquals(true, produtos != null && produtos.size() > 0);
	}
	
	@Test
	public void deveriaExcluirOVendedor() {
		Vendedor v = new VendedorService().buscar(id);
		new VendedorService().excluir(v);
		
		Vendedor pExcluido = dogaoOnDemandFacade.buscarVendedor(id);
		assertEquals(true, pExcluido == null);
	}
}
