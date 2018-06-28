package br.com.rblstudios.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rblstudios.entity.Vendedor;

public class VendedorDao implements Dao<Vendedor> {
	
	public void salvar(Vendedor v) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(v);		
		em.getTransaction().commit();
	}
	
	public void editar(Vendedor v) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(v);		
		em.getTransaction().commit();
	}
	
	public void excluir(Vendedor v) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(v));		
		em.getTransaction().commit();
	}
	
	public List<Vendedor> listar() {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		Query q = em.createQuery("select v from Vendedor v");
		return q.getResultList();		
	}

	@Override
	public Vendedor buscar(Long id) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		return em.find(Vendedor.class, id);
	}
}
