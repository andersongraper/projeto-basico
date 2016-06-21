package com.graper.dao.jpa;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.graper.dao.CrudDAO;


public abstract class JPAAbstract<E, ID> extends JPAConnection implements CrudDAO<E, ID>{
	
	protected Class<E> entityClass;
	
	@SuppressWarnings("unchecked")
	public JPAAbstract(){
		ParameterizedType superclass = (ParameterizedType) getClass().getGenericSuperclass();
		// retorna o <senai.comjpa.pojo.Cliente> do superclass
		entityClass = (Class<E>) superclass.getActualTypeArguments()[0];
	}
			
	public String getEntityName() {
		return entityClass.getSimpleName();
	}
	
	public void incluir( E o ) {
		EntityManager em = super.getEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		System.out.println("SQL: " + em.getTransaction().toString());
		em.getTransaction().commit();
		em.close();
	}
	
	public void incluir( E o , EntityManager em) {
		em.persist(o);
	}
	
	@Override
	public E buscarPorId(ID id) {
		return getEntityManager().find(entityClass, id);
	}

	@Override
	public E atualizar(E e) {
		EntityManager em = super.getEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
		return e;
	}
	
	@Override
	public E atualizar(E e, EntityManager em) {
		em.merge(e);
		return e;
	}

	@Override
	public void deletar(ID id) {
		EntityManager em = super.getEntityManager();
		em.getTransaction().begin();
		E e = em.find(entityClass, id);
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}
	
	@Override
	public void deletar(ID id, EntityManager em) {		
		E e = em.find(entityClass, id);
		em.remove(e);		
	}

	@Override
	public List<E> buscarTodos() {
		String jpql = "SELECT c FROM " + getEntityName() + " c";
		TypedQuery <E> query = super.getEntityManager().createQuery(jpql, entityClass);
		List<E> lista = query.getResultList();
		return lista;
	}
}
