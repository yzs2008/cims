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
<script src="${pageContext.request.contextPath }/refs/noty/packaged/jquery.noty.packaged.js"></script>
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

div.progressBarContainer {
	height: 11px;
	border: solid 1px #50B6E6;
	width: 150px;
	display: block;
	margin: 0 auto;
	margin-top: 10px;
	margin-bottom:5px;
	border-radius: 7px;
	padding: 1px;
}
.progressBar-hidden{
	visibility:hidden;
}

div.progressBar {
	margin: 0px 1px;
	height: 10px;
	width: 10px;
	background-color: #50B6E6;
	border-radius: 10px;
}
.submit-href{
    display: block;
    border: solid 1px black;
    color: white;
    background-color: #F89E38;
    border-radius: 5px;
    width: 40%;
    margin: 5px auto;
}
a:focus{
	color:black;
}
.startup-style{
    border: solid 1px red;
    margin: auto 150px;
    padding: 7px 20px;
    text-align: center;
    background-color: #FFF5F5;	
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
					<div class="startup-style">
					<s:if test="%{showStartup==true }">
						系统状态：<span style="color:red;font-weight:bold;">未开启</span>
						【若要使用系统评分，必须先<a style="    font-weight: bolder; color: red; margin: auto 20px;" href="${pageContext.request.contextPath }/admin/race/startup">开启系统</a>】
					</s:if>
					<s:else>
						系统状态：<span>已开启</span>
					</s:else>
					</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">
						<ul class="inline-ul">
							<c:forEach var="item" items="${ raceList }">
								<li>
									<div class="item-div">
										<h4>${item.raceName }</h4>
										<s:iterator var="stateItem" value="raceStateList" status="idStatus">
											<c:if test="${item.state.equals(stateItem) }">
												<input id='radio${item.raceId }${idStatus.index}' type="radio" name="state${item.raceId }" value="${stateItem }" checked>
												<label for='radio${item.raceId }<s:property value="#idStatus.index"/>'>${stateItem.toString() }</label>	                                				
                                			</c:if>
											<c:if test="${item.state!=stateItem }">
												<input id="radio${item.raceId }${idStatus.index}" type="radio" name="state${item.raceId }" value="${stateItem }">
												<label for="radio${item.raceId }${idStatus.index}">${stateItem.toString() }</label>	                                				
                                			</c:if>
										</s:iterator>
										<div class="progressBarContainer progressBar-hidden">
											<div class="progressBar"></div>
										</div>
									<a href="javascript:void(0);" class="submit-href" data-racestate="state${item.raceId }" data-raceid="${item.raceId }" onmousedown="submitPress(this)" onmouseup="submitRelease(this)">长按2秒提交修改</a>
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
		var duringMilliseconds=1800;
		function submitPress(evt) {
			var $progressDiv=$(evt).parent('div.item-div').children().find('div.progressBar');
			$progressDiv.parent().removeClass('progressBar-hidden');
			var raceState=$(evt).data('racestate');
			var raceId=$(evt).data('raceid');
			$progressDiv.animate({'width':'148px'},duringMilliseconds,function(){
				submitChange(raceState,raceId);	
			})
		}
		function submitRelease(evt) {
			var $progressDiv=$(evt).parent('div.item-div').children().find('div.progressBar');
			$progressDiv.stop().css({'width':'0px'});
			$progressDiv.parent().addClass('progressBar-hidden');
		}

		function submitChange(raceState,raceId) {
			var state = $('input[name="' + raceState + '"]:checked').val();
			console.info(state);

			var postData = {
				'state' : state,
				'raceId':raceId
			};
			var jsonData = JSON.stringify(postData);

			$.ajax({
				url : '${ pageContext.request.contextPath }/admin/race/updateState',
				method : 'POST',
				data : jsonData,
				dataType : 'json',
				async : false,
				contentType : 'application/json',
				success : function(data) {
					if (data.msg.state) {
						notify('information', data.msg.msg, 2000);	
					}else{
						notify('error', data.msg.msg, 2000);	
					}
				}
			});

		}
		function notify(_type,_msg,_duration){
			var handle=noty({
				text : _msg,
				type : _type,
				dismissQueue : true,
				layout : 'topCenter',
				maxVisible : 1,
				theme : 'defaultTheme'
			});	
			setTimeout(function() {
				$.noty.close(handle.options.id);
				handle = null;
			}, _duration);
		}
	</script>
</body>
</html>