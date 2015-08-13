package com.cims.dao;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.model.persist.User;

@Repository("UserDao")
public class UserDao extends BaseDao<User>{

	public UserDao(){
		this.clazz=User.class;
	}
}
