package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Score;

@Repository("JudgeScoreDao")
public class JudgeScoreDao extends BaseDao<Score> {

	public JudgeScoreDao(){
		this.clazz=Score.class;
	}
	
}
