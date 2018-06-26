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

import br.edu.up.sistemaacademico.entity.Produto;
import br.edu.up.sistemaacademico.service.ProdutoService;
import br.edu.up.sistemaacademico.service.ServiceException;
import io.swagger.annotations.Api;

@Path("/produto")
@Api(value = "/produto", description = "Produtos")
public class ProdutoRest {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Produto> listar() {
		List<Produto> produtos = new ProdutoService().listar();
		return produtos;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void salvar(Produto Produto) {
		try {
			new ProdutoService().salvar(Produto);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void editar(Produto Produto) {
		try {
			new ProdutoService().salvar(Produto);
		} catch (ServiceException e) {			
			e.printStackTrace();
		}
	}
	
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void excluir(Produto Produto) {
		new ProdutoService().excluir(Produto);
	}
}
