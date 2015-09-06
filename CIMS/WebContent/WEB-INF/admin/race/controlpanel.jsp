<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>赛事控制面板</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/DT_bootstrap.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<style>
.inline-ul {
	
}

.inline-ul li {
	display: inline-block;
	margin: 10px 5px;
}
.inline-ul li label{
	display: inline-block;
}

.item-div {
	text-align: center;
	border: solid 5px rgb(64, 195, 190);
	padding: 10px 20px;
}

#progressBarContainer {
	height: 11px;
	border: solid 1px #50B6E6;
	width: 150px;
	display: block;
	margin: 0 auto;
	margin-top: 10px;
	margin-bottom:5px;
	visibility:hidden;
	border-radius: 7px;
	padding: 1px;
}

#progressBar {
	margin: 0px 1px;
	height: 10px;
	width: 10px;
	background-color: #50B6E6;
	border-radius: 10px;
}
</style>
</head>

<body>
	<%@ include file="../../common/adminHeader.jsp"%>
	<%@ include file="../../common/adminMenu.jsp"%>
	<div class="span9" id="content">
		<!-- morris stacked chart -->
		<div class="row-fluid">
			<!-- block -->
			<div class="block">
				<div class="navbar navbar-inner block-header">
					<div class="muted pull-left">赛事控制面板</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">
						<ul class="inline-ul">
							<c:forEach var="item" items="${ raceList }">
								<li>
									<div class="item-div">
										<h4>${item.raceName }</h4>
										<s:iterator var="stateItem" value="raceStateList" status="status">
											<c:if test="${item.state.equals(stateItem) }">
												<input id="radio${item.raceId }<s:property value="#status.index"/>" type="radio" name="state${item.raceId }" value="${stateItem }" checked>
												<label for="radio${item.raceId }<s:property value="#status.index"/>">${stateItem.toString() }</label>	                                				
                                			</c:if>
											<c:if test="${item.state!=stateItem }">
												<input id="radio${item.raceId }${status}" type="radio" name="state${item.raceId }" value="${stateItem }">
												<label for="radio${item.raceId }${status}">${stateItem.toString() }</label>	                                				
                                			</c:if>
										</s:iterator>
										<div id="progressBarContainer" class="progressBar-hidden">
											<div id="progressBar"></div>
										</div>
										<button>长按2秒修改赛事状态</button>
									</div>
								</li>
							</c:forEach>
						</ul>
					</div>
				</div>
				<!-- /block -->
			</div>
		</div>
	</div>
	<%@ include file="../../common/adminFoot.jsp"%>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		function detail(evt) {
			var id = $(evt).data("id");
			window.location.href = "detail?id=" + id;
		}
		function deleted(evt) {
			var id = $(evt).data("id");
			window.location.href = "deleted?id=" + id;
		}
		function config(evt) {
			var id = $(evt).data("id");
			window.location.href = "config?id=" + id;
		}
	</script>
</body>
</html>