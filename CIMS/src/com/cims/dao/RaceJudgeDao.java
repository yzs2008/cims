package com.cims.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.RaceJudge;

@Repository("RaceJudgeDao")
public class RaceJudgeDao extends BaseDao<RaceJudge> {

	public RaceJudgeDao(){
		this.clazz=RaceJudge.class;
	}
	
	public List<RaceJudge> retrieveList() throws Exception{
		return retrieveList(new RaceJudge());
	}
	
	public List<RaceJudge> retrieveList(RaceJudge raceJudge)throws Exception{
		StringBuilder sbHql=new StringBuilder("select o from RaceJudge o where 1=1 ");
		if(raceJudge.getRaceId()!=null){
			sbHql.append(" and o.raceId=").append(raceJudge.getRaceId());
		}
		if(raceJudge.getJudgeId()!=null){
			sbHql.append(" and o.judgeId=").append(raceJudge.getJudgeId());
		}
		sbHql.append(" order by o.raceJudgeId desc");
		String hql=sbHql.toString();
		return retrieveList(hql);
	}
	
	public Integer records() throws Exception{
		return records(new RaceJudge());
	}
	public Integer records(RaceJudge raceJudge) throws Exception{
		StringBuilder sbHql=new StringBuilder("select count(o) from RaceJudge o where 1=1");
		
		if(raceJudge.getRaceId()!=null){
			sbHql.append(" and o.raceId=").append(raceJudge.getRaceId());
		}
		if(raceJudge.getJudgeId()!=null){
			sbHql.append(" and o.judgeId=").append(raceJudge.getJudgeId());
		}
		String hql=sbHql.toString();
		return records(hql);
	}

}
