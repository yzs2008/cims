<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>编辑轮次</title>
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
                                <div class="muted pull-left">编辑轮次</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/round/update"  onsubmit="return validate();">
                                      <fieldset>
                                        <legend>轮次信息</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="name">轮次名称 </label>
                                          <div class="controls">
                                            <input type="text" name="round4update.roundName" class="default" required="required" id="name" value="${round4update.roundName }">
                                            <input type="hidden" name="round4update.roundId" class="default"  id="round-id" value="${round4update.roundId }">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="round">上级轮次</label>
                                          <div class="controls">
                                          	<select id="round-list" name="round4update.parent" onchange="setRoundName()">
                                          		<c:forEach var="item" items="${ roundList}">
                                          			<c:if test="${round4update.parent==item.roundId }">
                                          				<option value="${item.roundId}" selected>${item.roundName}</option>	
                                          			</c:if>
                                          			<c:if test="${round4update.parent !=item.roundId }">
                                          				<option value="${item.roundId}">${item.roundName}</option>	
                                          			</c:if>
                                          			
                                          		</c:forEach>
                                          	</select>
                                          	<input type="hidden" id="round-parentName" name="round4update.parentName" value="${ round4update.parentName}">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="eraseGroup">是否包含子轮次</label>
                                          <div class="controls">
                                          	<c:if test="${round4update.hasNode }">
	                                            <input type="radio" name="round4update.hasNode" value="true" checked="checked"><span id="yes-span" >是</span>
	                                            <input type="radio" name="round4update.hasNode" value="false"><span id="no-span" >否</span>
                                          	</c:if>
                                          	<c:if test="${!round4update.hasNode }">
	                                            <input type="radio" name="round4update.hasNode" value="true" ><span id="yes-span" >是</span>
	                                            <input type="radio" name="round4update.hasNode" value="false" checked="checked"><span id="no-span" >否</span>
                                          	</c:if>
                                          </div>
                                        </div>
                                       
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">轮次简介</label>
                                          <div class="controls">
                                            <textarea class="input-xlarge textarea" name="round4update.description" placeholder="Enter text ..." style="width: 98%; height: 200px">${round4update.description }</textarea>
                                          </div>
                                        </div>
                                        <div class="form-actions" >
                                          <button type="submit" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                                          <a href="${pageContext.request.contextPath }/admin/round/list"><button type="button" class="btn" style="margin-left: 50px;">放弃编辑</button></a>
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
		var message="";
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
			var hasNode=$('input[name="round4update.hasNode"]:checked').val();
			var id=$('#round-id').val();
			if(name==null||name==""){
				return accept;	
			}else{
				var postData="roundName="+name+"&hasNode="+hasNode+"&id="+id;
				$.ajax({
					   type: "POST",
					   url: '${ pageContext.request.contextPath }/admin/round/roundNameCheck4update',
					   data: postData,
					   async:false,
					   success: function(data){
						   if(data.resultData){
							   accept =true;
							   message="";
						   }else{
							   accept= false;
							   message=data.message;
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
				alert(message);	
				return false;
			}
			return true;
		}
	</script>
</html>