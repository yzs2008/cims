package com.cims.action.admin;

import java.io.IOException;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.cims.base.frame.BaseAction;
import com.cims.base.frame.HttpUtils;
import com.cims.model.datastruct.Message;
import com.cims.model.datastruct.RaceState;
import com.cims.model.persist.Race;
import com.cims.process.RaceProcess;
import com.opensymphony.xwork2.ActionContext;

@Namespace("/admin/race")
public class RaceControl extends BaseAction {

	private static final long serialVersionUID = 1L;

	@Autowired
	private RaceProcess raceProcess;

	private List<Race> raceList;
	private RaceState[] raceStateList = RaceState.values();
	private String raceId;
	private String state;

	@Action(value = "index", results = { @Result(name = "input", location = "/WEB-INF/admin/race/controlpanel.jsp") })
	public String index() {
		try {
			raceList = raceProcess.retrieveList();
			return INPUT;
		} catch (Exception e) {
			log.error(e);
			return ERROR;
		}
	}

	/**
	 * 配置赛事奖项
	 * 
	 * @throws IOException
	 */
	@Action(value = "updateState", interceptorRefs = { @InterceptorRef(value = "json") })
	public void raceStateUpdate() throws IOException {
		JSONObject resultData = new JSONObject();
		Message msg = new Message();
		try {
			if (StringUtils.isEmpty(state) || StringUtils.isEmpty(raceId)) {
				msg.setState(false);
				msg.setMsg("参数错误！");
			}
			if (raceProcess.updateRaceState(raceId, state)) {
				raceProcess.monitorState(raceId, state, ActionContext.getContext().getApplication());
				msg.setMsg("状态更新成功");
				msg.setState(true);

			} else {
				msg.setMsg("状态更新失败");
				msg.setState(false);
			}
		} catch (Exception e) {
			log.error(e.getMessage());
			msg.setMsg("状态更新失败");
			msg.setState(false);
		}
		resultData.put("msg", msg);
		String resultJson = resultData.toJSONString();
		HttpUtils.responseJson(resultJson, response);
	}

	public List<Race> getRaceList() {
		return raceList;
	}

	public void setRaceList(List<Race> raceList) {
		this.raceList = raceList;
	}

	public RaceState[] getRaceStateList() {
		return raceStateList;
	}

	public void setRaceStateList(RaceState[] raceStateList) {
		this.raceStateList = raceStateList;
	}

	public String getRaceId() {
		return raceId;
	}

	public void setRaceId(String raceId) {
		this.raceId = raceId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
