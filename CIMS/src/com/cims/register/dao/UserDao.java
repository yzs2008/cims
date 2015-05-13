package com.cims.register.dao;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.register.model.User;

@Repository("UserDao")
public class UserDao extends BaseDao<User>{

	public UserDao(){
		this.clazz=User.class;
	}
}
