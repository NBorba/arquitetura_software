package br.edu.up.sistemaacademico.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.up.sistemaacademico.entity.Produto;

public class ProdutoDao implements Dao<Produto> {
	
	public void salvar(Produto p) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.persist(p);		
		em.getTransaction().commit();
	}
	
	public void editar(Produto p) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.merge(p);		
		em.getTransaction().commit();
	}
	
	public void excluir(Produto p) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(p));		
		em.getTransaction().commit();
	}
	
	public List<Produto> listar() {
		EntityManager em = Conexao.getInstance().createEntityManager();
		Query q = em.createQuery("select p from Produto p");
		return q.getResultList();		
	}

	@Override
	public Produto buscar(Long id) {
		EntityManager em = Conexao.getInstance().createEntityManager();
		return em.find(Produto.class, id);
	}
}
