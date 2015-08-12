package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Standard;

@Repository("StandardDao")
public class StandardDao extends BaseDao<Standard> {

	public StandardDao(){
		this.clazz=Standard.class;
	}
	
	public List<Standard> retrieveList() throws Exception{
		return retrieveList(new Standard());
	}
	
	public List<Standard> retrieveList(Standard filter)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Standard o where 1=1 order by o.raceId asc");
		
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new Standard());
	}
	public Integer records(Standard filter) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from Standard o where 1=1");
		
		String hql=sbHql.toString();
		return records(hql);
	}

}
