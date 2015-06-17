package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.RoundDao;
import com.cims.model.Round;


@Service("RoundProcess")
public class RoundProcess {

	private final transient Logger log = Logger.getLogger(RoundProcess.class);
	@Autowired
	private RoundDao roundDao;

	//增
	public boolean saveRound(Round round) {
		boolean done = true;
		try {
			roundDao.create(round);
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
			roundDao.delete(Integer.valueOf(id));
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}	
	//查
	public Round retrieve(Integer id){
		try{
			return roundDao.retrieveById(id);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return null;
	}

	//改
	public boolean update(Round round){
		boolean done=false;
		try{
			roundDao.update(round);
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}
	//查
	public List<Round> retrieveList(Round round){
		List<Round> roundList=new ArrayList<Round>();
		try {
			roundList = roundDao.retrieveList(round);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return roundList;
	}
}
