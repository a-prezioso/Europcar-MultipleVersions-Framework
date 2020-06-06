package model.dao;


import java.io.Serializable;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;





public abstract class AbstractDAO<T> {


	private Session currentSession;

	private Transaction currentTransaction;

	public Session openCurrentSession() {
		currentSession = util.HibernateUtil.getSessionFactory().openSession();
		return currentSession;
	}
	public void perOrUp(T entity) {
		getCurrentSession().saveOrUpdate(entity);
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = util.HibernateUtil.getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	public void closeCurrentSession() {
		currentSession.close();
	}

	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}

	public Session getCurrentSession() {
		return currentSession;
	}

	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}

	public Transaction getCurrentTransaction() { //Re
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}

	public void persist(T entity) {
		getCurrentSession().save(entity);
	}

	public void update(T entity) {
		getCurrentSession().update(entity);
	}

	public T findById(Serializable id) {
		T object = (T) getCurrentSession().get(getPersistentClass(), id);
		return object; 
	}

	public void delete(T entity) {
		getCurrentSession().delete(entity);
	}

	/*@SuppressWarnings("unchecked")
	public List<T> findAll() { //(Metodo List restituisce il risultato )(createCriteria fa una SELECT* da DB)
		List<T> object = (List<T>) getCurrentSession().createCriteria(getPersistentClass()).list();
		return object;
	}*/
	public List<T> findAll() {
	     CriteriaQuery<T> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(getPersistentClass());
	     criteriaQuery.from(getPersistentClass());
	     List<T> contacts = getCurrentSession().createQuery(criteriaQuery).getResultList();
	     return contacts;
	    }	
	public void deleteAll() {
		List<T> entityList = findAll();
		for (T entity : entityList) {
			delete(entity);
		}
	}
	public List<T> findWithCriteria(String property, String val) {
	     CriteriaBuilder builder = getCurrentSession().getCriteriaBuilder();
	     CriteriaQuery<T> criteriaQuery = getCurrentSession().getCriteriaBuilder().createQuery(getPersistentClass());
	     Root<T> object = criteriaQuery.from(getPersistentClass());
	     Predicate[] restriction = new Predicate[]
	       {
	         builder.like(object.get(property), val)
	       };
	     criteriaQuery.where(restriction);
	     List<T> contacts = getCurrentSession().createQuery(criteriaQuery).getResultList();
	     return contacts;
	    }
	public abstract Class<T> getPersistentClass();
}
