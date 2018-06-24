package br.edu.up.sistemaacademico.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import br.edu.up.sistemaacademico.entity.Aluno;
import br.edu.up.sistemaacademico.entity.Cliente;
import br.edu.up.sistemaacademico.service.AlunoService;
import br.edu.up.sistemaacademico.service.ClienteService;
import br.edu.up.sistemaacademico.service.ServiceException;

@FixMethodOrder(MethodSorters.JVM)
public class ManterCliente {
	
	static Long id;
	
	@Test
	public void deveriaCadastrarUmCliente() {
		Cliente c = new Cliente();
		c.setId(null);
		c.setNome("Cleverson");
		c.setCpf("12345");
		
		try {
			new ClienteService().salvar(c);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		assertEquals(true, c.getId() != null);
		id = c.getId();
	}
	
	@Test
	public void deveriaAlterarUmAluno() {
		Cliente c = new ClienteService().buscar(id);
		c.setNome("ABC");
		
		try {
			new ClienteService().salvar(c);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
		
		c = new ClienteService().buscar(id);
		assertEquals(true, c.getNome().equals("ABC"));		
	}
	
	@Test
	public void deveriaListarOsAlunos() {
		List<Cliente> clientes = new ClienteService().listar();
		assertEquals(true, clientes != null && clientes.size() > 0);
	}
	
}
