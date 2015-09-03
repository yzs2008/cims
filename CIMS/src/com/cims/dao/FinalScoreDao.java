package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.FinalScore;

@Repository("FinalScoreDao")
public class FinalScoreDao extends BaseDao<FinalScore> {

	public FinalScoreDao(){
		this.clazz=FinalScore.class;
	}
	
}
