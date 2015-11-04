<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>添加赛事</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<link href="${pageContext.request.contextPath}/css/admin/jquery.datetimepicker.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/jquery.datetimepicker.js"></script>

<style type="text/css">
.left-right {
	display: inline-block;
	margin-top: 10px;
	margin-bottom: 10px;
}

.padding-top20 {
	margin-top: -20px;
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
					<div class="muted pull-left">添加赛事</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">
						<form class="form-horizontal" onsubmit="return validate();" method="post" action="${pageContext.request.contextPath }/admin/race/add">
							<fieldset>
								<legend>赛事基本信息</legend>
								<div class="control-group padding-top20">
									<div class="left-right">
										<label class="control-label" for="name">赛事名称 </label>
										<div class="controls">
											<input type="text" name="race.raceName" class="default" required="required" id="name">
										</div>
									</div>
									<div class="left-right">
										<label class="control-label" for="round">赛事轮次</label>
										<div class="controls">
											<select id="round-list" name="race.roundId" onchange="setRoundName()">
												<c:forEach var="item" items="${ roundList}">
													<option value="${item.roundId}">${item.roundName}</option>
												</c:forEach>
											</select> <input type="hidden" id="round-parentName" name="race.roundName">
										</div>
									</div>
								</div>
								<div class="control-group padding-top20">
									<div class="left-right">
										<label class="control-label" for="host">主办方</label>
										<div class="controls">
											<input type="text" class="default" name="race.host" id="host" required="required">
										</div>
									</div>
									<div class="left-right">
										<label class="control-label" for="startTime">开始时间</label>
										<div class="controls">
											<input type="text" class="default" name="startTime" id="startTime" required="required">
										</div>
									</div>
								</div>
								<div class="control-group padding-top20">
<!-- 									<div class="left-right"> -->
<!-- 										<label class="control-label" for="qualification">参赛资格</label> -->
<!-- 										<div class="controls"> -->
<!-- 											<input type="text" class="default" name="race.qualification" id="qualification" required="required"> -->
<!-- 										</div> -->
<!-- 									</div> -->
									<div class="left-right">
										<label class="control-label" for="place">举办地点</label>
										<div class="controls">
											<input type="text" name="race.place" class="default" id="place">
										</div>
									</div>
									<div class="left-right">
										<label class="control-label" for="drawPattern">排序模式</label>
										<div class="controls">
											<s:select name="race.drawPattern" listKey="key" listValue="value" list="drawPatternMap" />
										</div>
									</div>
								</div>
								<div class="control-group padding-top20">
									<div class="left-right">
										<label class="control-label" for="judgePattern">评分模式</label>
										<div class="controls">
											<s:select name="race.judgePattern" listKey="key" listValue="value" list="judgePatternMap" />
										</div>
									</div>
									<div class="left-right">
										<label class="control-label" for="voteTime">现场投票时长</label>
										<div class="controls">
											<input type="text" name="race.voteTime" class="default" id="voteTime">
										</div>
									</div>
								</div>
								<div class="control-group padding-top20">
									<div class="left-right">
										<label class="control-label" for="eraseGroup">备注</label>
										<div class="controls">
											<input type="text" name="race.mark" class="default" id="eraseGroup">
										</div>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label" for="textarea2">赛事简介</label>
									<div class="controls">
										<textarea class="input-xlarge textarea" name="race.description" placeholder="Enter text ..." style="width: 98%; height: 200px"></textarea>
									</div>
								</div>
								<div class="form-actions">
									<button type="submit" class="btn btn-primary" >提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
									<a href="${pageContext.request.contextPath }/admin/race/list"><button type="button" class="btn" style="margin-left: 50px;">放弃添加</button></a>
								</div>
							</fieldset>
						</form>

					</div>
				</div>
			</div>
		</div>
		<!-- /block -->
	</div>
	<%@ include file="../../common/adminFoot.jsp"%>
</body>
<script type="text/javascript">
	$(function(){
		$($('#round-list option')[0]).attr('selected',true);
		setRoundName();
		$("#startTime").datetimepicker({
			lang:'ch',
			step:30,
			onSelectTime:function(current_time,$input){
				$("#startTime").datetimepicker('hide');
			}
		});
	});
	function setRoundName() {
		var parentName = $('#round-list option:selected').text();
		$("#round-parentName").val(parentName);
	}
	function checkRoundName(){
		var accept=false;
		var name=$("#name").val();
		if(name==null||name==""){
			return accept;	
		}else{
			var postData={"race":{"raceName":name}};
			var jsonData=JSON.stringify(postData);
			$.ajax({
				   type: "POST",
				   url: '${ pageContext.request.contextPath }/admin/race/raceNameCheck',
				   data:jsonData,
				   dataType:'json',
				   contentType: 'application/json',
				   async:false,
				   success: function(data){
					   if(data.resultData){
						   accept =true;
					   }else{
						   accept= false;
					   }
				   }
				});		
			return accept;
		}
	}
	function validate() {
		var name = $("#name").val();
		if (name == null || name == "") {
			alert("赛事名称不能为空");
			return false;
		}
		if(!checkRoundName()){
			alert("已存在该比赛，请误重复添加");	
			return false;
		}
		return true;
	}
</script>
</html>