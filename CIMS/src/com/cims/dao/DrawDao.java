package com.cims.dao;


import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.Draw;

@Repository("DrawDao")
public class DrawDao extends BaseDao<Draw> {

	public DrawDao(){
		this.clazz=Draw.class;
	}
	
}
