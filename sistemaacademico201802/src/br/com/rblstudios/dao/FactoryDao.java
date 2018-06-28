package br.com.rblstudios.dao;

import br.com.rblstudios.entity.Cliente;
import br.com.rblstudios.entity.Produto;
import br.com.rblstudios.entity.Vendedor;

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
