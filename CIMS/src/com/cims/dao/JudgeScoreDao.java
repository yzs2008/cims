package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.JudgeScore;

@Repository("JudgeScoreDao")
public class JudgeScoreDao extends BaseDao<JudgeScore> {

	public JudgeScoreDao(){
		this.clazz=JudgeScore.class;
	}
	
}
