package br.com.rblstudios.facade;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rblstudios.entity.Cliente;
import br.com.rblstudios.entity.Produto;
import br.com.rblstudios.entity.Vendedor;
import br.com.rblstudios.service.ClienteService;
import br.com.rblstudios.service.ProdutoService;
import br.com.rblstudios.service.ServiceException;
import br.com.rblstudios.service.VendedorService;

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
	
	public Produto buscarProduto(Long id) {
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
