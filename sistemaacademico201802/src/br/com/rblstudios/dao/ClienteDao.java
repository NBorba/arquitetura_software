package br.com.rblstudios.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rblstudios.entity.Cliente;

public class ClienteDao implements Dao<Cliente> {
	
	public void salvar(Cliente c) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(c);		
		em.getTransaction().commit();
	}
	
	public void editar(Cliente c) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(c);		
		em.getTransaction().commit();
	}
	
	public void excluir(Cliente c) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(c));		
		em.getTransaction().commit();
	}
	
	public List<Cliente> listar() {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		Query q = em.createQuery("select c from Cliente c");
		return q.getResultList();		
	}

	@Override
	public Cliente buscar(Long id) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		return em.find(Cliente.class, id);
	}
}
