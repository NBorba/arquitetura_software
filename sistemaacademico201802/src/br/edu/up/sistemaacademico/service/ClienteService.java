package br.edu.up.sistemaacademico.service;

import java.util.List;

import br.edu.up.sistemaacademico.dao.Dao;
import br.edu.up.sistemaacademico.dao.FactoryDao;
import br.edu.up.sistemaacademico.entity.Cliente;
import br.edu.up.sistemaacdemico.utils.ValidationUtils;

public class ClienteService {
	
	Dao<Cliente> clienteDao = FactoryDao.createClienteDao();
	
	public void salvar(Cliente cliente) throws ServiceException {
		
		if (cliente == null) {
			throw new ServiceException("O cliente n�o pode ser vazio!");
		}
		
		if (cliente.getNome() == null || cliente.getNome().equals("")) {
			throw new ServiceException("O nome do cliente n�o pode ser vazio!");
		}
		
		if (cliente.getCpf() == null || cliente.getCpf().equals("")
				|| !ValidationUtils.isCPF(cliente.getCpf())) {
			throw new ServiceException("O CPF do cliente n�o pode ser vazio ou invalido!");
		}
		
		if (cliente.getDataNascimento() == null || cliente.getDataNascimento().equals("")
				|| !ValidationUtils.isDate(cliente.getDataNascimento(), "dd/MM/yyyy")) {
			throw new ServiceException("A data de nascimento do cliente deve ser valida! Formato esperado (dd/MM/yyyy)");
		}
		
		if (cliente.getTelefone() == null || cliente.getTelefone().equals("")
				|| !ValidationUtils.isTelefone(cliente.getTelefone())) {
			throw new ServiceException("O telefone do cliente deve ser valido! Formato esperado (XX)99999-9999");
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
