package com.cims.register.process;

import java.util.ArrayList;
import java.util.List;

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
			userDao.create(user);
		} catch (Exception e) {
			e.printStackTrace();
			done=false;
		}
		return done;
	}
	
	public User getUserById(Integer userId){
		try {
			User user=userDao.retrieveById(userId);
			return user;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public Integer getUserRecords(){
		 String hql="select count(o) from User o where 1=1 ";
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
	
	public void getByPage(){
		List<User> userList=new ArrayList<User>();
		String hql="select o from User o";
		try {
			userList=userDao.retrieveByPage(hql,5, 10);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
