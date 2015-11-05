package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.FinalScoreDao;
import com.cims.dao.RaceDao;
import com.cims.dao.SignUpDao;
import com.cims.dao.UserDao;
import com.cims.model.datastruct.OrderScoreItem;
import com.cims.model.persist.FinalScore;
import com.cims.model.persist.Race;
import com.cims.model.persist.SignUp;
import com.cims.model.persist.User;

@Service("ScreenProcess")
public class ScreenProcess {

	private final transient Logger log = Logger.getLogger(ScreenProcess.class);
	
	@Autowired
	private RaceDao raceDao;
	@Autowired
	private FinalScoreDao finalScoreDao;
	@Autowired
	private SignUpDao signUpDao;
	@Autowired
	private UserDao userDao;
	
	public List<OrderScoreItem> getOrderScoreList(Race race){
		try{
			ArrayList<OrderScoreItem> itemList=new ArrayList<OrderScoreItem>();
			
			String hql="select o from FinalScore as o where raceId=? order by o.finalScore desc";
			List<FinalScore> finalScoreList=finalScoreDao.retrieveList(hql, new Object[]{race.getRaceId()});
			for(FinalScore fs : finalScoreList){
				OrderScoreItem item=new OrderScoreItem();
				User user=fs.getPlayer();
				String hql4sign="select o from SignUp as o where o.raceId=? and o.userId=?";
				SignUp su=signUpDao.retrieveObject(hql4sign, new Object[]{race.getRaceId(),user.getUserId()});
				item.setPlayer(user);
				item.setProduction(su);
				item.setScore(fs.getFinalScore());
				itemList.add(item);
			}
			return itemList;
		}catch(Exception e){
			log.error(e);
			return new ArrayList<OrderScoreItem>();
		}
	}
	
}
