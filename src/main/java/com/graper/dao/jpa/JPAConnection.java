package com.graper.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPAConnection {
	private static EntityManagerFactory conexao;
	
	private EntityManagerFactory conectar() {
		try {
			if ( conexao != null && conexao.isOpen() ) {
				return conexao;
			}
		} catch (Exception e) {}
		
		conexao = Persistence.createEntityManagerFactory("SENAI"); //	deve conter aqui a informação do atributo name da tag <persistenceunit>
		return conexao;
		//EntityManager em = conexao.createEntityManager();
	}
// este método será o nosso createdStatement
	public EntityManager getEntityManager() {
		return conectar().createEntityManager();
	}
// este método será o nosso prepareStatement
	protected Query getQuery(String jpql) {
		return this.getEntityManager().createQuery(jpql);
	}
//// este método será uma junção de prepareStatementGerandoId, e dos nossos inserts
//	protected void incluir( Object o ) {
//		EntityManager em = getEntityManager();
//		em.getTransaction().begin();
//		em.persist(o);
//		em.getTransaction().commit();
//		em.close();
//	}
}