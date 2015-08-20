package com.cims.process;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.SignUpDao;
import com.cims.dao.UserDao;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;

@Service("SignProcess")
public class SignProcess {
	private final transient Logger log = Logger.getLogger(SignProcess.class);
	@Autowired
	private UserDao userDao;
	@Autowired
	private SignUpDao signUpDao;

	public boolean saveUserInfo(User user) {
		boolean done = true;
		try {
			userDao.update(user);
		} catch (Exception e) {
			done = false;
			log.error(e);
		}
		return done;
	}

	public User login(String userName, String password) {
		try {
			String hql = "select o from User as o where (o.userName=? and o.password=?) or (o.email=? and o.password=?)";
			User user = userDao.retrieveObject(hql, new Object[] { userName, password, userName, password });
			return user;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public User getUserById(Integer userId) {
		try {
			User user = userDao.retrieveById(userId);
			return user;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public boolean saveProductInfo(SignUp sign) {
		boolean done = false;
		try {
			// 先查是否存在该记录
			String query = "select o from SignUp as o where o.raceId=? and o.userId=?";
			SignUp signup = signUpDao.retrieveObject(query, new Object[] { sign.getRaceId(), sign.getUserId() });
			// 有则更新，无则插入
			if(signup!=null){
				signup.setProductDescription(sign.getProductDescription());
				signup.setProductName(sign.getProductName());
				signUpDao.update(signup);
			}else{
				signUpDao.create(sign);
			}
			return !done; 
		} catch (Exception e) {
			log.error(e);
			return done;
		}
	}

	public SignUp getProductInfo(Integer userId, Integer raceId) {
		try {
			String hql = "select o from SignUp as o where o.userId=? and o.raceId=?";
			SignUp sign = signUpDao.retrieveObject(hql, new Object[] { userId, raceId });
			return sign;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}
}
