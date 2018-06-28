package br.com.rblstudios.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.com.rblstudios.entity.Cliente;
import br.com.rblstudios.entity.Produto;
import br.com.rblstudios.facade.DogaoOnDemandFacade;
import br.com.rblstudios.service.ClienteService;
import br.com.rblstudios.service.ProdutoService;
import br.com.rblstudios.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterCliente {
	
	static Long id;
	DogaoOnDemandFacade dogaoOnDemandFacade = new DogaoOnDemandFacade();
	
	@Test
	public void deveriaCadastrarUmCliente() {
		Cliente c = new Cliente();
		c.setId(null);
		c.setNome("Renan");
		c.setCpf("09404823988");
		c.setDataNascimento("09/08/1998");
		c.setEndereco("sadasd");
		c.setTelefone("(41)99999-9999");
		
		try {
			dogaoOnDemandFacade.salvarCliente(c);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		assertEquals(true, c.getId() != null);
		id = c.getId();
	}
	
	@Test
	public void deveriaAlterarUmCliente() {
		Cliente c = dogaoOnDemandFacade.buscarCliente(id);
		c.setNome("Renan dois");
		c.setCpf("09404823988");
		c.setDataNascimento("09/08/1998");
		c.setEndereco("R. Teste");
		c.setTelefone("(41)98999-9999");
		
		try {
			dogaoOnDemandFacade.salvarCliente(c);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		c = dogaoOnDemandFacade.buscarCliente(id);
		assertEquals(true, c.getNome().equals("Renan dois"));		
	}
	
	@Test
	public void deveriaListarOsClientes() {
		List<Cliente> clientes = dogaoOnDemandFacade.listarClientes();
		assertEquals(true, clientes != null && clientes.size() > 0);
	}
	
	@Test
	public void deveriaExcluirOCliente() {
		Cliente c = dogaoOnDemandFacade.buscarCliente(id);
		dogaoOnDemandFacade.excluirCliente(c);
		
		Cliente cExcluido = dogaoOnDemandFacade.buscarCliente(id);
		assertEquals(true, cExcluido == null);
	}
}
