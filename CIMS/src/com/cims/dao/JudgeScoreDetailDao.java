package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.JudgeScoreDetail;

@Repository("JudgeScoreDetailDao")
public class JudgeScoreDetailDao extends BaseDao<JudgeScoreDetail> {

	public JudgeScoreDetailDao(){
		this.clazz=JudgeScoreDetail.class;
	}
	
}
