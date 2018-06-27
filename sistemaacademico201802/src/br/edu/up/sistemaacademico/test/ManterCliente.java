package br.edu.up.sistemaacademico.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.sistemaacademico.entity.Cliente;
import br.edu.up.sistemaacademico.entity.Produto;
import br.edu.up.sistemaacademico.facade.DogaoOnDemandFacade;
import br.edu.up.sistemaacademico.service.ClienteService;
import br.edu.up.sistemaacademico.service.ProdutoService;
import br.edu.up.sistemaacademico.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterCliente {
	
	static Long id;
	DogaoOnDemandFacade dogaoOnDemandFacade = new DogaoOnDemandFacade();
	
	@Test
	public void deveriaCadastrarUmCliente() {
		Cliente c = new Cliente();
		c.setId(null);
		c.setNome("Renan");
		c.setCpf("111111111111");
		c.setEndereco("sadasd");
		c.setTelefone("Telefone");
		
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
		Cliente c = new ClienteService().buscar(id);
		c.setNome("Renan dois");
		
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
