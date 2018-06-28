package br.com.rblstudios.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.rblstudios.entity.Produto;

public class ProdutoDao implements Dao<Produto> {
	
	public void salvar(Produto p) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);		
		em.getTransaction().commit();
	}
	
	public void editar(Produto p) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(p);		
		em.getTransaction().commit();
	}
	
	public void excluir(Produto p) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(p));		
		em.getTransaction().commit();
	}
	
	public List<Produto> listar() {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		Query q = em.createQuery("select p from Produto p");
		return q.getResultList();		
	}

	@Override
	public Produto buscar(Long id) {
		EntityManager em = DBConexao.getInstance().createEntityManager();
		return em.find(Produto.class, id);
	}
}
