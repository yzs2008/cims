package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.JudgeDao;
import com.cims.model.persist.Judge;

@Service("JudgeProcess")
public class JudgeProcess {

	private final transient Logger log = Logger.getLogger(UserProcess.class);
	@Autowired
	private JudgeDao judgeDao;

	//增
	public boolean saveJudge(Judge judge) {
		boolean done = true;
		try {
			judgeDao.create(judge);
		} catch (Exception e) {
			done = false;
			log.error(e.getMessage());
		}
		return done;
	}
	//删
	public boolean detete(String id){
		boolean done=false;
		try{
			judgeDao.delete(Integer.valueOf(id));
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}	
	//查
	public Judge retrieve(Integer id){
		try{
			return judgeDao.retrieveById(id);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return null;
	}

	//改
	public boolean update(Judge judge){
		boolean done=false;
		try{
			judgeDao.update(judge);
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}
	//查
	public List<Judge> retrieveList(Judge judge){
		List<Judge> judgeList=new ArrayList<Judge>();
		try {
			judgeList = judgeDao.retrieveList(judge);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return judgeList;
	}
}
