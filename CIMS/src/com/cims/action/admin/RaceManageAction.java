package com.cims.action.admin;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.model.datastruct.DrawPattern;
import com.cims.model.datastruct.JudgeModel;
import com.cims.model.datastruct.JudgePattern;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.Award;
import com.cims.model.persist.Judge;
import com.cims.model.persist.Promotion;
import com.cims.model.persist.Race;
import com.cims.model.persist.RaceJudge;
import com.cims.model.persist.Round;
import com.cims.model.persist.Standard;
import com.cims.model.persist.User;
import com.cims.process.JudgeProcess;
import com.cims.process.RaceProcess;

@Namespace("/admin/race")
public class RaceManageAction extends BaseAction {

	private static final long serialVersionUID = 3742461286899118994L;

	@Autowired
	private RaceProcess raceProcess;
	@Autowired
	private JudgeProcess judgeProcess;

	private Race race;
	private List<Race> raceList;
	private Integer id;
	private Race race4update;
	private String startTime;

	private List<Round> roundList;
	private Map<String, String> judgePatternMap;
	private Map<String, String> drawPatternMap;

	private List<Judge> judgeList;
	private List<RaceJudge> raceJudgeList;
	private List<Promotion> racePromotionList;
	private List<Award> raceAwardList;
	private List<Standard> raceStandardList;
	private List<User> playerList;
	
	private List<JudgeModel> judgeModelList;

	public RaceManageAction() {
		judgePatternMap = new LinkedHashMap<String, String>();
		for (JudgePattern p : JudgePattern.values()) {
			judgePatternMap.put(p.name(), p.toString());
		}
		drawPatternMap = new LinkedHashMap<String, String>();
		for (DrawPattern d : DrawPattern.values()) {
			drawPatternMap.put(d.name(), d.toString());
		}
	}

	/**
	 * 赛事基本信息列表
	 * @return
	 */
	@Action(value = "list", results = { @Result(name = "input", location = "/WEB-INF/admin/race/list.jsp") })
	public String list() {
		raceList = raceProcess.retrieveList(new Race());
		return INPUT;
	}

