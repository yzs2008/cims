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
						<form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/judge/update" enctype="multipart/form-data">
							<fieldset>
								<legend>赛事基本信息</legend>
								<div class="control-group">
									<ul class="info">
										<li>赛事名称<span class="my-span">赛事名称是这个</span></li>
										<li>开赛时间<span class="my-span">赛事名称是这个</span></li>
										<li>主&nbsp;办&nbsp;方&nbsp;<span class="my-span">赛事名称是这个</span></li>
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
									<ul class="judge-info">
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
										<li><img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>评委名</span></li>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>选手信息</legend>
								<div class="control-group">
									<ul class="player-info">
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手姓名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>晋级设置</legend>
								<div class="control-group">
									<ul class="player-info">
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>奖项设置</legend>
								<div class="control-group">
									<ul class="player-info">
										<li><img alt="选手头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span>选手名(男)</span></li>
									</ul>
								</div>
							</fieldset>
							<fieldset>
								<legend>赛事简介</legend>
								<div class="control-group">
									<p>赛事名称: China Open (中国网球公开赛) 赛事简介：创办于2004年的中国网球公开赛是同时拥有ATP、SE WTA和ITF三个国际网球组织赛事的顶级综合网球赛事。2009年全新的中国网球公开赛是中国唯一以国家命名的网球赛事、亚洲最顶级的网球赛事、亚洲覆盖人群最广的网球赛事、中国推广范围最大、推广周期最长的网球赛事以及亚洲最具商业价值的网球赛事。 举办城市: 中华人民共和国，北京 日期及比赛项目：2009年10月2日至11日 WTA女子单打 WTA女子双打 ATP男子单打 ATP男子双打 ITF国际青少组 赛事选手：全球顶级的网球选手参加 WTA世界排名前50位强制出赛 ATP世界排名前30位半数以上出赛 赛事奖金：亚洲地区网球赛事奖金最高，达到660万美金 WTA皇冠明珠赛奖金450万美金 ATP500赛事奖金210万美金 比赛地点：最顶级的网球赛场—国家网球中心 主办单位：国家体育总局 北京市人民政府</p>
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