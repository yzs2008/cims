<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>添加轮次</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	
        <style>
        	#yes-span,#no-span{
        	  	margin-right: 30px;
  				margin-left: 5px;
  				line-height: 30px;
        	}
        </style>
    </head>
    
    <body>
		<%@ include file="../../common/adminHeader.jsp" %>
		<%@ include file="../../common/adminMenu.jsp" %>
                <!--/span-->
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                     <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">添加轮次</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/round/add"  onsubmit="return validate();">
                                      <fieldset>
                                        <legend>轮次信息</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="name">轮次名称 </label>
                                          <div class="controls">
                                            <input type="text" name="round.roundName" class="default" required="required" id="name" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="round">上级轮次</label>
                                          <div class="controls">
                                          	<select id="round-list" name="round.parent" onchange="setRoundName()">
                                          		<c:forEach var="item" items="${ roundList}">
                                          			<option value="${item.roundId}">${item.roundName}</option>	
                                          		</c:forEach>
                                          	</select>
                                          	<input type="hidden" id="round-parentName" name="round.parentName">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="eraseGroup">是否包含子轮次</label>
                                          <div class="controls">
                                            <input type="radio" name="round.hasNode" value="true" checked="checked"><span id="yes-span" >是</span>
                                            <input type="radio" name="round.hasNode" value="false"><span id="no-span" >否</span>
                                          </div>
                                        </div>
                                       
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">轮次简介</label>
                                          <div class="controls">
                                            <textarea class="input-xlarge textarea" name="round.description" placeholder="Enter text ..." style="width: 98%; height: 200px"></textarea>
                                          </div>
                                        </div>
                                        <div class="form-actions" >
                                          <button type="submit" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                                          <a href="${pageContext.request.contextPath }/admin/round/list"><button type="button" class="btn" style="margin-left: 50px;">放弃添加</button></a>
                                        </div>
                                      </fieldset>
                                    </form>

                                </div>
                            </div>
                        </div>
                        <!-- /block -->
                    </div>
		    </div>
        <%@ include file="../../common/adminFoot.jsp" %>
    </body>
	<script type="text/javascript">
		$(function(){
			setRoundName();
		});
		function setRoundName(){
			var parentName=$('#round-list option:selected').text();
			$("#round-parentName").val(parentName);
		}
		function checkRoundName(){
			var accept=false;
			var name=$("#name").val();
			if(name==null||name==""){
				return accept;	
			}else{
				var postData="roundName="+name;
				$.ajax({
					   type: "POST",
					   url: '${ pageContext.request.contextPath }/admin/round/roundNameCheck',
					   data: postData,
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
		function validate(){
			var name=$("#name").val();
			if(name==null||name==""){
				alert("轮次名称不能为空");
				return false;
			}
			if(!checkRoundName()){
				alert("已存在该轮次，请误重复添加");	
				return false;
			}
			return true;
		}
	</script>
</html>