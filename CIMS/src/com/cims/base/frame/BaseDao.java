package com.cims.base.frame;
/**
 * @author kaidi
 * @date 2015年5月13日
 */
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

@SuppressWarnings("unchecked")
public class BaseDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;
	
	protected Class<T> clazz;

	public Session getSession() throws Exception {
		return this.sessionFactory.getCurrentSession();
	}

	/*************CRUD***************************/
	public void create(T t) throws Exception {
		getSession().save(t);
	}

	public T retrieveById(Serializable id) throws Exception {
		return (T)getSession().get(clazz, id);
	}

	public void update(T t) throws Exception {
		getSession().update(t);
	}

	public void delete(T t) throws Exception {
		getSession().delete(t);
	}

	public void delete(Serializable id) throws Exception {
		getSession().delete(retrieveById(id));
	}

	public Integer records(String hql) throws Exception {
		return (Integer) getSession().createQuery(hql).uniqueResult().hashCode();
	}

	public List<T> retrieveList(String hql) throws Exception {
		return retrieveList(hql, new Object[] {});
	}

	public List<T> retrieveList(String hql, Object param) throws Exception {
		return retrieveList(hql, new Object[] { param });
	}

	public List<T> retrieveList(String hql, Object[] params) throws Exception {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		return (List<T>) query.list();
	}

	public T retrieveObject(String hql) throws Exception{
		return retrieveObject(hql, new Object[]{});
	}
	
	public T retrieveObject(String hql, Object param) throws Exception{
		return retrieveObject(hql, new Object[]{param});
	}
	
	public T retrieveObject(String hql, Object[] params) throws Exception {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		return (T) query.uniqueResult();
	}

	public List<T> retrieveByPage(String hql, int offset, int length) throws Exception {
		return retrieveByPage(hql, new Object[] {}, offset, length);
	}

	public List<T> retrieveByPage(String hql, Object param, int offset, int length) throws Exception {
		return retrieveByPage(hql, new Object[] { param }, offset, length);
	}

	public List<T> retrieveByPage(String hql, Object[] params, int offset, int length) throws Exception {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		query.setFirstResult(offset);
		query.setMaxResults(length);
		return (List<T>) query.list();
	}

	private void setQueryParams(Query query, Object[] params) throws Exception {
		if (null == params) {
			return;
		}
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}
}
