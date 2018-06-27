package br.edu.up.sistemaacademico.service;

import java.util.List;

import br.edu.up.sistemaacademico.dao.Dao;
import br.edu.up.sistemaacademico.dao.FactoryDao;
import br.edu.up.sistemaacademico.entity.Produto;

public class ProdutoService {
	
	Dao<Produto> produtoDao = FactoryDao.createProdutoDao();
	
	public void salvar(Produto Produto) throws ServiceException {
		
		if (Produto == null) {
			throw new ServiceException("O produto não pode ser vazio!");
		}
		
		if (Produto.getNome() == null || Produto.getNome().equals("")) {
			throw new ServiceException("O nome do produto não pode ser vazio!");
		}
		
		if (Produto.getValor() < 0) {
			throw new ServiceException("O valor do produto não pode ser negativo!");
		}
		
		if (Produto.getId() == null) {
			produtoDao.salvar(Produto);
		} else {
			produtoDao.editar(Produto);
		}
	}

	public Produto buscar(long id) {
		return produtoDao.buscar(id);
	}

	public List<Produto> listar() {
		return produtoDao.listar();
	}
	
	public void excluir(Produto p) {
		produtoDao.excluir(p);
	}
}
