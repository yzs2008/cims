<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>当前进行的赛事列表</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="${pageContext.request.contextPath }/refs/judge/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/skel-layers.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/init-racelist.js"></script>
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/skel.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/style-desktop.css" />
</noscript>
<!--[if lte IE 9]><link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><script src="${pageContext.request.contextPath }/refs/judge/js/html5shiv.js"></script><![endif]-->
<style type="text/css">
.race-name {
	color: white;
	text-align: center;
	vertical-align: middle;
	font-size: 2em;
	font-weight: bolder;
}
</style>
</head>
<body>
	<div id="header-wrapper">
		<div class="container">
			<div class="row">
				<div class="12u">
				</div>
			</div>
		</div>
	</div>
	<div id="main" style="background-color: #e3e9dc; padding: 3em 0;">

		<div class="container">
			<div class="row main-row">
				<s:iterator value="raceList" var="item">
					<div class="4u" style="margin:0 auto;float:none;cursor:pointer;">
						<section class="race-list " onclick="selectAndGo(this)" data-id="${item.raceId }">
							<p class="race-name">${item.raceName }</p>
						</section>
					</div>
				</s:iterator>
			</div>

		</div>
	</div>
	<div id="footer-wrapper" style="padding: 1% 0 1% 0;">
		<div class="container">
			<div class="row">
				<div class="12u">

					<div id="copyright" style="margin: 0px; padding-top: 1em;">
						&copy; 郑州大学. | 设计研发: <a href="http://html5up.net">挂坠儿</a>
					</div>

				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function selectAndGo(evt){
			var raceId=$(evt).data('id');	
			location.href='choose?raceId='+raceId;
		}	
	</script>
</body>
</html>