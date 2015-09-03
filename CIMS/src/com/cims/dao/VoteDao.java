package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Vote;

@Repository("VoteDao")
public class VoteDao extends BaseDao<Vote> {

	public VoteDao(){
		this.clazz=Vote.class;
	}
	
}
