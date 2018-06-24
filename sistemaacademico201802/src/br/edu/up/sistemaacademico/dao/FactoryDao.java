package br.edu.up.sistemaacademico.dao;

import br.edu.up.sistemaacademico.entity.Aluno;
import br.edu.up.sistemaacademico.entity.Cliente;

public class FactoryDao {
	
	public static Dao<Aluno> createAlunoDao() {
		return new AlunoDao();
	}

	public static Dao<Cliente> createClienteDao() {
		return new ClienteDao();
	}
}
