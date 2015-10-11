package com.cims.process;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.base.type.ActionContant;
import com.cims.base.type.StateEnum;
import com.cims.dao.AwardDao;
import com.cims.dao.DrawDao;
import com.cims.dao.JudgeDao;
import com.cims.dao.PromotionDao;
import com.cims.dao.RaceDao;
import com.cims.dao.RaceJudgeDao;
import com.cims.dao.RoundDao;
import com.cims.dao.SignUpDao;
import com.cims.dao.StandardDao;
import com.cims.dao.UserDao;
import com.cims.model.datastruct.ApplicationMode;
import com.cims.model.datastruct.ApplicationChairman;
import com.cims.model.datastruct.JudgeModel;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.Award;
import com.cims.model.persist.Draw;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Promotion;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.Round;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.Standard;
import com.cims.model.persist.User;

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
	@Autowired
	private UserDao userDao;
	@Autowired
	private SignUpDao signUpDao;
	@Autowired
	private DrawDao drawDao;

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

	// 查
	public List<Race> retrieveList() {
		List<Race> raceList = new ArrayList<Race>();
		try {
			raceList = raceDao.retrieveList();
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
			for (RaceJudge rj : raceJudgeList) {
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
		try {
			String hql = "select o from RaceJudge as o where  o.raceId=?";
			judgeInfoList = raceJudgeDao.retrieveList(hql, new Object[] { id });
		} catch (Exception e) {
			log.error(e.getMessage());
			judgeInfoList = new ArrayList<RaceJudge>();
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
			for (Promotion item : racePromotionList) {
				promotionDao.create(item);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;

	}

	public List<Promotion> retrievePromotionList(Integer id) {
		try {
			List<Promotion> promotionList;
			String query = "select o from Promotion as o where o.raceId=?";
			promotionList = promotionDao.retrieveList(query, new Object[] { id });
			return promotionList;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<Promotion>();
		}
	}

	public List<Award> retrieveAwardList(Integer id) {
		try {
			List<Award> awardList;
			String query = "select o from Award as o where o.raceId=?";
			awardList = awardDao.retrieveList(query, new Object[] { id });
			return awardList;
		} catch (Exception e) {
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
			for (Award item : raceAwardList) {
				awardDao.create(item);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	public List<Standard> retrieveStandard(Integer id) {
		try {
			List<Standard> standardList;
			String query = "select o from Standard as o where o.raceId=?";
			standardList = standardDao.retrieveList(query, new Object[] { id });
			return standardList;
		} catch (Exception e) {
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
			for (Standard item : raceStandardList) {
				standardDao.create(item);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			done = false;
		}
		return done;
	}

	public List<JudgeModel> retrieveJudgeList(List<RaceJudge> raceJudgeList) {
		try {
			List<JudgeModel> judgeModelList = new ArrayList<JudgeModel>();
			for (RaceJudge item : raceJudgeList) {
				JudgeModel judgeModel = new JudgeModel();
				judgeModel.setJudge(judgeDao.retrieveById(item.getJudgeId()));
				judgeModel.setRaceJudge(item);
				judgeModelList.add(judgeModel);
			}
			return judgeModelList;
		} catch (Exception e) {
			log.error(e.getMessage());
			return new ArrayList<JudgeModel>();
		}
	}

	public List<Race> getRaceListByJudge(Judge judge) {
		try {
			List<Race> raceList = new ArrayList<Race>();

			RaceJudge raceJudge = new RaceJudge();
			raceJudge.setJudgeId(judge.getJudgeId());
			List<RaceJudge> raceJudgeList = raceJudgeDao.retrieveList(raceJudge);
			for (RaceJudge rj : raceJudgeList) {
				Race item = raceDao.retrieveById(rj.getRaceId());
				if (item.getState() == RaceState.underWay) {
					raceList.add(item);
				}
			}
			return raceList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<Race>();
		}
	}

	public List<User> retrievePlayer(Integer id) {
		try {
			String getSignUp = "select o from SignUp as o where o.raceId=?";
			List<SignUp> signUpList = signUpDao.retrieveList(getSignUp, new Object[] { id });
			List<User> userList = new ArrayList<User>();
			for (SignUp sign : signUpList) {
				User tem = userDao.retrieveById(sign.getUserId());
				userList.add(tem);
			}
			return userList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<User>();
		}

	}

	public Boolean updateRaceState(String raceId, String state) {
		Boolean done = false;
		try {
			Race race = retrieve(Integer.valueOf(raceId));
			if (race == null) {
				return false;
			}
			RaceState raceState = RaceState.valueOf(state);
			race.setState(raceState);
			update(race);
			done = true;
		} catch (Exception e) {
			log.error(e);
			done = false;
		}
		return done;
	}

	public void monitorState(Integer raceId, String state, Map<String, Object> application) throws Exception {
		RaceState rs = RaceState.valueOf(state);
		switch (rs) {
		case underWay: {// 将比赛状态加入全局变量中
			ApplicationChairman chairman = (ApplicationChairman) application.get(ActionContant.application_chairman);
			//系统尚未启动，先启动系统
			if (chairman == null) {
				chairman = ApplicationChairman.getInstance();
				synchronized(chairman){
					if(application.get(ActionContant.application_chairman)==null){
						chairman.raceList=getUnderwayRaceList();
						application.put(ActionContant.application_chairman, chairman);
					}
				}
			} else {
				//系统已经启动，更新系统内比赛信息
				chairman.raceList=getUnderwayRaceList();
			}
			break;
		}
		case over:
			// 将比赛状态移除全局变量外
			ApplicationChairman chairman = (ApplicationChairman) application.get(ActionContant.application_chairman);
			Race r=retrieve(raceId);
			chairman.raceList.remove(r);
			break;
		default:
			break;
		}
	}

	private User locationCurPlayer(Race curRace) {
		try {
			User user=null;
			String hql = "select o from Draw as o where o.raceId=? order by o.orderSerial asc";
			List<Draw> drawList = drawDao.retrieveList(hql, curRace.getRaceId());
			if (drawList == null || drawList.size() == 0) {
				startupRaceInsertPlayer(curRace.getRaceId());
			}
			for(Draw d:drawList){
				if(!d.getScored()){
					user=userDao.retrieveById(d.getUserId());
					break;
				}
			}
			return user;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	private void startupRaceInsertPlayer(Integer raceId) throws Exception {
		try {
			String hql="select o from SignUp as o  where o.raceId=?";
			List<SignUp> allUser=signUpDao.retrieveList(hql, raceId);
			List<Draw> drawList=new ArrayList<Draw>();
			int i=0;
			for(SignUp su:allUser){
				Draw draw=new Draw();
				draw.setOrderSerial(i++);
				draw.setRaceId(raceId);
				draw.setUserId(su.getUserId());
				draw.setScored(false);
				drawList.add(draw);
			}
			for(Draw dr:drawList){
				drawDao.create(dr);
			}
		} catch (Exception e) {
			log.error(e);
			throw e;
		}
	}

	public List<Race> getUnderwayRaceList() {
		List<Race> raceIdList;
		try{
			String hql="select o from Race as o where o.state="+"'"+RaceState.underWay.name()+"'";
			raceIdList=raceDao.retrieveList(hql);
		}catch(Exception e){
			log.error(e);
			raceIdList=new ArrayList<Race>();
		}
		return raceIdList;
	}

	public String getDisplayName(Judge judge, Race race) {
		try{
			String hql="select o from RaceJudge  as o where o.raceId=? and o.judgeId=?";
			RaceJudge rj=raceJudgeDao.retrieveObject(hql, new Object[]{race.getRaceId(),judge.getJudgeId()});
			if(rj!=null){
				return rj.getDisplayName();
			}
		}catch(Exception e){
			log.error(e);
		}
		return "";
	}
}
