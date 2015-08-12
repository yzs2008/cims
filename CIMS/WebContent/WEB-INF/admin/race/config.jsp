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
											<li class="">
												<a href="#tab1" data-toggle="tab">配置评委</a>
											</li>
											<li class="">
												<a href="#tab2" data-toggle="tab">配置晋级</a>
											</li>
											<li class="active">
												<a href="#tab3" data-toggle="tab">配置奖项</a>
											</li>
											<li class="">
												<a href="#tab4" data-toggle="tab">配置评分标准</a>
											</li>
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
													<li>
														<input type="checkbox" id="checkbox-6-<s:property value='#item.judgeId'/>"  data-judgeid="<s:property value='#item.judgeId'/>"/>
														<label for="checkbox-6-<s:property value='#item.judgeId'/>"></label> <img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
														<span id="span-<s:property value='#item.judgeId'/>"><s:property value='#item.judgeName' /> </span>&#183; <span>权重</span>
														<select class="width-50" id="select-<s:property value='#item.judgeId'/>">
															<option selected>1</option>
															<option>2</option>
															<option>3</option>
															<option>4</option>
															<option>5</option>
														</select>
													</li>
												</s:iterator>
											</ul>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab2">
									<form class="form-horizontal">
										<fieldset id="tab2-fieldset">
											<s:iterator var="promotionItem" value="racePromotionList">
												<div class="control-group text-align promotion">
													<label class="control-label" >第</label>
													<input class="width-20 focused start" type="text" value="<s:property value='#promotionItem.start' />">
													<label class="control-label" >至</label>
													<input class="width-20 focused end"  type="text" value="<s:property value='#promotionItem.end' />">
													<label class="control-label" >晋级到</label>
													<s:select list="raceList" listValue="raceName" listKey="raceId" value="%{ #promotionItem.nextId}"></s:select>
													<a href="javascript:void(0);" onclick="deletePromotionBtn(this)">删除晋级</a>
												</div>
											</s:iterator>
											<a href="javascript:void(0);" onclick="addPromotionBtn(this)">新增晋级</a>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab3">
									<form class="form-horizontal">
										<fieldset>
											<div class="control-group text-align">
												<label class="control-label" for="focusedInput">第</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">起，共</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">人,称为</label>
												<input class="input-xlarge focused" id="focusedInput" type="text" value="">
											</div>
											<div class="control-group text-align">
												<label class="control-label" for="focusedInput">第</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">起，共</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">人,称为</label>
												<input class="input-xlarge focused" id="focusedInput" type="text" value="">
											</div>
											<div class="control-group text-align">
												<label class="control-label" for="focusedInput">第</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">起，共</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">人,称为</label>
												<input class="input-xlarge focused" id="focusedInput" type="text" value="">
											</div>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab4">
									<form class="form-horizontal">
										<fieldset>
											<div class="control-group">
												<label class="control-label" for="focusedInput">公司</label>
												<div class="controls">
													<input class="input-xlarge focused" id="focusedInput" type="text" value="">
												</div>
											</div>
											<div class="control-group">
												<label class="control-label" for="focusedInput">Contact Name</label>
												<div class="controls">
													<input class="input-xlarge focused" id="focusedInput" type="text" value="">
												</div>
											</div>
											<div class="control-group">
												<label class="control-label" for="focusedInput">Contact Phone</label>
												<div class="controls">
													<input class="input-xlarge focused" id="focusedInput" type="text" value="">
												</div>
											</div>
										</fieldset>
									</form>
								</div>
								<ul class="pager wizard">
									<li class="previous">
										<a href="javascript:void(0);">上一步</a>
									</li>
									<li class="next disabled" style="display: none;">
										<a href="javascript:void(0);" onclick="nextClick()">下一步</a>
									</li>
									<li class="next finish" style="display: inline;">
										<a href="javascript:;">完成</a>
									</li>
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
				alert('Finished!, Starting over!');
				$('#rootwizard').find("a[href*='tab1']").trigger('click');
			});
			$('#rootwizard').find("a[href*='tab2']").trigger('click');
			
			initJudgeInfo();
		});
		
		function initJudgeInfo(){
			var raceId=1;//TODO
			var postData={"id":raceId};
			var jsonData=JSON.stringify(postData);
			$.ajax({
				url:'${ pageContext.request.contextPath }/admin/race/raceJudgeInfo',
				type:'POST',
				data:jsonData,
				dataType:'json',
				contentType: 'application/json',
				success:function(data){
					if(data.resultData!=""){
						bindJudgeInfo(data.resultData);	
					}	
				}
			});
		}
		
		function bindJudgeInfo(resultData){
			for(var i=0;i<resultData.length;i++){
				var item=resultData[i];
				var judgeId=item.judgeId;
				$('#checkbox-6-'+judgeId).prop('checked',true);
				$('#span-'+judgeId).html(item.displayName);
				$('#select-'+judgeId).val(item.weight);
			}	
		}
		
		function nextClick() {
			var targetId = $('div.tab-content > div[class="tab-pane active"]').attr("id");
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
			var items=new Array();
			var index=0;
			var raceId=1;//TODO
			$('ul.judge-info >li> input[type="checkbox"]').each(function(){
				if($(this).is(":checked")){
					var _judgeId=$(this).data("judgeid");
					var weight=$('ul.judge-info >li> #select-'+_judgeId).val();
					var displayName=$('ul.judge-info >li> #span-'+_judgeId).html();
					items[index++]={"raceId":raceId,"judgeId":_judgeId,"weight":weight,"displayName":displayName};
				}
			});
			var judgeList={"raceJudgeList":items};
			var jsonData = JSON.stringify(judgeList);
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/admin/race/configJudge',
				method:'POST',
				data:jsonData,
				dataType:'json',
				async:false,
				contentType: 'application/json',
				success:function(data){
					if(!data.resultData=="done"){
						alert('评委配置失败，请重试！');	
					}	
				}
			});
		}
		function addPromotionBtn(evt){
	        var selectOptions=$('#tab2-fieldset').find('div').last().find('select').html();
			var insertHtml =	'   <div class="control-group text-align promotion"> '																			
                               +'		<label class="control-label" >第</label>		 '
                               +'		<input class="width-20 focused start" type="text" value="">'
                               +'		<label class="control-label" >至</label>'
                               +'		<input class="width-20 focused end"  type="text" value="">'
                               +'		<label class="control-label" >晋级到</label>'
                               +'		<select>'+selectOptions+'</select>'
                               +'		<a href="javascript:void(0);" onclick="deletePromotionBtn(this)">删除晋级</a>'		
                               +'	</div>';


	         $('#tab2-fieldset').find('div').last().after(insertHtml);
		}
		function deletePromotionBtn(evt){
			//必须保留一个晋级项
			if($('#tab2-fieldset').find('div').length>1){
				$(evt).parent('div').remove();	
			}
		}
		function savePromotionInfo() {
			var raceId=1;
			var items=new Array();
			var index=0;
			$('div.promotion').each(function(){
				var start=$(this).find('input.start').val();	
				var end=$(this).find('input.end').val();
				var target=$(this).find('select').val();
				//填入空值视为无效输入
				if(start==null || start==""){
					return true;
				}
				if(end==null || end==""){
					return true;	
				}
				var startInt=parseInt(start);
				var endInt=parseInt(end);
				//起始点不能大于终止点,否则视为无效
				if(startInt>endInt){
					return true;
				}
				items[index++]={"raceId":raceId,"nextId":target,"start":start,"end":end};
				
			});	
			var promotionList={"racePromotionList":items};
			var jsonData = JSON.stringify(promotionList);
			
			$.ajax({
				url:'${ pageContext.request.contextPath }/admin/race/configPromotion',
				method:'POST',
				data:jsonData,
				dataType:'json',
				async:false,
				contentType: 'application/json',
				success:function(data){
					if(!data.resultData=="done"){
						alert('晋级配置失败，请重试！');	
					}	
				}
			});
		}
		function saveAwardInfo(){
				
		}
		function saveStandardInfo(){
			
		}
	</script>
</body>

</html>