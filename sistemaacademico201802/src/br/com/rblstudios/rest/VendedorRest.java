package br.com.rblstudios.rest;

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

import br.com.rblstudios.entity.Vendedor;
import br.com.rblstudios.facade.DogaoOnDemandFacade;
import br.com.rblstudios.service.ServiceException;
import br.com.rblstudios.service.VendedorService;
import io.swagger.annotations.Api;

@Path("/vendedor")
@Api(value = "/vendedor", description = "Vendedores")
public class VendedorRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Vendedor> listar() {
		List<Vendedor> vendedor = new DogaoOnDemandFacade().listarVendedores();
		return vendedor;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(Vendedor Vendedor) {
		try {
			new DogaoOnDemandFacade().salvarVendedor(Vendedor);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Vendedor Vendedor) {
		try {
			new DogaoOnDemandFacade().salvarVendedor(Vendedor);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
	}
	
	@POST
	@Path("/excluir")
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(Vendedor Vendedor) {
		new DogaoOnDemandFacade().excluirVendedor(Vendedor);
	}
}
