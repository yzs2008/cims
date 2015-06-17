package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.Round;

@Repository("RoundDao")
public class RoundDao extends BaseDao<Round> {

	public RoundDao(){
		this.clazz=Round.class;
	}
	
	public List<Round> retrieveList() throws Exception{
		return retrieveList(new Round());
	}
	
	public List<Round> retrieveList(Round round)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Round o where 1=1 order by o.createTime desc");
		
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new Round());
	}
	public Integer records(Round round) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from Round o where 1=1");
		
		String hql=sbHql.toString();
		return records(hql);
	}

}
