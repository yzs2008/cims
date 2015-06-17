package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.RaceDao;
import com.cims.model.Race;


@Service("RaceProcess")
public class RaceProcess {

	private final transient Logger log = Logger.getLogger(RaceProcess.class);
	@Autowired
	private RaceDao raceDao;

	//增
	public boolean saveRace(Race race) {
		boolean done = true;
		try {
			raceDao.create(race);
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
			raceDao.delete(Integer.valueOf(id));
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}	
	//查
	public Race retrieve(Integer id){
		try{
			return raceDao.retrieveById(id);
		}catch(Exception e){
			log.error(e.getMessage());
		}
		return null;
	}

	//改
	public boolean update(Race race){
		boolean done=false;
		try{
			raceDao.update(race);
			done=true;
		}catch(Exception e){
			log.error(e.getMessage());
			done=false;
		}
		return done;
	}
	//查
	public List<Race> retrieveList(Race race){
		List<Race> raceList=new ArrayList<Race>();
		try {
			raceList = raceDao.retrieveList(race);
			
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return raceList;
	}
}
