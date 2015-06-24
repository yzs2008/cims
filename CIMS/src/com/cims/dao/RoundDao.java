package com.cims.dao;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
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
		StringBuilder sbHql=new StringBuilder("select o from Round o where 1=1 ");
		if(round.getParent()!=null){
			sbHql.append(" and o.parent=").append(round.getParent());
		}
		if(round.isHasNode()){
			sbHql.append(" and o.hasNode=true");
		}
		sbHql.append(" order by o.createTime desc");
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

	public Round retrieve(Round round) throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Round o where 1=1");
		if(StringUtils.isNotBlank(round.getRoundName())){
			sbHql.append(" and o.roundName='").append(round.getRoundName()).append("'");
		}
		String hql=sbHql.toString();
		return retrieveObject(hql);
	}
}
