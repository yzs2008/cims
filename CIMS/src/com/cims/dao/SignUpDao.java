package com.cims.dao;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.SignUp;

@Repository("SignUpDao")
public class SignUpDao extends BaseDao<SignUp>{

	public SignUpDao(){
		this.clazz=SignUp.class;
	}
}
