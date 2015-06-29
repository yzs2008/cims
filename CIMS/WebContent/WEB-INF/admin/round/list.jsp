<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>

<head>
<title>轮次管理</title>
<!-- Bootstrap -->
<link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/easyui.css" rel="stylesheet" media="screen">
<link href="${pageContext.request.contextPath}/css/admin/icon.css" rel="stylesheet" media="screen">
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
<script src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
<style type="text/css">
label {
	display: inline-block;
	margin-bottom: 5px;
	margin-right: 10px;
}

select, textarea, input[type="text"] {
	margin-bottom: 0px;
}
.title-bold{
	font-weight: bold;
}
.content-underline{
	text-decoration: underline;
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
					<div class="muted pull-left">轮次信息</div>
				</div>
				<div class="block-content collapse in">
					<div class="span12">

						<table class="table table-striped table-bordered" style="vertical-align: middle; min-height: 450px;" id="tableInfo">
							<thead>
								<tr>
									<th>轮次结构</th>
									<th>轮次信息</th>
								</tr>
							</thead>
							<tbody>
								<tr class="gradeX">
									<td style="width: 60%;">
										<div style="padding: 5px;">
											<ul class="easyui-tree" id="roundTree"></ul>
										</div>
									</td>
									<td>
										<form method="post" action="${pageContext.request.contextPath }/admin/round/update">
											<div class="control-group">
												<label class="control-label title-bold" for="round-name">轮次名称:</label> <span id="round-name" class="content-underline">轮次名称我是第一轮</span> 
											</div>
											<div class="control-group">
												<label class="control-label title-bold" for="round-parent">上级轮次:</label> <span id="round-parent" class="content-underline">上级轮次名称</span>
											</div>
											<div class="control-group">
												<label class="control-label title-bold" for="round-hasnode">是否可包含子轮次:</label> <span id="round-hasnode" class="content-underline">是</span> 
											</div>
											<div class="control-group">
												<label class="control-label title-bold" for="round-description">轮次简介:</label>
												<div class="controls">
													<p id="round-description" class="content-underline">轮次简介</p>
												</div>
											</div>
											<div class="form-actions">
												<button type="submit" id="btn-edit" data-id="" class="btn btn-primary" onclick="edit(this)">编辑</button>
												<button type="submit" id="btn-delete" data-id="" class="btn btn-primary" onclick="_delete(this)">删除</button>
												<button type="submit" id="btn-add" data-id="" class="btn btn-primary" onclick="add(this)">添加子轮次</button>
											</div>
										</form>
									</td>
								</tr>
							</tbody>
						</table>
					</div>
				</div>
				<!-- /block -->
			</div>
		</div>
	</div>
	<%@ include file="../../common/adminFoot.jsp"%>
	<script type="text/javascript">
		$(function() {
			$.ajax({
				   type: "GET",
				   url: '${ pageContext.request.contextPath }/admin/round/roundListJson',
				   success: function(data){
					   bindRoundTree(data.resultData);
				   }
				});
		});
		
		function bindRoundTree(jsonData){
			var treeDataArray={"treeData":[]};
			treeDataArray.treeData[0]=traverse(jsonData);
			
			$("#roundTree")
					.tree(
							{
								"data":treeDataArray.treeData,
								"animate" : true,
								"lines" : true,
								onClick:function(node){
									getData(node.id);
								}
							});
		}
		function traverse(node){
			var output={
				"id":node.round.roundId,
				"text":node.round.roundName,
				"iconCls":"icon-add",
				"state":"open",
				"children":[]
			};	
			for(var i=0;i<node.children.length;i++){
				output.children[i]=traverse(node.children[i]);	
			}
			return output;
		}
		function getData(id){
			var param="id="+id;
			$.ajax({
				   type: "POST",
				   url: '${ pageContext.request.contextPath }/admin/round/roundInfo',
				   data: param,
				   success: function(data){
					   bindData(data.resultData);
				   }
				});
		}
		function bindData(data){
			$("#round-name").text(data.roundName);
			$("#round-description").text(data.description);
			$("#round-parent").text(data.parentName);

			$("#btn-add").data(data.id);
			$("#btn-edit").data(data.id);
			$("#btn-delete").data(data.id);
			
			var hasNode="是";
			if(!data.hasNode){
				hasNode="不是";	
				$("#btn-add").css();
			}
			$("#round-hasnode").text(hasNode);
			
		}	
		function edit(evt) {
			var id = $(evt).data("id");
			window.location.href = "${ pageContext.request.contextPath }/edit?id=" + id;
		}
		function _delete(evt) {
			var id = $(evt).data("id");
			window.location.href = "deleted?id=" + id;
		}
		function add(evt) {
			var id = $(evt).data("id");
			window.location.href = "add?id=" + id;
		}
	</script>
</body>
</html>