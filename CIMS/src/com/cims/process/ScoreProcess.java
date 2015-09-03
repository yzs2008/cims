package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.AdjustScoreDao;
import com.cims.dao.FinalScoreDao;
import com.cims.dao.JudgeScoreDao;
import com.cims.dao.JudgeScoreDetailDao;
import com.cims.dao.LiveScoreDao;
import com.cims.dao.VoteDao;
import com.cims.dao.VoteDetailDao;
import com.cims.model.persist.FinalScore;

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
	
}
