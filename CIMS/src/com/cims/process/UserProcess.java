package com.cims.process;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.UserDao;
import com.cims.model.persist.User;

@Service("UserProcess")
public class UserProcess {
	private final transient Logger log = Logger.getLogger(UserProcess.class);
	@Autowired
	private UserDao userDao;

	public boolean saveRegister(User user) {
		boolean done = true;
		try {
			userDao.create(user);
		} catch (Exception e) {
			done = false;
			log.error(e.getMessage());
		}
		return done;
	}

	public User login(String userName, String password) {
		try {
			String hql="select o from User as o where (o.userName=? and o.password=?) or (o.email=? and o.password=?)";
			User user = userDao.retrieveObject(hql, new Object[]{userName,password,userName,password});
			return user;
		} catch (Exception e) {
			log.error(e.getMessage());
			return null;
		}
	}

	public User getUserById(Integer userId) {
		try {
			User user = userDao.retrieveById(userId);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	public Integer getUserRecords() {
		String hql = "select count(o) from User o where 1=1 ";
		Integer records;
		try {
			records = userDao.records(hql);
			return records;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}
	}
}
