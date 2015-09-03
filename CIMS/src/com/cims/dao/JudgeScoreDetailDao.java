package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.ScoreDetail;

@Repository("JudgeScoreDetailDao")
public class JudgeScoreDetailDao extends BaseDao<ScoreDetail> {

	public JudgeScoreDetailDao(){
		this.clazz=ScoreDetail.class;
	}
	
}
