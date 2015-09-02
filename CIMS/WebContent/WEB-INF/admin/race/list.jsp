<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>管理赛事</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/DT_bootstrap.css" rel="stylesheet" media="screen">
        <script src="${pageContext.request.contextPath}/js/modernizr-2.6.2-respond-1.1.0.min.js"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    </head>
    
    <body>
		<%@ include file="../../common/adminHeader.jsp" %>
		<%@ include file="../../common/adminMenu.jsp" %>
                <div class="span9" id="content">
                      <!-- morris stacked chart -->
                     <div class="row-fluid">
                        <!-- block -->
                        <div class="block">
                            <div class="navbar navbar-inner block-header">
                                <div class="muted pull-left">赛事基本信息</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                   <div class="table-toolbar">
                                      <div class="btn-group">
                                         <a href="${pageContext.request.contextPath }/admin/race/add"><button class="btn btn-success">新增赛事<i class="icon-plus icon-white"></i></button></a>
                                      </div>
                                      <div class="btn-group pull-right">
                                         <button data-toggle="dropdown" class="btn dropdown-toggle">扩展功能 <span class="caret"></span></button>
                                         <ul class="dropdown-menu">
                                            <li><a href="#">打印</a></li>
                                            <li><a href="#">导入赛事信息</a></li>
                                            <li><a href="#">导出Excel</a></li>
                                         </ul>
                                      </div>
                                   </div>
                                    
                                    <table  class="table table-striped table-bordered" style="vertical-align: middle;" id="tableInfo">
                                        <thead>
                                            <tr>
                                                <th>主办</th>
                                                <th>名称</th>
                                                <th>轮次</th>
                                                <th>投票时长</th>
                                                <th>抽签模式</th>
                                                <th>评分模式</th>
                                                <th>状态</th>
                                                <th>操作</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="item" items="${ raceList }" >
                                            <tr class="gradeX">
                                                <td>${item.host }</td>
                                                <td>${item.raceName }</td>
                                                <td>${item.roundId }</td>
                                                <td>${item.voteTime }</td>
                                                <td>${item.drawPattern.toString() }</td>
                                                <td>${item.judgePattern.toString() }</td>
                                                <td>${item.state.toString()}</td>
                                                <td style="min-width:95px;width:95px;">
													<a href="javascript:void(0);" data-id="${item.raceId }" onclick="detail(this)">查看</a>
													<a href="javascript:void(0);" data-id="${item.raceId }" onclick="config(this)">配置</a>
													<a href="javascript:void(0);" data-id="${item.raceId }" onclick="deleted(this)">删除</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        <!-- /block -->
                    </div>
                  </div>
		    </div>
        <%@ include file="../../common/adminFoot.jsp" %>
        <script src="${pageContext.request.contextPath}/js/jquery-1.9.1.js"></script>
        <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js"></script>
        <script src="${pageContext.request.contextPath}/js/DT_bootstrap.js"></script>
        <script type="text/javascript">
       		function detail(evt){
       			var id= $(evt).data("id");	
       			window.location.href="detail?id="+id;
       		} 
       		function deleted(evt){
       			var id=$(evt).data("id");
       			window.location.href="deleted?id="+id;
       		}
       		function config(evt){
       			var id=$(evt).data("id");
       			window.location.href="config?id="+id;
       		}
        </script>
    </body>
</html>