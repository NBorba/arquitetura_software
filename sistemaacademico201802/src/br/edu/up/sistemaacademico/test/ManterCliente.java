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
