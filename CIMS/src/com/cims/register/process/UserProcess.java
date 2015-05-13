package com.cims.register.process;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.register.dao.UserDao;
import com.cims.register.model.User;

@Service("UserProcess")
public class UserProcess {
	
	@Autowired
	private UserDao userDao;

	public boolean saveRegister(User user){
		boolean done=true;
		try {
			userDao.save(user);
		} catch (Exception e) {
			e.printStackTrace();
			done=false;
		}
		return done;
	}
	
	public UserProcess(){
		System.out.println("user process");
	}
}
