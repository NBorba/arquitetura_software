package br.edu.up.sistemaacademico.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.edu.up.sistemaacademico.entity.Cliente;
import br.edu.up.sistemaacademico.service.ClienteService;
import br.edu.up.sistemaacademico.service.ServiceException;
import io.swagger.annotations.Api;

@Path("/cliente")
@Api(value = "/cliente", description = "Clientes")
public class ClienteRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Cliente> listar() {
		List<Cliente> clientes = new ClienteService().listar();
		return clientes;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(Cliente cliente) {
		try {
			new ClienteService().salvar(cliente);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Cliente cliente) {
		try {
			new ClienteService().salvar(cliente);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/excluir")
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(Cliente cliente) {
		new ClienteService().excluir(cliente);
	}
}
