package com.test.demo;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CopyOfBaseDao<T> {
	@Autowired
	protected SessionFactory sessionFactory;

	public Session getSession() throws Exception {
		return this.sessionFactory.getCurrentSession();
	}

	public <T>  T queryById(Class<T> entityClass, Serializable id) throws Exception {
		return (T)getSession().get(entityClass, id);
	}

	public <T> void save(T t) throws Exception {
		getSession().save(t);
	}

	public <T> void update(T t) throws Exception {
		getSession().update(t);
	}

	public <T> void delete(T t) throws Exception {
		getSession().delete(t);
	}

	public <T> void delete(Class<T> entityClass, Serializable id) throws Exception {
		getSession().delete(queryById(entityClass, id));
	}

	public Integer records(String hql) throws Exception {
		return (Integer) getSession().createQuery(hql).uniqueResult().hashCode();
	}

	public <T> List<T> queryForList(String hql) throws Exception {
		return queryForList(hql, new Object[] {});
	}
	
	public <T> List<T> queryForListAll(Class<T> entityClass) throws Exception {
		String hql="from "+entityClass.getName();
		return queryForList(hql, new Object[] {});
	}

	public <T> List<T> queryForList(String hql, Object param) throws Exception {
		return queryForList(hql, new Object[] { param });

	}

	public <T> List<T> queryForList(String hql, Object[] params) throws Exception {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		return (List<T>) query.list();

	}

	public T queryForObject(String hql, Object[] params) throws Exception {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		return (T) query.uniqueResult();

	}

	public <T> List<T> findByPage(String hql, int firstResult, int maxResult) throws Exception {
		return findByPage(hql, new Object[] {}, firstResult, maxResult);

	}

	public <T> List<T> findByPage(String hql, Object param, int firstResult, int maxResult) throws Exception {
		return findByPage(hql, new Object[] { param }, firstResult, maxResult);

	}

	public <T> List<T> findByPage(String hql, Object[] params, int firstResult, int maxResult) throws Exception {
		Query query = getSession().createQuery(hql);
		setQueryParams(query, params);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);
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

	public <T> Long create(T t) throws Exception {
		return (Long) getSession().save(t);
	}

	public Integer recordsForSQL(String sql) throws Exception {
		return (Integer) getSession().createSQLQuery(sql).uniqueResult().hashCode();
	}

	public Object uniqueResultForSQL(String sql) throws Exception {
		return getSession().createSQLQuery(sql).uniqueResult();
	}

	public <T> List<T> findListByPageForSQL(String sql, int start, int rowCount) throws Exception {
		Query query = getSession().createSQLQuery(sql);
		if ((start != -1) && (rowCount != -1)) {
			query.setFirstResult(start);
			query.setMaxResults(rowCount);
		}
		return (List<T>) query.list();
	}

//	public <T> void saveOrUpdate(T t) throws Exception {
//		getSession().saveOrUpdate(t);
//	}
}
