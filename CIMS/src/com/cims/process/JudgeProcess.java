package com.cims.process;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.JudgeDao;
import com.cims.model.Judge;

@Service("JudgeProcess")
public class JudgeProcess {

	private final transient Logger log = Logger.getLogger(UserProcess.class);
	@Autowired
	private JudgeDao judgeDao;

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
}
