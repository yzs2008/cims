package com.cims.action.main;


import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.cims.base.frame.BaseAction;
import com.cims.base.type.ActionContant;
import com.cims.model.datastruct.OrderScoreItem;
import com.cims.model.persist.Race;
import com.cims.process.RaceProcess;
import com.cims.process.ScreenProcess;

@Namespace("/main")
@InterceptorRef("screenInterceptorStack")
public class ScreenShow extends BaseAction {
	private static final long serialVersionUID = 7602284715386060788L;
	
	@Autowired
	private RaceProcess raceProcess;
	@Autowired
	private ScreenProcess screenProcess;
	
	private String raceId;
	private List<Race> raceList;
	
	private List<OrderScoreItem> itemList;

	@Action(value = "orderscore", results = { @Result(name = "input", location = "/WEB-INF/content/main/orderScore.jsp"),
			@Result(name = "back", type = "redirect", location = "wait") })
	public String orderScore(){
		Race race=(Race)sessionMap.get(ActionContant.session_screen_race);
		itemList=screenProcess.getOrderScoreList(race);
		return INPUT;
	}
	/**
	 * 选择要显示排名 的比赛
	 * @return
	 */
	@Action(value = "choose", results = { @Result(name = "input", location = "/WEB-INF/content/main/choose.jsp"),
			@Result(name = "success", type = "redirect", location = "orderscore") })
	public String choose(){
		if(raceId==null){
			//列出现在进行的所有比赛
			raceList=raceProcess.getUnderwayRaceList();
			return INPUT;
		}
		//加入选择 的比赛
		Race race=raceProcess.retrieve(Integer.valueOf(raceId));
		sessionMap.put(ActionContant.session_screen_race, race);
		return SUCCESS;
	}
	public String getRaceId() {
		return raceId;
	}
	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}
	public List<Race> getRaceList() {
		return raceList;
	}
	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}
	public List<OrderScoreItem> getItemList() {
		return itemList;
	}
	public void setItemList(List<OrderScoreItem> itemList) {
		this.itemList = itemList;
	}
}
