package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.AdjustScore;

@Repository("AdjustScoreDao")
public class AdjustScoreDao extends BaseDao<AdjustScore> {

	public AdjustScoreDao(){
		this.clazz=AdjustScore.class;
	}
	
}
