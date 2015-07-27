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
label.control-label{
	float:none !important;
}
.text-align{
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
											<li class=""><a href="#tab4" data-toggle="tab">配置</a></li>
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
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
												<li>
													<input type="checkbox" id="checkbox-6-1" /><label for="checkbox-6-1"></label>
													<img alt="评委头像" class="width-50" src="${pageContext.request.contextPath }/images/judge/default.jpg"> <br>
													<span>评委名</span> 
													<span>权重</span>
													<select class="width-50">
														<option>1</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
														<option>5</option>
													</select>
												</li>
											</ul>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab2">
									<form class="form-horizontal">
										<fieldset>
											<div class="control-group text-align">
												<label class="control-label" for="focusedInput">第</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">至</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">晋级到</label>
												<select>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
												</select>
											</div>
											<div class="control-group text-align">
												<label class="control-label" for="focusedInput">第</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">至</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">晋级到</label>
												<select>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
												</select>
											</div>
											<div class="control-group text-align">
												<label class="control-label" for="focusedInput">第</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">至</label>
												<input class="width-20 focused" id="focusedInput" type="text" value="">
												<label class="control-label" for="focusedInput">晋级到</label>
												<select>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
													<option>总决赛</option>
												</select>
											</div>
										</fieldset>
									</form>
								</div>
								<div class="tab-pane" id="tab3">
									<form class="form-horizontal">
										<fieldset>
											<div class="control-group">
												<label class="control-label" for="focusedInput">Company Name</label>
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
									<li class="previous"><a href="javascript:void(0);">上一步</a></li>
									<li class="next disabled" style="display: none;"><a href="javascript:void(0);">下一步</a></li>
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
								$('#rootwizard').find('.pager .finish')
										.removeClass('disabled');
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
			$('#rootwizard').find("a[href*='tab1']").trigger('click');
		});
	</script>
</body>

</html>