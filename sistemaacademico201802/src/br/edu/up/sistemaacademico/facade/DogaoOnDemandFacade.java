package br.edu.up.sistemaacademico.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemaacademico.entity.Cliente;
import br.edu.up.sistemaacademico.entity.Produto;
import br.edu.up.sistemaacademico.entity.Vendedor;
import br.edu.up.sistemaacademico.service.ClienteService;
import br.edu.up.sistemaacademico.service.ProdutoService;
import br.edu.up.sistemaacademico.service.ServiceException;
import br.edu.up.sistemaacademico.service.VendedorService;

public class DogaoOnDemandFacade {
	
	public List<Cliente> listarClientes() {
		 return new ClienteService().listar();
	}
	
	public Cliente buscarCliente(Long id) {
		 return new ClienteService().buscar(id);
	}
	
	public void salvarCliente(Cliente c) throws ServiceException {	
		new ClienteService().salvar(c);
	}
	
	public void excluirCliente(Cliente c) {
		new ClienteService().excluir(c);
	}
	
	public List<Vendedor> listarVendedores() {
		 return new VendedorService().listar();
	}
	
	public Vendedor buscarVendedor(Long id) {
		 return new VendedorService().buscar(id);
	}
	
	public void salvarVendedor(Vendedor v) throws ServiceException {
		new VendedorService().salvar(v);
	}
	
	public void excluirVendedor(Vendedor v) {
		new VendedorService().excluir(v);
	}
	
	public List<Produto> listarProdutos() {
		 return new ProdutoService().listar();
	}
	
	public Produto buscarProduto(int id) {
		 return new ProdutoService().buscar(id);
	}
	
	
	public void salvarProduto(Produto p) throws ServiceException {
		new ProdutoService().salvar(p);
	}
	
	public void excluirProduto(Produto p) {
		new ProdutoService().excluir(p);
	}

	public Produto buscar(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}
