package br.com.rblstudios.dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBConexao {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.
			createEntityManagerFactory("dogaoondemand");	
		
	public static EntityManagerFactory getInstance() {
		return entityManagerFactory;
	}
}
