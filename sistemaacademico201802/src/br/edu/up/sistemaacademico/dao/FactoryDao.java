package br.edu.up.sistemaacademico.dao;

import br.edu.up.sistemaacademico.entity.Cliente;
import br.edu.up.sistemaacademico.entity.Produto;
import br.edu.up.sistemaacademico.entity.Vendedor;

public class FactoryDao {

	public static Dao<Cliente> createClienteDao() {
		return new ClienteDao();
	}
	
	public static Dao<Produto> createProdutoDao() {
		return new ProdutoDao();
	}
	
	public static Dao<Vendedor> createVendedorDao() {
		return new VendedorDao();
	}
}
