package com.cims.process;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cims.dao.AwardDao;
import com.cims.dao.FinalScoreDao;
import com.cims.dao.RaceDao;
import com.cims.dao.SignUpDao;
import com.cims.dao.UserDao;
import com.cims.model.datastruct.OrderScoreItem;
import com.cims.model.persist.Award;
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
	@Autowired
	private AwardDao awardDao;
	
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

	public List<OrderScoreItem> getAwardList(List<OrderScoreItem> itemList,Race race) {
		try{
			//获取比赛的奖项列表	
			String hql="select o from Award as o where o.raceId=? order by o.start asc";
			List<Award> awardList=awardDao.retrieveList(hql, race.getRaceId());
			int start=0,end=0;
			int total=itemList.size()-1;
			for(Award a : awardList){
				if(start>=total){
					break;
				}
				int sysStart=a.getStart()-1;
				start=start>sysStart?start:sysStart;
				start=start>total?total:start;
				end=a.getCount();
				for(int i=0;i<end;i++){
					itemList.get(start).setAward(a.getAwardName());
					start++;
					if(start>total){
						break;
					}
				}
				//并列情况处理，并列选手同时获奖
				boolean tieFlag=false;
				do{
					if(start>total || start ==0){
						tieFlag=false;
					}else{
						if(itemList.get(start).getScore().equals(itemList.get(start-1).getScore())){
							itemList.get(start).setAward(itemList.get(start-1).getAward());
							tieFlag=true;
							start++;
						}else{
							tieFlag=false;
						}
					}
				}while(tieFlag);
			}
			
		}catch(Exception e){
			log.error(e);
		}
		return itemList;
	}
	
}
