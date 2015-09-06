package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.AdjustScoreDao;
import com.cims.dao.FinalScoreDao;
import com.cims.dao.JudgeDao;
import com.cims.dao.JudgeScoreDao;
import com.cims.dao.JudgeScoreDetailDao;
import com.cims.dao.LiveScoreDao;
import com.cims.dao.RaceJudgeDao;
import com.cims.dao.SignUpDao;
import com.cims.dao.UserDao;
import com.cims.dao.VoteDao;
import com.cims.dao.VoteDetailDao;
import com.cims.model.datastruct.PlayerScoreModel;
import com.cims.model.datastruct.JudgeScoreModel;
import com.cims.model.persist.FinalScore;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.JudgeScore;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;

@Service("ScoreProcess")
public class ScoreProcess {
	private final transient Logger log = Logger.getLogger(RoundProcess.class);
	
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
	private JudgeScoreDao scoreDao;
	
	
	
	/*
	 * 获取所有评委对某一选手的评分集合
	 */
	public List<JudgeScoreModel> getJudgeScoreModel(Integer raceId,Integer playerId){
		try{
			List<JudgeScoreModel> judgeScoreModelList=new ArrayList<JudgeScoreModel>();
			List<JudgeScoreModel> judgeList=getAllJudgeByRace(raceId);
			List<JudgeScore> judgeScoreList=getJudgeScoreByPlayer(raceId, playerId);
			for(JudgeScoreModel j:judgeList){
				j.setScore(getJudgeScoreByJudge(judgeScoreList, j.getJudge()));
				judgeScoreModelList.add(j);
			}
			return judgeScoreModelList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<JudgeScoreModel>();
		}
	}
	/*
	 * 获取某一评委对所有选手的评分集合
	 */
	public List<PlayerScoreModel> getJudgeTraceScoreModel(Integer raceId,Integer judgeId){
		try{
			List<PlayerScoreModel> judgeScoreTraceModelList=new ArrayList<PlayerScoreModel>();
			List<JudgeScore> judgeScoreList=getJudgeScoreByJudge(raceId, judgeId);
			List<User> userList=getAllPlayerByRace(raceId);
			for(User u : userList){
				PlayerScoreModel item=new PlayerScoreModel();
				item.setUser(u);
				item.setScore(getJudgeScoreByUser(judgeScoreList, u));
				judgeScoreTraceModelList.add(item);
			}
			
			return judgeScoreTraceModelList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<PlayerScoreModel>();
		}
	}
	/*
	 * 获取所有选手的最终评分集合
	 */
	public List<PlayerScoreModel> getFinalScoreModel(Integer raceId){
		try{
			List<PlayerScoreModel> finalScoreModelList=new ArrayList<PlayerScoreModel>();
			List<FinalScore> finalScoreList=getFinalScore(raceId);
			List<User> userList=getAllPlayerByRace(raceId);
			for(User u:userList){
				PlayerScoreModel model=new PlayerScoreModel();
				model.setUser(u);
				model.setScore(getFinalScoreByUser(finalScoreList, u));
				finalScoreModelList.add(model);
			}
			
			return finalScoreModelList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<PlayerScoreModel>();
		}
	}
	private Double getJudgeScoreByJudge(List<JudgeScore> judgeScore,Judge judge){
		Double score=0D;
		for(JudgeScore js: judgeScore){
			if(js.getJudge().getJudgeId()==judge.getJudgeId()){
				score=js.getScore();
				break;
			}
		}
		return score;
	}
	private Double getJudgeScoreByUser(List<JudgeScore> judgeScore,User user){
		Double score=0D;
		for(JudgeScore js: judgeScore){
			if(js.getPlayerId()==user.getUserId()){
				score=js.getScore();
				break;
			}
		}
		return score;
	}
	public List<JudgeScore> getJudgeScoreByJudge(Integer raceId,Integer judgeId) {
		try{
			String hql="select o from JudgeScore as o where o.raceId=? and o.judge.judgeId=?";
			List<JudgeScore> scoreList=scoreDao.retrieveList(hql, new Object[]{raceId,judgeId});
			return scoreList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<JudgeScore>();
		}
	}
	
	public List<JudgeScore> getJudgeScoreByPlayer(Integer raceId,Integer playerId) {
		try{
			String hql="select o from JudgeScore as o where o.raceId=? and o.playerId=?";
			List<JudgeScore> scoreList=scoreDao.retrieveList(hql, new Object[]{raceId,playerId});
			return scoreList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<JudgeScore>();
		}
	}
	private Double getFinalScoreByUser(List<FinalScore> finalScore,User user){
		Double score=0D;
		for(FinalScore fs: finalScore){
			if(fs.getPlayer().getUserId()==user.getUserId()){
				score=fs.getFinalScore();
				break;
			}
		}
		return score;
	}
	public List<FinalScore> getFinalScore(Integer raceId) {
		try{
			String hql="select o from FinalScore as o where o.raceId=?";
			List<FinalScore> finalScoreList=finalScoreDao.retrieveList(hql, raceId);
			return finalScoreList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<FinalScore>();
		}
	}
	
	public List<User> getAllPlayerByRace(Integer raceId){
		try{
			List<User> playerList=new ArrayList<User>();
			String hql="select o from SignUp as o where o.raceId=?";
			List<SignUp> signupList=signUpDao.retrieveList(hql, raceId);
			for(SignUp su:signupList){
				User tem=userDao.retrieveById(su.getUserId());
				playerList.add(tem);
			}
			return playerList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<User>();
		}
	}
	public List<JudgeScoreModel> getAllJudgeByRace(Integer raceId){
		try{
			List<JudgeScoreModel> judgeList=new ArrayList<JudgeScoreModel>();
			String hql="select o from RaceJudge as o where o.raceId=?";
			List<RaceJudge> raceJudgeList=raceJudgeDao.retrieveList(hql, raceId);
			for(RaceJudge rj:raceJudgeList){
				Judge tem=judgeDao.retrieveById(rj.getJudgeId());
				JudgeScoreModel model=new JudgeScoreModel();
				model.setJudge(tem);
				model.setRaceJudge(rj);
				judgeList.add(model);
			}
			return judgeList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<JudgeScoreModel>();
		}
	}
	public SignUp getSignUpByUser(User user, Race race) {
		try{
			String hql="select o from SignUp where o.userId=? and raceId=?";
			SignUp sign = signUpDao.retrieveObject(hql, new Object[]{user.getUserId(),race.getRaceId()});
			return sign;
		}catch(Exception e){
			log.error(e);
			return null;
		}
	}
	
}
