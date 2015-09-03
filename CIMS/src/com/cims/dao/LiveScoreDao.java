package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.LiveScore;

@Repository("LiveScoreDao")
public class LiveScoreDao extends BaseDao<LiveScore> {

	public LiveScoreDao(){
		this.clazz=LiveScore.class;
	}
	
}
