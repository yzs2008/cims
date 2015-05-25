package com.cims.register.dao;

import org.springframework.stereotype.Repository;

import com.cims.base.frame.BaseDao;
import com.cims.register.model.User;

@Repository("UserDao")
public class UserDao extends BaseDao<User>{

	public UserDao(){
		this.clazz=User.class;
	}
	public User login(String userName,String password){
		StringBuilder sb=new StringBuilder("select o from User o where ");
		sb.append(" (o.userName=").append("'").append(userName).append("'");
		sb.append(" and o.password=").append("'").append(password).append("')");
		sb.append(" or ");
		sb.append(" (o.email=").append("'").append(userName).append("'");
		sb.append(" and o.password=").append("'").append(password).append("')");
		try {
			User user = this.retrieveObject(sb.toString());
			return user;
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}
}
