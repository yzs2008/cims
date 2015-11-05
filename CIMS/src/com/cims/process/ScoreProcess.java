package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.computer.AverageComputer;
import com.cims.computer.ComputeCenter;
import com.cims.computer.ComputeData;
import com.cims.computer.DefaultComputer;
import com.cims.computer.MaxMinExcludeAverageComputer;
import com.cims.computer.MaxMinExcludeSumComputer;
import com.cims.computer.SumComputer;
import com.cims.dao.AdjustScoreDao;
import com.cims.dao.DrawDao;
import com.cims.dao.FinalScoreDao;
import com.cims.dao.JudgeDao;
import com.cims.dao.JudgeScoreDao;
import com.cims.dao.JudgeScoreDetailDao;
import com.cims.dao.LiveScoreDao;
import com.cims.dao.PromotionDao;
import com.cims.dao.RaceDao;
import com.cims.dao.RaceJudgeDao;
import com.cims.dao.SignUpDao;
import com.cims.dao.UserDao;
import com.cims.dao.VoteDao;
import com.cims.dao.VoteDetailDao;
import com.cims.model.datastruct.JudgeScoreModel;
import com.cims.model.datastruct.PlayerScoreModel;
import com.cims.model.datastruct.PlayerState;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.AdjustScore;
import com.cims.model.persist.Draw;
import com.cims.model.persist.FinalScore;
import com.cims.model.persist.Judge;
import com.cims.model.persist.JudgeScore;
import com.cims.model.persist.JudgeScoreDetail;
import com.cims.model.persist.LiveScore;
import com.cims.model.persist.Promotion;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;

@Service("ScoreProcess")
public class ScoreProcess {
	private final transient Logger log = Logger.getLogger(ScoreProcess.class);

	@Autowired
	private FinalScoreDao finalScoreDao;
	@Autowired
	private LiveScoreDao liveScoreDao;
	@Autowired
	private JudgeScoreDao judgeScoreDao;
	@Autowired
	private JudgeScoreDetailDao judgeScoreDetailDao;
	@Autowired
	private AdjustScoreDao adjustScoreDao;
	@Autowired
	private VoteDao voteDao;
	@Autowired
	private VoteDetailDao voteDetailDao;
	@Autowired
	private SignUpDao signUpDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private RaceJudgeDao raceJudgeDao;
	@Autowired
	private JudgeDao judgeDao;
	@Autowired
	private DrawDao drawDao;
	@Autowired
	private RaceDao raceDao;
	@Autowired
	private PromotionDao promotionDao;

	/*
	 * 获取所有评委对某一选手的评分集合
	 */
	public List<JudgeScoreModel> getJudgeScoreModel(Integer raceId, Integer playerId) {
		try {
			List<JudgeScoreModel> judgeScoreModelList = new ArrayList<JudgeScoreModel>();
			List<JudgeScoreModel> judgeList = getAllJudgeByRace(raceId);
			List<JudgeScore> judgeScoreList = getJudgeScoreByPlayer(raceId, playerId);
			for (JudgeScoreModel j : judgeList) {
				j.setScore(getJudgeScoreByJudge(judgeScoreList, j.getJudge()));
				judgeScoreModelList.add(j);
			}
			return judgeScoreModelList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<JudgeScoreModel>();
		}
	}

	/*
	 * 获取某一评委对所有选手的评分集合
	 */
	public List<PlayerScoreModel> getJudgeTraceScoreModel(Integer raceId, Integer judgeId) {
		try {
			List<PlayerScoreModel> judgeScoreTraceModelList = new ArrayList<PlayerScoreModel>();
			List<JudgeScore> judgeScoreList = getJudgeScoreByJudge(raceId, judgeId);
			List<User> userList = getAllPlayerByRace(raceId);
			for (User u : userList) {
				PlayerScoreModel item = new PlayerScoreModel();
				item.setUser(u);
				item.setScore(getJudgeScoreByUser(judgeScoreList, u));
				judgeScoreTraceModelList.add(item);
			}

			return judgeScoreTraceModelList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<PlayerScoreModel>();
		}
	}

	/*
	 * 获取所有选手的最终评分集合
	 */
	public List<PlayerScoreModel> getFinalScoreModel(Integer raceId) {
		try {
			List<PlayerScoreModel> finalScoreModelList = new ArrayList<PlayerScoreModel>();
			List<FinalScore> finalScoreList = getFinalScore(raceId);
			List<User> userList = getAllPlayerByRace(raceId);
			for (User u : userList) {
				PlayerScoreModel model = new PlayerScoreModel();
				model.setUser(u);
				model.setScore(getFinalScoreByUser(finalScoreList, u));
				finalScoreModelList.add(model);
			}

			return finalScoreModelList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<PlayerScoreModel>();
		}
	}

