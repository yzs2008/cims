package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Award;

@Repository("AwardDao")
public class AwardDao extends BaseDao<Award> {

	public AwardDao(){
		this.clazz=Award.class;
	}
	
	public List<Award> retrieveList() throws Exception{
		return retrieveList(new Award());
	}
	
	public List<Award> retrieveList(Award filter)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Award o where 1=1 order by o.raceId asc");
		
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new Award());
	}
	public Integer records(Award filter) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from Award o where 1=1");
		
		String hql=sbHql.toString();
		return records(hql);
	}

}
