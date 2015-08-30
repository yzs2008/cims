package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Race;

@Repository("RaceDao")
public class RaceDao extends BaseDao<Race> {

	public RaceDao(){
		this.clazz=Race.class;
	}
	
	public List<Race> retrieveList() throws Exception{
		return retrieveList(new Race());
	}
	
	public List<Race> retrieveList(Race filter)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Race o where 1=1 ");
		
		if(filter.getState()!=null){
			sbHql.append(" and o.state='").append(filter.getState().name()).append("' ");
		}
		if(filter.getRoundId()!=null){
			sbHql.append(" and o.roundId='").append(filter.getRoundId()).append("' ");
		}
		sbHql.append(" order by o.createTime desc");
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new Race());
	}
	public Integer records(Race race) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from Race o where 1=1");
		
		String hql=sbHql.toString();
		return records(hql);
	}

}