	private Double getJudgeScoreByJudge(List<JudgeScore> judgeScore, Judge judge) {
		Double score = 0D;
		for (JudgeScore js : judgeScore) {
			if (js.getJudge().getJudgeId() == judge.getJudgeId()) {
				score = js.getScore();
				break;
			}
		}
		return score;
	}

	private Double getJudgeScoreByUser(List<JudgeScore> judgeScore, User user) {
		Double score = 0D;
		for (JudgeScore js : judgeScore) {
			if (js.getPlayerId() == user.getUserId()) {
				score = js.getScore();
				break;
			}
		}
		return score;
	}

	/**
	 * 找到某场比赛某一个评委的所有评分
	 * 
	 * @param raceId
	 * @param judgeId
	 * @return
	 */
	public List<JudgeScore> getJudgeScoreByJudge(Integer raceId, Integer judgeId) {
		try {
			String hql = "select o from JudgeScore as o where o.raceId=? and o.judge.judgeId=?";
			List<JudgeScore> scoreList = judgeScoreDao.retrieveList(hql, new Object[] { raceId, judgeId });
			return scoreList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<JudgeScore>();
		}
	}

	/**
	 * 找到某场比赛某一个选手的所有评分
	 * 
	 * @param raceId
	 * @param playerId
	 * @return
	 */
	public List<JudgeScore> getJudgeScoreByPlayer(Integer raceId, Integer playerId) {
		try {
			String hql = "select o from JudgeScore as o where o.raceId=? and o.playerId=?";
			List<JudgeScore> scoreList = judgeScoreDao.retrieveList(hql, new Object[] { raceId, playerId });
			return scoreList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<JudgeScore>();
		}
	}

	private Double getFinalScoreByUser(List<FinalScore> finalScore, User user) {
		Double score = 0D;
		for (FinalScore fs : finalScore) {
			if (fs.getPlayer().getUserId() == user.getUserId()) {
				score = fs.getFinalScore();
				break;
			}
		}
		return score;
	}

	public List<FinalScore> getFinalScore(Integer raceId) {
		try {
			String hql = "select o from FinalScore as o where o.raceId=?";
			List<FinalScore> finalScoreList = finalScoreDao.retrieveList(hql, raceId);
			return finalScoreList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<FinalScore>();
		}
	}

	public List<User> getAllPlayerByRace(Integer raceId) {
		try {
			List<User> playerList = new ArrayList<User>();
			String hql = "select o from SignUp as o where o.raceId=?";
			List<SignUp> signupList = signUpDao.retrieveList(hql, raceId);
			for (SignUp su : signupList) {
				User tem = userDao.retrieveById(su.getUserId());
				playerList.add(tem);
			}
			return playerList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<User>();
		}
	}

	public List<JudgeScoreModel> getAllJudgeByRace(Integer raceId) {
		try {
			List<JudgeScoreModel> judgeList = new ArrayList<JudgeScoreModel>();
			String hql = "select o from RaceJudge as o where o.raceId=?";
			List<RaceJudge> raceJudgeList = raceJudgeDao.retrieveList(hql, raceId);
			for (RaceJudge rj : raceJudgeList) {
				Judge tem = judgeDao.retrieveById(rj.getJudgeId());
				JudgeScoreModel model = new JudgeScoreModel();
				model.setJudge(tem);
				model.setRaceJudge(rj);
				judgeList.add(model);
			}
			return judgeList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<JudgeScoreModel>();
		}
	}

