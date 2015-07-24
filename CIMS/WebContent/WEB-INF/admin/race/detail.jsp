<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>赛事详细信息</title>
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

ul.info {
	margin-top: 20px;
}

ul.info li {
	display: inline-block;
	margin-right: 20px;
	  min-width: 400px;
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
					<div class="muted pull-left">赛事详细信息</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">
						<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/judge/update" enctype="multipart/form-data">
							<fieldset>
								<legend>赛事基本信息</legend>
								<div class="control-group">
									<ul class="info">
										<li>赛事名称 <span class="my-span">赛事名称是这个</span></li>
										<li>开赛时间<span class="my-span">赛事名称是这个</span></li>
										<li>主&nbsp;办&nbsp;方<span class="my-span">赛事名称是这个</span></li>
										<li>比赛地点<span class="my-span">赛事名称是这个</span></li>
										<li>所属轮次<span class="my-span">赛事名称是这个</span></li>
										<li>抽签模式<span class="my-span">赛事名称是这个</span></li>
										<li>评分模式<span class="my-span">赛事名称是这个</span></li>
										<li>现场投票时长<span class="my-span">赛事名称是这个</span></li>
										<li>排名模式<span class="my-span">抹去分组排名</span></li>
										<li>当前状态<span class="my-span">抹去分组排名</span></li>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>评委信息</legend>
								<div class="control-group">
									<ul class="info">
										<li>赛事名称 <span class="my-span">赛事名称是这个</span></li>
										<li>开赛时间<span class="my-span">赛事名称是这个</span></li>
										<li>主&nbsp;办&nbsp;方<span class="my-span">赛事名称是这个</span></li>
										<li>比赛地点<span class="my-span">赛事名称是这个</span></li>
										<li>所属轮次<span class="my-span">赛事名称是这个</span></li>
										<li>抽签模式<span class="my-span">赛事名称是这个</span></li>
										<li>评分模式<span class="my-span">赛事名称是这个</span></li>
										<li>现场投票时长<span class="my-span">赛事名称是这个</span></li>
										<li>排名模式<span class="my-span">抹去分组排名</span></li>
										<li>当前状态<span class="my-span">抹去分组排名</span></li>
									</ul>
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