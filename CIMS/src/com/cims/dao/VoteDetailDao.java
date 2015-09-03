package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.VoteDetail;

@Repository("VoteDetailDao")
public class VoteDetailDao extends BaseDao<VoteDetail> {

	public VoteDetailDao(){
		this.clazz=VoteDetail.class;
	}
	
}
