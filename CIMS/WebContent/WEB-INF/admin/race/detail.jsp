<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>赛事详情信息</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/fileupload/style.css" rel="stylesheet" media="screen">
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
<style type="text/css">
.form-horizontal .control-label {
	width: auto;
}

legend+.control-group {
	margin-top: 5px;
	margin-bottom: 5px;
}

legend {
	margin-bottom: 0px;
}

span.my-span {
	line-height: 30px !important;
	margin-left: 20px !important;
	display: inline-block !important;
	float: none !important;
	width: auto !important;
}

ul.info, ul.judge-info {
	margin-top: 20px;
}

ul.info li {
	display: inline-block;
	margin-right: 20px;
	min-width: 400px;
}

.width-50 {
	width: 50px;
}

ul.judge-info li {
	display: inline-block;
	margin-right: 20px;
	min-width: 150px;
	text-align: center;
	margin-bottom: 20px;
}

ul.player-info li {
	display: inline-block;
	min-width: 80px;
	text-align: center;
	margin-bottom: 20px;
}
</style>
</head>

<body>
	<%@ include file="../../common/adminHeader.jsp"%>
	<%@ include file="../../common/adminMenu.jsp"%>
	<!--/span-->
	<div class="span9" id="content">
		<!-- morris stacked chart -->
		<div class="row-fluid">
			<!-- block -->
			<div class="block">
				<div class="navbar navbar-inner block-header">
					<div class="muted pull-left">赛事详情信息</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">
						<form class="form-horizontal">
							<fieldset>
								<legend>赛事基本信息</legend>
								<div class="control-group">
									<ul class="info">
										<li>
											赛事名称
											<span class="my-span">${race.raceName}</span>
										</li>
										<li>
											开赛时间
											<span class="my-span">${race.startTime }</span>
										</li>
										<li>
											主&nbsp;办&nbsp;方&nbsp;
											<span class="my-span">${race.host }</span>
										</li>
										<li>
											比赛地点
											<span class="my-span">${race.place }</span>
										</li>
										<li>
											所属轮次
											<span class="my-span">${race.roundName }</span>
										</li>
										<li>
											抽签模式
											<span class="my-span">${race.drawPattern.toString() }</span>
										</li>
										<li>
											评分模式
											<span class="my-span">${race.judgePattern.toString() }</span>
										</li>
										<li>
											现场投票时长
											<span class="my-span">${race.voteTime }</span>
										</li>
										<li>
											当前状态
											<span class="my-span">${race.state.toString() }</span>
										</li>
										<li>
											备注
											<span class="my-span">${race.mark }</span>
										</li>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>评委信息</legend>
								<div class="control-group">
									<ul class="judge-info">
										<s:iterator value="judgeModelList" var="items">
											<li>
												<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/${ items.judge.avatar}"/>
												<br>
												<span>${items.judge.judgeName }</span>
												<span> [${items.raceJudge.displayName }] </span>
												<span> * ${items.raceJudge.weight }</span>
											</li>
										</s:iterator>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>选手信息</legend>
								<div class="control-group">
									<ul class="player-info">
										<s:iterator value="playerList" var="item">
											<li>
												<img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }${item.avatar }">
												<br>
												<span>${item.realName }</span>
											</li>
										</s:iterator>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>晋级设置</legend>
								<div class="control-group">
									<ul class="player-info" style="margin-top: 20px;">
										<s:iterator value="racePromotionList" var="promotionItem">
											<li style="margin-right: 50px;">
												<span>第</span>
												<span style="color: red">${promotionItem.start }</span>
												<span>至</span>
												<span style="color: red;">${promotionItem.end }</span>
												名
												<span style="color: green;">晋级到</span>
												<span>${promotionItem.nextRaceName }</span>
											</li>
										</s:iterator>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>奖项设置</legend>
								<div class="control-group">
									<ul class="player-info">
										<s:iterator value="raceAwardList" var="awardItem">
											<li style="margin-right: 50px;">
												<span>第</span>
												<span style="color: red">${awardItem.start }</span>
												<span>至</span>
												<span style="color: red;">${awardItem.start+awardItem.count-1 }</span>
												名
												<span style="color: green;">称为</span>
												<span style="color: red; font-weight: bolder;">${awardItem.awardName }</span>
											</li>
										</s:iterator>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>评分项设置</legend>
								<div class="control-group">
									<ul class="player-info">
										<s:iterator value="raceStandardList" var="standardItem" status="itemStatus">
											<li style="margin-right: 50px;">
												<span>
													(
													<s:property value="%{#itemStatus.index + 1}" />
													)
												</span>
												<span>${standardItem.standardName }</span>
												分值
												<span style="color: green;">${standardItem.max-standardItem.min }</span>
												最高
												<span style="color: red; font-weight: bolder;">${standardItem.max }</span>
												最低
												<span style="color: red; font-weight: bolder;">${standardItem.min }</span>
											</li>
										</s:iterator>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>赛事简介</legend>
								<div class="control-group">
									<p>${race.description }</p>
								</div>
							</fieldset>
						</form>

					</div>
				</div>
			</div>
			<!-- /block -->
		</div>
	</div>
	<%@ include file="../../common/adminFoot.jsp"%>
</body>
<script type="text/javascript">
	$(function() {
	});
</script>
</html>