<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>赛事配置</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/default4checkbox.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/inserthtml.com.radios.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/styles4checkbox.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.bootstrap.wizard.js"></script>
<script src="${pageContext.request.contextPath}/js/modernizr.js"></script>
<style type="text/css">
.width-50 {
	width: 50px;
	vertical-align: bottom;
}

.width-20 {
	width: 20px;
	vertical-align: bottom;
}

ul.judge-info li {
	display: inline-block;
	margin-right: 20px;
	min-width: 150px;
	text-align: center;
	margin-bottom: 20px;
}

label.control-label {
	float: none !important;
}

.text-align {
	text-align: center;
}
</style>
</head>

<body>
	<%@ include file="../../common/adminHeader.jsp"%>
	<%@ include file="../../common/adminMenu.jsp"%>
	<div class="span9" id="content">
		<div class="row-fluid section">
			<!-- block -->
			<div class="block">
				<div class="navbar navbar-inner block-header">
					<div class="muted pull-left">赛事配置</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">
						<div id="rootwizard">
							<div class="navbar">
								<div class="navbar-inner">
									<div class="container">
										<ul class="nav nav-pills">
											<li class=""><a href="#tab1" data-toggle="tab">配置评委</a></li>
											<li class=""><a href="#tab2" data-toggle="tab">配置晋级</a></li>
											<li class="active"><a href="#tab3" data-toggle="tab">配置奖项</a></li>
											<li class=""><a href="#tab4" data-toggle="tab">配置评分标准</a></li>
										</ul>
									</div>
								</div>
							</div>
							<div id="bar" class="progress progress-striped active">
								<div class="bar" style="width: 100%;"></div>
							</div>
							<div class="tab-content">
								<div class="tab-pane" id="tab1">
									<form class="form-horizontal">
										<fieldset>
											<ul class="judge-info">
												<s:iterator value="judgeList" var="item">
													<li><input type="checkbox" id="checkbox-6-<s:property value='#item.judgeId'/>" data-judgeid="<s:property value='#item.judgeId'/>" /> <label
														for="checkbox-6-<s:property value='#item.judgeId'/>"
													></label> <img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br> <span id="span-<s:property value='#item.judgeId'/>"><s:property
																value='#item.judgeName'
															/> </span>&#183; <span>权重</span> <select class="width-50" id="select-<s:property value='#item.judgeId'/>">
															<option selected>1</option>
															<option>2</option>
															<option>3</option>
															<option>4</option>
															<option>5</option>
														</select></li>
												</s:iterator>
											</ul>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab2">
									<form class="form-horizontal">
										<fieldset id="tab2-fieldset">
											<c:if test="${ racePromotionList==null || racePromotionList.size()==0}">
												<div class="control-group text-align promotion">
													<label class="control-label">第</label>
													<input class="width-20 focused start" type="text" value="">
													<label class="control-label">至</label>
													<input class="width-20 focused end" type="text" value="">
													<label class="control-label">晋级到</label>
													<s:select list="raceList" listValue="raceName" listKey="raceId" value=""></s:select>
													<a href="javascript:void(0);" onclick="deletePromotionBtn(this)">删除该项</a>
												</div>
											</c:if>
											<s:iterator var="promotionItem" value="racePromotionList">
												<div class="control-group text-align promotion">
													<label class="control-label">第</label>
													<input class="width-20 focused start" type="text" value="<s:property value='#promotionItem.start' />">
													<label class="control-label">至</label>
													<input class="width-20 focused end" type="text" value="<s:property value='#promotionItem.end' />">
													<label class="control-label">晋级到</label>
													<s:select list="raceList" listValue="raceName" listKey="raceId" value="%{ #promotionItem.nextId}"></s:select>
													<a href="javascript:void(0);" onclick="deletePromotionBtn(this)">删除该项</a>
												</div>
											</s:iterator>
											<a href="javascript:void(0);" onclick="addPromotionBtn(this)">新增晋级</a>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab3">
									<form class="form-horizontal">
										<fieldset id="tab3-fieldset">
											<c:if test="${raceAwardList==null || raceAwardList.size()==0 }">
												<div class="control-group text-align award">
													<label class="control-label" for="focusedInput">第</label>
													<input class="width-20 focused start" type="text" value="">
													<label class="control-label" for="focusedInput">起，共</label>
													<input class="width-20 focused count" type="text" value="">
													<label class="control-label" for="focusedInput">人,称为</label>
													<input class="input-xlarge focused awardName" type="text" value="">
													<a href="javascript:void(0);" onclick="deleteAwardBtn(this)">删除该项</a>
												</div>
											</c:if>
											<s:iterator var="awardItem" value="raceAwardList">
												<div class="control-group text-align award">
													<label class="control-label" for="focusedInput">第</label>
													<input class="width-20 focused start" type="text" value="${awardItem.start }">
													<label class="control-label" for="focusedInput">起，共</label>
													<input class="width-20 focused count" type="text" value="${awardItem.count }">
													<label class="control-label" for="focusedInput">人,称为</label>
													<input class="input-xlarge focused awardName" type="text" value="${awardItem.awardName }">
													<a href="javascript:void(0);" onclick="deleteAwardBtn(this)">删除该项</a>
												</div>
											</s:iterator>
											<a href="javascript:void(0);" onclick="addAwardBtn(this)">添加奖项</a>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab4">
									<form class="form-horizontal">
										<fieldset id="tab4-fieldset">
											<c:if test="${raceStandardList==null || raceStandardList.size()==0 }">
												<div class="control-group text-align standard">
													<label class="control-label" for="focusedInput">评分项名称</label>
													<input class="input-xlarge focused standardName" type="text" value="">
													<label class="control-label" for="focusedInput">最小值</label>
													<input class="width-20 focused min" type="text" value="">
													<label class="control-label" for="focusedInput">最大值</label>
													<input class="width-20 focused max" type="text" value="">
													<a href="javascript:void(0);" onclick="deleteStandardBtn(this)">删除该项</a>
												</div>
											</c:if>
											<s:iterator var="standardItem" value="raceStandardList">
												<div class="control-group text-align standard">
													<label class="control-label" for="focusedInput">评分项名称</label>
													<input class="input-xlarge focused standardName" type="text" value="${standardItem.standardName }">
													<label class="control-label" for="focusedInput">最小值</label>
													<input class="width-20 focused min" type="text" value="${standardItem.min }">
													<label class="control-label" for="focusedInput">最大值</label>
													<input class="width-20 focused max" type="text" value="${standardItem.max }">
													<a href="javascript:void(0);" onclick="deleteStandardBtn(this)">删除该项</a>
												</div>
											</s:iterator>
											<a href="javascript:void(0);" onclick="addStandardBtn(this)">添加评分项</a>
										</fieldset>
									</form>
								</div>
								<ul class="pager wizard">
									<li class="previous"><a href="javascript:void(0);">上一步</a></li>
									<li class="next disabled" style="display: none;"><a href="javascript:void(0);" onclick="nextClick()">下一步</a></li>
									<li class="next finish" style="display: inline;"><a href="javascript:;">完成</a></li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
			<!-- /block -->
		</div>
	</div>
	<%@ include file="../../common/adminFoot.jsp"%>
	<script type="text/javascript">
		$(function() {
			$('#rootwizard').bootstrapWizard(
					{
						onTabShow : function(tab, navigation, index) {
							var $total = navigation.find('li').length;
							var $current = index + 1;
							var $percent = ($current / $total) * 100;
							$('#rootwizard').find('.bar').css({
								width : $percent + '%'
							});
							// If it's the last tab then hide the last button and show the finish instead
							if ($current >= $total) {
								$('#rootwizard').find('.pager .next').hide();
								$('#rootwizard').find('.pager .finish').show();
								$('#rootwizard').find('.pager .finish').removeClass('disabled');
							} else {
								$('#rootwizard').find('.pager .next').show();
								$('#rootwizard').find('.pager .finish').hide();
							}
						}
					});
			$('#rootwizard .finish').click(function() {
				var raceId=${id};
				saveStandardInfo();
				location.href="${pageContext.request.contextPath}/admin/race/detail?id="+raceId;
			});
			$('#rootwizard').find("a[href*='tab1']").trigger('click');

			initJudgeInfo();
		});

		function initJudgeInfo() {
			var raceId = ${id};
			var postData = {
				"id" : raceId
			};
			var jsonData = JSON.stringify(postData);
			$
					.ajax({
						url : '${ pageContext.request.contextPath }/admin/race/raceJudgeInfo',
						type : 'POST',
						data : jsonData,
						dataType : 'json',
						contentType : 'application/json',
						success : function(data) {
							if (data.resultData != "") {
								bindJudgeInfo(data.resultData);
							}
						}
					});
		}

		function bindJudgeInfo(resultData) {
			for (var i = 0; i < resultData.length; i++) {
				var item = resultData[i];
				var judgeId = item.judgeId;
				$('#checkbox-6-' + judgeId).prop('checked', true);
				$('#span-' + judgeId).html(item.displayName);
				$('#select-' + judgeId).val(item.weight);
			}
		}

		function nextClick() {
			var targetId = $('div.tab-content > div[class="tab-pane active"]')
					.attr("id");
			switch (targetId) {
			case 'tab1':
				saveJudgeInfo();
				break;
			case 'tab2':
				savePromotionInfo();
				break;
			case 'tab3':
				saveAwardInfo();
				break;
			case 'tab4':
				saveStandardInfo();
				break;
			}
		}

		function saveJudgeInfo() {
			var items = new Array();
			var index = 0;
			var raceId = ${id};
			$('ul.judge-info >li> input[type="checkbox"]').each(
					function() {
						if ($(this).is(":checked")) {
							var _judgeId = $(this).data("judgeid");
							var weight = $(
									'ul.judge-info >li> #select-' + _judgeId)
									.val();
							var displayName = $(
									'ul.judge-info >li> #span-' + _judgeId)
									.html();
							items[index++] = {
								"raceId" : raceId,
								"judgeId" : _judgeId,
								"weight" : weight,
								"displayName" : displayName
							};
						}
					});
			var judgeList = {
				"raceJudgeList" : items
			};
			var jsonData = JSON.stringify(judgeList);

			$
					.ajax({
						url : '${ pageContext.request.contextPath }/admin/race/configJudge',
						method : 'POST',
						data : jsonData,
						dataType : 'json',
						async : false,
						contentType : 'application/json',
						success : function(data) {
							if (!data.resultData == "done") {
								alert('评委配置失败，请重试！');
							}
						}
					});
		}
		function addPromotionBtn(evt) {
			var selectOptions = $('#tab2-fieldset').find('div').last().find(
					'select').html();
			var insertHtml = '   <div class="control-group text-align promotion"> '
					+ '		<label class="control-label" >第</label>		 '
					+ '		<input class="width-20 focused start" type="text" value="">'
					+ '		<label class="control-label" >至</label>'
					+ '		<input class="width-20 focused end"  type="text" value="">'
					+ '		<label class="control-label" >晋级到</label>'
					+ '		<select>'
					+ selectOptions
					+ '</select>'
					+ '		<a href="javascript:void(0);" onclick="deletePromotionBtn(this)">删除该项</a>'
					+ '	</div>';

			$('#tab2-fieldset').find('div').last().after(insertHtml);
		}
		function deletePromotionBtn(evt) {
			//必须保留一个晋级项
			if ($('#tab2-fieldset').find('div').length > 1) {
				$(evt).parent('div').remove();
			}
		}
		function savePromotionInfo() {
			var raceId = ${id};
			var items = new Array();
			var index = 0;
			$('div.promotion').each(function() {
				var start = $(this).find('input.start').val();
				var end = $(this).find('input.end').val();
				var target = $(this).find('select').val();
				//填入空值视为无效输入
				if (start == null || start == "") {
					return true;
				}
				if (end == null || end == "") {
					return true;
				}
				var startInt = parseInt(start);
				var endInt = parseInt(end);
				//起始点不能大于终止点,否则视为无效
				if (startInt > endInt) {
					return true;
				}
				items[index++] = {
					"raceId" : raceId,
					"nextId" : target,
					"start" : start,
					"end" : end
				};

			});
			var promotionList = {
				"racePromotionList" : items
			};
			var jsonData = JSON.stringify(promotionList);

			$
					.ajax({
						url : '${ pageContext.request.contextPath }/admin/race/configPromotion',
						method : 'POST',
						data : jsonData,
						dataType : 'json',
						async : false,
						contentType : 'application/json',
						success : function(data) {
							if (!data.resultData == "done") {
								alert('晋级配置失败，请重试！');
							}
						}
					});
		}

		function saveAwardInfo() {
			var raceId = ${id};
			var items = new Array();
			var index = 0;
			$('div.award').each(function() {
				var start = $(this).find('input.start').val();
				var count = $(this).find('input.count').val();
				var awardName = $(this).find('input.awardName').val();
				//填入空值视为无效输入
				if (start == null || start == "") {
					return true;
				}
				if (count == null || count == "") {
					return true;
				}
				if (awardName == null || awardName == "") {
					return true;
				}
				var startInt = parseInt(start);
				var countInt = parseInt(count);
				//起始值和人数不能小于0,否则视为无效
				if (startInt <= 0 || countInt <= 0) {
					return true;
				}
				items[index++] = {
					"raceId" : raceId,
					"count" : count,
					"start" : start,
					"awardName" : awardName
				};
			});

			var awardList = {
				"raceAwardList" : items
			};
			var jsonData = JSON.stringify(awardList);

			$
					.ajax({
						url : '${ pageContext.request.contextPath }/admin/race/configAward',
						method : 'POST',
						data : jsonData,
						dataType : 'json',
						async : false,
						contentType : 'application/json',
						success : function(data) {
							if (!data.resultData == "done") {
								alert('奖项配置失败，请重试！');
							}
						}
					});
		}

		function addAwardBtn(evt) {
			var insertHtml = '<div class="control-group text-align award">'
					+ '        <label class="control-label" for="focusedInput">第</label>'
					+ '        <input class="width-20 focused start" type="text" value="">'
					+ '        <label class="control-label" for="focusedInput">起，共</label>'
					+ '        <input class="width-20 focused count" type="text" value="">'
					+ '        <label class="control-label" for="focusedInput">人,称为</label>'
					+ '        <input class="input-xlarge focused awardName" type="text" value="">'
					+ '		  <a href="javascript:void(0);" onclick="deleteAwardBtn(this)">删除该项</a>'
					+ '</div>';

			$('#tab3-fieldset').find('div').last().after(insertHtml);
		}
		function deleteAwardBtn(evt) {
			//必须保留一个奖项
			if ($('#tab3-fieldset').find('div').length > 1) {
				$(evt).parent('div').remove();
			}
		}
		function saveStandardInfo() {
			var raceId = ${id};
			var items = new Array();
			var index = 0;
			$('div.standard').each(function() {
				var standardName = $(this).find('input.standardName').val();
				var max = $(this).find('input.max').val();
				var min = $(this).find('input.min').val();
				//填入空值视为无效输入
				if (max == null || max == "") {
					return true;
				}
				if (min == null || min == "") {
					return true;
				}
				if (standardName == null || standardName == "") {
					return true;
				}
				var maxInt = parseInt(max);
				var minInt = parseInt(min);
				//最大值不能小于最小值,否则视为无效
				if (maxInt <= minInt) {
					return true;
				}
				items[index++] = {
					"raceId" : raceId,
					"max" : max,
					"min" : min,
					"standardName" : standardName
				};
			});

			var standardList = {
				"raceStandardList" : items
			};
			var jsonData = JSON.stringify(standardList);

			$
					.ajax({
						url : '${ pageContext.request.contextPath }/admin/race/configStandard',
						method : 'POST',
						data : jsonData,
						dataType : 'json',
						async : false,
						contentType : 'application/json',
						success : function(data) {
							if (!data.resultData == "done") {
								alert('评分项配置失败，请重试！');
							}
						}
					});
		}

		function addStandardBtn(evt) {
			var insertHtml = '<div class="control-group text-align standard">'
					+ '        <label class="control-label" for="focusedInput">评分项名称</label>'
					+ '        <input class="input-xlarge focused standardName" type="text" value="">'
					+ '        <label class="control-label" for="focusedInput">最小值</label>'
					+ '        <input class="width-20 focused min" type="text" value="">'
					+ '        <label class="control-label" for="focusedInput">最大值</label>'
					+ '        <input class="width-20 focused max" type="text" value="">'
					+ '		  <a href="javascript:void(0);" onclick="deleteStandardBtn(this)">删除该项</a>'
					+ '</div>';

			$('#tab4-fieldset').find('div').last().after(insertHtml);
		}
		function deleteStandardBtn(evt) {
			//必须保留一个奖项
			if ($('#tab4-fieldset').find('div').length > 1) {
				$(evt).parent('div').remove();
			}
		}
	</script>
</body>

</html>