	public SignUp getSignUpByUser(User user, Race race) {
		try {
			String hql = "select o from SignUp as o where o.userId=? and raceId=?";
			SignUp sign = signUpDao.retrieveObject(hql, new Object[] { user.getUserId(), race.getRaceId() });
			return sign;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public boolean saveScore(JudgeScore score, List<JudgeScoreDetail> detailList) {
		boolean done = false;
		try {

			judgeScoreDao.create(score);
			for (JudgeScoreDetail js : detailList) {
				js.setScoreId(score.getScoreId());
				judgeScoreDetailDao.create(js);
			}

			done = true;
			return done;
		} catch (Exception e) {
			log.error(e);
			done = false;
		}
		return done;
	}

	/**
	 * 根据当前登录评委，评委打分的比赛，选择当前应该被评判的选手
	 * 
	 * @param race
	 * @return
	 */
	public User getCurPlayer(Race race) {
		try {
			User user = null;
			// 先查找参加该比赛的所有有效选手
			String hql = "select o from Draw  as o where o.raceId=? and o.state=? and o.scored=? order by o.orderSerial asc";
			List<Draw> drawList = drawDao.retrieveList(hql, new Object[] { race.getRaceId(), PlayerState.normal, false });
			// 遍历选手，查看个选手成绩状况
			for (Draw d : drawList) {
				user = userDao.retrieveById(d.getUserId());
				break;
			}
			return user;
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	public boolean isScored(Judge judge, Race race, User user) {
		try {
			String hql = "select o from JudgeScore as o where o.judge=? and o.playerId=? and o.raceId=?";
			JudgeScore js = judgeScoreDao.retrieveObject(hql, new Object[] { judge, user.getUserId(), race.getRaceId() });
			if (js == null) {
				return false;
			}
			return true;
		} catch (Exception e) {
			log.error(e);
			return true;
		}
	}

	public void checkScoreState(JudgeScore judgeScore) {
		try {
			// 评委人数
			String hql = "select count(o) from RaceJudge as o where o.raceId=%s";
			hql = String.format(hql, judgeScore.getRaceId());
			Integer judgeCount = raceJudgeDao.records(hql);
			// 当前评分记录数
			hql = "select count(o) from JudgeScore as o where o.raceId=%s and o.playerId=%s";
			hql = String.format(hql, judgeScore.getRaceId(), judgeScore.getPlayerId());
			Integer scoreCount = judgeScoreDao.records(hql);

			if (judgeCount == scoreCount) {
				// 标记当前选手的评分过程为完成
				hql = "select o from Draw as o where o.raceId=? and o.userId=?";
				Draw draw = drawDao.retrieveObject(hql, new Object[] { judgeScore.getRaceId(), judgeScore.getPlayerId() });
				draw.setScored(true);
				drawDao.update(draw);
				// 计算LiveScore(现场得分)
				/**
				 * 要面向接口编程，这里引入一个接口，能够计算评委现场得分。另外这里用到依赖注入，以适应后期的变化
				 */
				ComputeCenter cc;
				Race r = raceDao.retrieveById(judgeScore.getRaceId());
				switch (r.getJudgePattern()) {
				case sum:
					cc = new SumComputer();
					break;
				case average:
					cc = new AverageComputer();
					break;
				case max_min_exclude_average:
					cc = new MaxMinExcludeAverageComputer();
					break;
				case max_min_exclude_sum:
					cc=new MaxMinExcludeSumComputer();
					break;
				default:
					cc = new DefaultComputer();
					break;
				}
				Double liveScore = 0.0;
				// 获取该选手的所有评委评分
				liveScore = cc.compute(getJudgeScore(judgeScore.getRaceId(), judgeScore.getPlayerId()));
				// 更新选手现场得分表
				updateLiveScore(judgeScore.getRaceId(), judgeScore.getPlayerId(), liveScore);
				// 计算总分
				updateFinalScore(judgeScore.getRaceId(), judgeScore.getPlayerId());
				// 晋级检查
				monitorRaceProgress(judgeScore.getRaceId());
			}

		} catch (Exception e) {
			log.error(e);
		}
	}

	/**
	 * 判断比赛是否结束，结束后，产生晋级
	 * @param raceId
	 */
	public void monitorRaceProgress(Integer raceId) {
		try{
			String hql="select count(o) from Draw as o where o.raceId=? and o.state=? and o.scored=?";
			Integer rst=drawDao.records(hql,new Object[]{raceId,PlayerState.normal,false});
			//比赛结束
			if(rst==0){
//				//更新赛事状态为结束      (此处不能更新，否则无法显示排名了，赛事状态更新使用手动方式)
//				Race r=raceDao.retrieveById(raceId);
//				r.setState(RaceState.over);
//				raceDao.update(r);

				/******************************产生晋级***********************************/
				//获取晋级规则
				String hql4PromotionRuler="select o from Promotion as o where o.raceId=? order by o.start asc";
				List<Promotion> promotionList=promotionDao.retrieveList(hql4PromotionRuler, raceId);
				String hql4FinalScore="select o from FinalScore as o where o.raceId=? order by o.finalScore desc";
				List<FinalScore> finalScoreList=finalScoreDao.retrieveList(hql4FinalScore, raceId);
				Integer startPointer=0;
				Integer count=finalScoreList.size();
				for(Promotion p:promotionList){
					int start=p.getStart()-1;
					start=start>startPointer?start:startPointer;
					int end=p.getEnd();
					end=end>count?count:end;

					//写入晋级报名
					for(int i=start;i<end;i++){
						FinalScore fs=finalScoreList.get(i);
						String hql4Production="select o from SignUp as o where o.raceId=? and o.userId=?";
						SignUp old=signUpDao.retrieveObject(hql4Production, new Object[]{fs.getRaceId(),fs.getPlayer().getUserId()});
						SignUp sign=new SignUp();
						sign.setRaceId(p.getNextId());
						sign.setUserId(fs.getPlayer().getUserId());
						sign.setProductDescription(old.getProductDescription());
						sign.setProductName(old.getProductName());
						signUpDao.create(sign);
						
						startPointer++;
					}
					//并列选手同时晋级
					if(startPointer>0  &&  startPointer<count){
						Boolean tieFlag = false;
						do {
							FinalScore lastOne = finalScoreList.get(startPointer - 1);
							FinalScore tie = finalScoreList.get(startPointer);
							if (lastOne.getFinalScore().equals(tie.getFinalScore())) {
								String hql4Production = "select o from SignUp as o where o.raceId=? and o.userId=?";
								SignUp old = signUpDao.retrieveObject(hql4Production, new Object[] { tie.getRaceId(), tie.getPlayer().getUserId() });
								SignUp sign = new SignUp();
								sign.setRaceId(p.getNextId());
								sign.setUserId(tie.getPlayer().getUserId());
								sign.setProductDescription(old.getProductDescription());
								sign.setProductName(old.getProductName());
								signUpDao.create(sign);

								startPointer++;
								if(startPointer<count){
									tieFlag=true;
								}else{
									tieFlag=false;
								}
							}else{
								tieFlag=false;
							}
						} while (tieFlag);
					}//并列晋级结束
				}//一次晋级结束
				/**************************设置晋级结束**************************/
			}

		}catch(Exception e){
			log.error(e);
		}
	}

	/**
	 * 更新选手总成绩 
	 * FinalScore=liveScore+adjustScore
	 * liveScore=computer(judgeScoreA+judgeScoreB+judgeScoreB+judgeScoreB……)
	 * adjustScore=computer(vote) or blackbox operation;
	 * 
	 * @param raceId
	 * @param playerId
	 */
	public void updateFinalScore(Integer raceId, Integer playerId) {
		try {
			Double liveScore=0.0;
			Double adjustScore=0.0;
			
			String hql4LiveScore="select o from LiveScore as o where o.raceId=? and o.playerId=?";
			LiveScore ls=liveScoreDao.retrieveObject(hql4LiveScore, new Object[]{raceId,playerId});
			liveScore=ls.getLiveScore();
			String hql4AdjustScore="select o from AdjustScore as o where o.raceId=? and o.playerId=?";
			AdjustScore adjs=adjustScoreDao.retrieveObject(hql4AdjustScore, new Object[]{raceId,playerId});
			adjustScore=adjs.getAdjustment();

			Double finalScore=liveScore+adjustScore;
			String hql4finalScore="select  o from FinalScore as o where o.raceId=? and o.player.userId=?";
			FinalScore fs=finalScoreDao.retrieveObject(hql4finalScore, new Object[]{raceId,playerId});
			fs.setFinalScore(finalScore);
			finalScoreDao.update(fs);
			
		} catch (Exception e) {
			log.error(e);
		}

	}

	/**
	 * 更新某一选手的现场得分成绩
	 * 
	 * @param raceId
	 * @param playerId
	 * @param liveScore
	 */
	public void updateLiveScore(Integer raceId, Integer playerId, Double liveScore) {
		try {
			String hql = "select o from LiveScore as o where o.raceId=? and o.playerId=?";
			LiveScore ls = liveScoreDao.retrieveObject(hql, new Object[] { raceId, playerId });
			ls.setLiveScore(liveScore);
			liveScoreDao.update(ls);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public boolean isJudgeScored(JudgeScore score) {
		try {
			String hql = "select o from JudgeScore as o where o.judge=? and o.raceId=? and o.playerId=?";
			JudgeScore old = judgeScoreDao.retrieveObject(hql, new Object[] { score.getJudge(), score.getRaceId(), score.getPlayerId() });
			if (old != null) {
				return true;
			}
			return false;
		} catch (Exception e) {
			log.error(e);
			return false;
		}
	}

	public User getUserById(Integer userId) {
		try {
			return userDao.retrieveById(userId);
		} catch (Exception e) {
			log.error(e);
			return null;
		}
	}

	/**
	 * 获取某一选手所有评委的评判得分
	 * 
	 * @return
	 */
	public List<ComputeData> getJudgeScore(Integer raceId, Integer playerId) {
		try {
			List<ComputeData> dataList = new ArrayList<ComputeData>();
			String hql4judge = "select o from JudgeScore as o where o.raceId=? and o.playerId=?";
			List<JudgeScore> scoreList = judgeScoreDao.retrieveList(hql4judge, new Object[] { raceId, playerId });
			for (JudgeScore js : scoreList) {
				String hql4judgeWeight = "select o from RaceJudge as o where o.raceId=? and o.judgeId=?";
				RaceJudge rj = raceJudgeDao.retrieveObject(hql4judgeWeight, new Object[] { raceId, js.getJudge().getJudgeId() });
				ComputeData item = new ComputeData();
				item.setScore(js.getScore());
				item.setWeight(rj.getWeight());
				dataList.add(item);
			}
			return dataList;
		} catch (Exception e) {
			log.error(e);
			return new ArrayList<ComputeData>();
		}
	}

}
