package com.example.demo.service;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;



public abstract class AbstractService<T extends AbstractDAO<E>,E> {

	private T dao;

	public AbstractService() {
		dao = createDAO();
	}
	public void persistOrUpdate(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.perOrUp(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void persist(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.persist(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void update(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.update(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public E findById(Serializable id) {
		dao.openCurrentSession();
		E aula = dao.findById(id);
		dao.closeCurrentSession();
		return aula;
	}

	public void delete(Serializable id) {
		dao.openCurrentSessionwithTransaction();
		E aula = dao.findById(id);
		dao.delete(aula);
		dao.closeCurrentSessionwithTransaction();
	}

	public List<E> findAll() {
		dao.openCurrentSession();
		List<E> all = dao.findAll();
		dao.closeCurrentSession();
		return all;
	}

	public void deleteAll() {
		dao.openCurrentSessionwithTransaction();
		dao.deleteAll();
		dao.closeCurrentSessionwithTransaction();
	}	
	public void deleteOj(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.delete(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public void refresh(E entity) {
		dao.openCurrentSessionwithTransaction();
		dao.getCurrentSession().refresh(entity);
		dao.closeCurrentSessionwithTransaction();
	}

	public T getDao() {
		return dao;
	}
	public <TYPE extends Object> List<TYPE>executeParamizedHQLQuery(String hql, Class<TYPE> returntype) {
		getDao().openCurrentSessionwithTransaction();
		List<TYPE> result = getDao().getCurrentSession().createQuery(hql, returntype).getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}
	public List<E> executeHQLQuery(String hqlQuery) {
		getDao().openCurrentSessionwithTransaction();
		List<E> result = getDao().getCurrentSession().createQuery(hqlQuery, dao.getPersistentClass()).getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<E> findByPar(String prop, Object valore) {
		getDao().openCurrentSessionwithTransaction();
		List<E> result= getDao().getCurrentSession().createQuery("SELECT s FROM "+getDao().getPersistentClass().getCanonicalName()+" s WHERE s." + prop + " =\'" + valore + "\'").getResultList();
		getDao().closeCurrentSessionwithTransaction();
		return result;
	}
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<E> findWithCriteria(Criterion... criterions)
	{
		dao.openCurrentSessionwithTransaction();
		Criteria c= dao.getCurrentSession().createCriteria(dao.getPersistentClass());
		for(Criterion criterion : criterions) {	
			c.add(criterion);
		}
		//c.add(Restrictions.eq(Studente.PROPERTY_cognome, "Cannelonga")).add(Restrictions.between(Studente.PROPERTY_id, 30, 31));	
		List<E> result = c.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<E> findWithCriteriaAndOrder(Order order, Criterion...criterions) {
		dao.openCurrentSessionwithTransaction();
		Criteria c= dao.getCurrentSession().createCriteria(dao.getPersistentClass());
		for(Criterion criterion : criterions) {	
			c.add(criterion);
		}
		c.addOrder(Order.asc("id"));
		c.addOrder(Order.asc("nome"));
		List<E> result = c.list();
		dao.closeCurrentSessionwithTransaction();
		return result;
	}
	public List<E> findForProperty(String property, String value) throws Exception
	  {
	   dao.openCurrentSessionwithTransaction();
	   List<E> result = dao.findWithCriteria(property, value);
	   dao.closeCurrentSessionwithTransaction();
	   return result;
	  }
	public abstract T createDAO();

}
