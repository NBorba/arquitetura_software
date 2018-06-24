package br.edu.up.sistemaacademico.service;

import java.util.List;

import br.edu.up.sistemaacademico.dao.Dao;
import br.edu.up.sistemaacademico.dao.FactoryDao;
import br.edu.up.sistemaacademico.entity.Vendedor;

public class VendedorService {
	
	Dao<Vendedor> vendedorDao = FactoryDao.createVendedorDao();
	
	public void salvar(Vendedor Vendedor) throws ServiceException {
		
		if (Vendedor == null) {
			throw new ServiceException("O Vendedor não pode ser vazio!");
		}
		
		if (Vendedor.getNome() == null || Vendedor.getNome().equals("")) {
			throw new ServiceException("O nome do Vendedor não pode ser vazio!");
		}
		
		if (Vendedor.getId() == null) {
			vendedorDao.salvar(Vendedor);
		} else {
			vendedorDao.editar(Vendedor);
		}
	}

	public Vendedor buscar(long id) {
		return vendedorDao.buscar(id);
	}

	public List<Vendedor> listar() {
		return vendedorDao.listar();
	}
	
	public void excluir(Vendedor Vendedor) {
		vendedorDao.excluir(Vendedor);
	}
}
