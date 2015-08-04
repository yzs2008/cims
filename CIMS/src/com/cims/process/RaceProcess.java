package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.base.type.StateEnum;
import com.cims.dao.RaceDao;
import com.cims.dao.RaceJudgeDao;
import com.cims.dao.RoundDao;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.Round;

@Service("RaceProcess")
public class RaceProcess {

	private final transient Logger log = Logger.getLogger(RaceProcess.class);
	@Autowired
	private RaceDao raceDao;
	@Autowired
	private RoundDao roundDao;
	@Autowired
	private RaceJudgeDao raceJudgeDao;

	// 增
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

	// 删
	public boolean detete(String id) {
		boolean done = false;
		try {
			raceDao.delete(Integer.valueOf(id));
			done = true;
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	// 查
	public Race retrieve(Integer id) {
		try {
			return raceDao.retrieveById(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return null;
	}

	// 改
	public boolean update(Race race) {
		boolean done = false;
		try {
			raceDao.update(race);
			done = true;
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	// 查
	public List<Race> retrieveList(Race race) {
		List<Race> raceList = new ArrayList<Race>();
		try {
			raceList = raceDao.retrieveList(race);

		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return raceList;
	}

	public List<Round> retrieveRoundList() {
		List<Round> roundList = new ArrayList<Round>();
		try {
			Round filter = new Round();
			filter.setHasNode(false);
			roundList = roundDao.retrieveList(filter);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return roundList;
	}

	public boolean raceNameCheck(String raceName) {
		boolean accept = true;
		try {
			String hql = String.format("select count(o) from Race as o where o.raceName='%s'", raceName);
			if (raceDao.records(hql) != 0) {
				accept = false;
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			accept = false;
		}
		return accept;
	}

	public boolean configJudge(List<RaceJudge> raceJudgeList) {
		boolean done = true;
		try {
			// 先删除比赛评委信息
			String deleteFist = "delete from RaceJudge as o where o.raceId=?";
			Integer raceId = raceJudgeList.get(0).getRaceId();
			raceJudgeDao.execute(deleteFist, new Object[] { raceId });

			// 重新写入评委信息
			for(RaceJudge rj:raceJudgeList){
				rj.setStatus(StateEnum.enable);
				raceJudgeDao.create(rj);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	public List<RaceJudge> getJudgeInfo(Integer id) {
		List<RaceJudge> judgeInfoList;
		try{
			String hql="select o from RaceJudge as o where  o.raceId=?";
			judgeInfoList=raceJudgeDao.retrieveList(hql, new Object[]{id});
		}catch(Exception e){
			log.error(e.getMessage());
			judgeInfoList=new ArrayList<RaceJudge>();
		}
		return judgeInfoList;
	}
}
