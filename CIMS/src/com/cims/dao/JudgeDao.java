package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.Judge;

@Repository("JudgeDao")
public class JudgeDao extends BaseDao<Judge> {

	public JudgeDao(){
		this.clazz=Judge.class;
	}
	
	public List<Judge> retrieveList() throws Exception{
		return retrieveList(new Judge());
	}
	
	public List<Judge> retrieveList(Judge judge)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Judge o where 1=1 order by o.registerDate desc");
		
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new Judge());
	}
	public Integer records(Judge judge) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from Judge o where 1=1");
		
		String hql=sbHql.toString();
		return records(hql);
	}

}
