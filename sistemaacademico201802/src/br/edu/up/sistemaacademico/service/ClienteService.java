package br.edu.up.sistemaacademico.service;

import java.util.List;

import br.edu.up.sistemaacademico.dao.Dao;
import br.edu.up.sistemaacademico.dao.FactoryDao;
import br.edu.up.sistemaacademico.entity.Cliente;

public class ClienteService {
	
	Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
	
	public void salvar(Cliente cliente) throws ServiceException {
		
		if (cliente == null) {
			throw new ServiceException("O cliente não pode ser vazio!");
		}
		
		if (cliente.getNome() == null || cliente.getNome().equals("")) {
			throw new ServiceException("O nome do cliente não pode ser vazio!");
		}
		
		if (cliente.getId() == null) {
			clienteDao.salvar(cliente);
		} else {
			clienteDao.editar(cliente);
		}
	}

	public Cliente buscar(long id) {
		return clienteDao.buscar(id);
	}

	public List<Cliente> listar() {
		return clienteDao.listar();
	}
	
	public void excluir(Cliente cliente) {
		clienteDao.excluir(cliente);
	}
}
