package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.base.type.StateEnum;
import com.cims.dao.AwardDao;
import com.cims.dao.JudgeDao;
import com.cims.dao.PromotionDao;
import com.cims.dao.RaceDao;
import com.cims.dao.RaceJudgeDao;
import com.cims.dao.RoundDao;
import com.cims.dao.StandardDao;
import com.cims.model.datastruct.JudgeModel;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.Award;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Promotion;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.Round;
import com.cims.model.persist.Standard;

@Service("RaceProcess")
public class RaceProcess {

	private final transient Logger log = Logger.getLogger(RaceProcess.class);
	@Autowired
	private RaceDao raceDao;
	@Autowired
	private RoundDao roundDao;
	@Autowired
	private RaceJudgeDao raceJudgeDao;
	@Autowired
	private PromotionDao promotionDao;
	@Autowired
	private AwardDao awardDao;
	@Autowired
	private StandardDao standardDao;
	@Autowired
	private JudgeDao judgeDao;

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
	public List<Race> retrieveList(Race filter) {
		List<Race> raceList = new ArrayList<Race>();
		try {
			raceList = raceDao.retrieveList(filter);
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

	public List<RaceJudge> retrieveJudgeList(Integer id) {
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

	public boolean configPromotion(List<Promotion> racePromotionList) {
		boolean done = true;
		try {
			// 先删除比赛 晋级信息
			String deleteFist = "delete from Promotion as o where o.raceId=?";
			Integer raceId = racePromotionList.get(0).getRaceId();
			promotionDao.execute(deleteFist, new Object[] { raceId });

			// 重新写入晋级信息
			for(Promotion item:racePromotionList){
				promotionDao.create(item);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
		
	}

	public List<Promotion> retrievePromotionList(Integer id) {
		try{
			List<Promotion> promotionList;
			String query="select o from Promotion as o where o.raceId=?";
			promotionList= promotionDao.retrieveList(query, new Object[]{id});
			return promotionList;
		}catch(Exception e){
			log.error(e.getMessage());
			return new ArrayList<Promotion>();
		}
	}
	
	public List<Award> retrieveAwardList(Integer id) {
		try{
			List<Award> awardList;
			String query="select o from Award as o where o.raceId=?";
			awardList= awardDao.retrieveList(query, new Object[]{id});
			return awardList;
		}catch(Exception e){
			log.error(e.getMessage());
			return new ArrayList<Award>();
		}
	}

	public boolean configAward(List<Award> raceAwardList) {
		boolean done = true;
		try {
			// 先删除比赛奖项信息
			String deleteFist = "delete from Award as o where o.raceId=?";
			Integer raceId = raceAwardList.get(0).getRaceId();
			awardDao.execute(deleteFist, new Object[] { raceId });

			// 重新写入奖项信息
			for(Award item:raceAwardList){
				awardDao.create(item);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	public List<Standard> retrieveStandard(Integer id) {
		try{
			List<Standard> standardList;
			String query="select o from Standard as o where o.raceId=?";
			standardList= standardDao.retrieveList(query, new Object[]{id});
			return standardList;
		}catch(Exception e){
			log.error(e.getMessage());
			return new ArrayList<Standard>();
		}
	}
	public boolean configStandard(List<Standard> raceStandardList) {
		boolean done = true;
		try {
			// 先删除比赛 评分项信息
			String deleteFist = "delete from Standard as o where o.raceId=?";
			Integer raceId = raceStandardList.get(0).getRaceId();
			standardDao.execute(deleteFist, new Object[] { raceId });

			// 重新写入评分项信息
			for(Standard item:raceStandardList){
				standardDao.create(item);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	public List<JudgeModel> retrieveJudgeList(List<RaceJudge> raceJudgeList) {
		try{
			List<JudgeModel> judgeModelList=new ArrayList<JudgeModel>();
			for(RaceJudge  item : raceJudgeList){
				JudgeModel judgeModel=new JudgeModel();
				judgeModel.setJudge(judgeDao.retrieveById(item.getJudgeId()));
				judgeModel.setRaceJudge(item);
				judgeModelList.add(judgeModel);
			}
			return judgeModelList;
		}catch(Exception e){
			log.error(e.getMessage());
			return new ArrayList<JudgeModel>();
		}
	}

	public List<Race> getRaceListByJudge(Judge judge) {
		try{
			List<Race> raceList=new ArrayList<Race>();

			RaceJudge raceJudge=new RaceJudge();
			raceJudge.setJudgeId(judge.getJudgeId());
			List<RaceJudge> raceJudgeList=raceJudgeDao.retrieveList(raceJudge);
			for(RaceJudge rj:raceJudgeList){
				Race item=raceDao.retrieveById(rj.getRaceId());
				if(item.getState()==RaceState.underWay || item.getState()==RaceState.signOver){
					raceList.add(item);
				}
			}
			return raceList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<Race>();
		}
	}
}
