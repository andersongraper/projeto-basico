package com.graper.dao;

import java.util.List;

import javax.persistence.EntityManager;

public interface CrudDAO<E, ID> {

	public void incluir(E e);
	public void incluir(E e, EntityManager em);
	public E buscarPorId(ID id);
	public E atualizar(E e);
	public E atualizar(E e, EntityManager em);
	public void deletar(ID id);
	public void deletar(ID id, EntityManager em);
	public List<E> buscarTodos();
	
	public EntityManager getEntityManager();

}
