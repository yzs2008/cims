package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Promotion;

@Repository("PromotionDao")
public class PromotionDao extends BaseDao<Promotion> {

	public PromotionDao(){
		this.clazz=Promotion.class;
	}
	
	public List<Promotion> retrieveList() throws Exception{
		return retrieveList(new Promotion());
	}
	
	public List<Promotion> retrieveList(Promotion race)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from Promotion o where 1=1 order by o.promotionId asc");
		
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new Promotion());
	}
	public Integer records(Promotion race) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from Promotion o where 1=1");
		
		String hql=sbHql.toString();
		return records(hql);
	}

}