	@Action(value = "raceDetail", results = { @Result(name = "input", location = "/WEB-INF/admin/race/detail.jsp"),
										  @Result(name = "backToList",type="redirect", location = "list") })
	public String detail() {
		if(id==null){
			return "backToList";
		}
		try {
			//获取赛事评委信息
			raceJudgeList = raceProcess.retrieveJudgeList(id);
			judgeModelList=raceProcess.retrieveJudgeList(raceJudgeList);
			//获取比赛基本信息
			race=raceProcess.retrieve(id);
			//获取赛事晋级信息
			racePromotionList=raceProcess.retrievePromotionList(id);
			//获取赛事奖项设置信息
			raceAwardList=raceProcess.retrieveAwardList(id);
			//获取赛事评分项信息
			raceStandardList=raceProcess.retrieveStandard(id);
			//获取选手列表信息
			playerList=raceProcess.retrievePlayer(id);
			
			return INPUT;
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
	}

	/**
	 * 添加比赛，填写赛事基本信息
	 * @return
	 */
	@Action(value = "add", results = { @Result(name = "input", location = "/WEB-INF/admin/race/add.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String add() {
		try {
			if (accept()) {
				race.setState(RaceState.needConfig);
				raceProcess.saveRace(race);
				return SUCCESS;
			} else {
				roundList = raceProcess.retrieveRoundList();
				return INPUT;
			}
		} catch (Exception e) {
			log.error(e.getCause().getMessage());
			return ERROR;
		}
	}

	/**
	 * 初始化赛事配置页面
	 * @return
	 */
	@Action(value = "config", results = { @Result(name = "input", location = "/WEB-INF/admin/race/config.jsp") })
	public String config() {
		try {
			if(id==null){
				return INPUT;
			}
			judgeList = judgeProcess.retrieveList(new Judge());
			raceList=raceProcess.retrieveList(new Race());
			racePromotionList=raceProcess.retrievePromotionList(id);
			raceAwardList=raceProcess.retrieveAwardList(id);
			raceStandardList=raceProcess.retrieveStandard(id);
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
		return INPUT;
	}

	@Action(value = "update", results = { @Result(name = "input", location = "/WEB-INF/admin/race/edit.jsp"), @Result(name = "success", type = "redirect", location = "list") })
	public String update() {
		return INPUT;
	}

	/**
	 * 赛事基本信息编辑
	 * @return
	 */
	@Action(value = "edit", results = { @Result(name = "input", location = "/WEB-INF/admin/race/edit.jsp") })
	public String edit() {
		if (id == null) {
			return ERROR;
		}
		try {
			race = raceProcess.retrieve(id);
			return INPUT;
		} catch (Exception e) {
			log.error(e.getMessage());
			return ERROR;
		}
	}

	/**
	 * 配置评委
	 * @throws IOException
	 */
	@Action(value = "configJudge",interceptorRefs={@InterceptorRef(value="json")})
	public void configJudge() throws IOException {
		JSONObject resultData = new JSONObject();
		try {
			if (raceJudgeList != null && raceJudgeList.size() != 0) {
				raceProcess.configJudge(raceJudgeList);
			}
			resultData.put("resultData", "done");
		} catch (Exception e) {
			log.error(e.getMessage());
			resultData.put("resultData", "error");
		}
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	/**
	 * 获取赛事评委信息
	 * @throws IOException
	 */
	@Action(value="raceJudgeInfo",interceptorRefs={@InterceptorRef(value="json")})
	public void raceJudgeInfo() throws IOException{
		JSONObject resultData=new JSONObject();
		try{
			List<RaceJudge> raceJudgeInfoList=new ArrayList<RaceJudge>();
			if(id!=null){
				raceJudgeInfoList= raceProcess.retrieveJudgeList(id);
			}		
			resultData.put("resultData", raceJudgeInfoList);
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", new ArrayList<RaceJudge>());
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	
	/**
	 * 配置赛事晋级
	 * @throws IOException 
	 */
	@Action(value="configPromotion",interceptorRefs={@InterceptorRef(value="json")})
	public void racePromotionConfig() throws IOException{
		JSONObject resultData = new JSONObject();
		try{
			if(racePromotionList!=null && racePromotionList.size()!=0){
				raceProcess.configPromotion(racePromotionList);
			}
			resultData.put("resultData", "done");
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", "error");
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	/**
	 * 配置赛事奖项
	 * @throws IOException 
	 */
	@Action(value="configAward",interceptorRefs={@InterceptorRef(value="json")})
	public void raceAwardConfig() throws IOException{
		JSONObject resultData = new JSONObject();
		try{
			if(raceAwardList!=null && raceAwardList.size()!=0){
				raceProcess.configAward(raceAwardList);
			}
			resultData.put("resultData", "done");
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", "error");
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	
	
	/**
	 * 配置赛事评分项
	 * @throws IOException 
	 */
	@Action(value="configStandard",interceptorRefs={@InterceptorRef(value="json")})
	public void raceStandardConfig() throws IOException{
		JSONObject resultData = new JSONObject();
		try{
			if(raceStandardList!=null && raceStandardList.size()!=0){
				raceProcess.configStandard(raceStandardList);
			}
			resultData.put("resultData", "done");
		}catch(Exception e){
			log.error(e.getMessage());
			resultData.put("resultData", "error");
		}
		String resultJson=resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}
	
	
	/**
	 * 检查赛事名称是否重复
	 */
	@Action(value="raceNameCheck",interceptorRefs={@InterceptorRef(value="json")})
	public void raceNameCheck() {
		try {
			if (StringUtils.isNotBlank(race.getRaceName())) {
				JSONObject resultData = new JSONObject();
				if (raceProcess.raceNameCheck(race.getRaceName())) {
					resultData.put("resultData", true);
				} else {
					resultData.put("resultData", false);
				}
				String jsonResult = resultData.toJSONString();
				HttpUtils.responseJson(jsonResult, response);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	}

	/**
	 * 检查赛事信息是否填写完整
	 * @return
	 */
	private boolean accept() {
		boolean accept = true;
		if (race == null) {
			accept = false;
			return accept;
		}
		if (StringUtils.isBlank(race.getRaceName())) {
			accept = false;
		}
		if (StringUtils.isBlank(race.getHost())) {
			accept = false;
		}
		if (StringUtils.isBlank(race.getRoundName())) {
			accept = false;
		}
		if (race.getRoundId() == null) {
			accept = false;
		}
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
			race.setStartTime(sdf.parse(startTime));
		} catch (Exception e) {
			accept = false;
		}
		if (race.getStartTime() == null) {
			accept = false;
		}
		return accept;
	}
	
	public Race getRace() {
		return race;
	}
	public List<Race> getRaceList() {
		return raceList;
	}

	public Integer getId() {
		return id;
	}

	public Race getRace4update() {
		return race4update;
	}

	public void setRace(Race race) {
		this.race = race;
	}

	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRace4update(Race race4update) {
		this.race4update = race4update;
	}

	public List<Round> getRoundList() {
		return roundList;
	}

	public void setRoundList(List<Round> roundList) {
		this.roundList = roundList;
	}

	public Map<String, String> getJudgePatternMap() {
		return judgePatternMap;
	}

	public Map<String, String> getDrawPatternMap() {
		return drawPatternMap;
	}

	public void setJudgePatternMap(Map<String, String> judgePatternMap) {
		this.judgePatternMap = judgePatternMap;
	}

	public void setDrawPatternMap(Map<String, String> drawPatternMap) {
		this.drawPatternMap = drawPatternMap;
	}

	public List<User> getPlayerList() {
		return playerList;
	}

	public void setPlayerList(List<User> playerList) {
		this.playerList = playerList;
	}

	public String getStartTime() {
		return startTime;
	}

	public List<JudgeModel> getJudgeModelList() {
		return judgeModelList;
	}

	public void setJudgeModelList(List<JudgeModel> judgeModelList) {
		this.judgeModelList = judgeModelList;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public List<Standard> getRaceStandardList() {
		return raceStandardList;
	}

	public void setRaceStandardList(List<Standard> raceStandardList) {
		this.raceStandardList = raceStandardList;
	}

	public List<Judge> getJudgeList() {
		return judgeList;
	}

	public List<Award> getRaceAwardList() {
		return raceAwardList;
	}

	public void setRaceAwardList(List<Award> raceAwardList) {
		this.raceAwardList = raceAwardList;
	}

	public void setJudgeList(List<Judge> judgeList) {
		this.judgeList = judgeList;
	}

	public List<RaceJudge> getRaceJudgeList() {
		return raceJudgeList;
	}

	public List<Promotion> getRacePromotionList() {
		return racePromotionList;
	}

	public void setRacePromotionList(List<Promotion> racePromotionList) {
		this.racePromotionList = racePromotionList;
	}

	public void setRaceJudgeList(List<RaceJudge> raceJudgeList) {
		this.raceJudgeList = raceJudgeList;
	}

}
