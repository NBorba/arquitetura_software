package br.edu.up.sistemaacademico.service;

import java.util.List;

import br.edu.up.sistemaacademico.dao.Dao;
import br.edu.up.sistemaacademico.dao.FactoryDao;
import br.edu.up.sistemaacademico.entity.Vendedor;
import br.edu.up.sistemaacdemico.utils.ValidationUtils;

public class VendedorService {
	
	Dao<Vendedor> vendedorDao = FactoryDao.createVendedorDao();
	
	public void salvar(Vendedor vendedor) throws ServiceException {
		
		if (vendedor == null) {
			throw new ServiceException("O vendedor não pode ser vazio!");
		}
		
		if (vendedor.getNome() == null || vendedor.getNome().equals("")) {
			throw new ServiceException("O nome do vendedor não pode ser vazio!");
		}
		
		if (vendedor.getCpf() == null || vendedor.getCpf().equals("")
				|| !ValidationUtils.isCPF(vendedor.getCpf())) {
			throw new ServiceException("O CPF do vendedor não pode ser vazio ou invalido!");
		}
		
		if (vendedor.getMatricula() == null || vendedor.getMatricula().equals("")) {
			throw new ServiceException("A matricula do vendedor não pode ser vazio!");
		}
		
		if (vendedor.getUsuario() == null || vendedor.getUsuario().equals("")) {
			throw new ServiceException("O usuario do vendedor não pode ser vazio!");
		}
		
		if (vendedor.getSenha() == null || vendedor.getSenha().equals("")) {
			throw new ServiceException("A senha do vendedor não pode ser vazia!");
		}
		
		if (vendedor.getId() == null) {
			vendedorDao.salvar(vendedor);
		} else {
			vendedorDao.editar(vendedor);
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
