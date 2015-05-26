<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>添加评委</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/admin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/admin/assets/styles.css" rel="stylesheet" media="screen">
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
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
                                <div class="muted pull-left">添加评委</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/judge/add">
                                      <fieldset>
                                        <legend>评委信息</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="name">评委姓名 </label>
                                          <div class="controls">
                                            <input type="text" name="judge.judgeName" class="default" id="name" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="password">密码</label>
                                          <div class="controls">
                                            <input type="text" name="judge.password" class="default" id="password" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="password_confirm">确认密码</label>
                                          <div class="controls">
                                            <input type="text" class="default" id="password_confirm">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="optionsCheckbox">性别</label>
                                          <div class="controls">
                                          	<input id="gender_male" type="radio" name="judge.gender" checked> 
                                          	<label for="gender_male" style="display: inline-block;margin-left: 10px;">男</label>
                                          	<input id="gender_female" type="radio" name="judge.gender" style="margin-left: 50px;"> 
                                          	<label for="gender_female" style="display: inline-block;margin-left: 10px;">女</label>
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="email">电子邮箱</label>
                                          <div class="controls">
                                            <input type="text" name="judge.email" class="default" id="email">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="phone">手机号</label>
                                          <div class="controls">
                                            <input type="text" name="judge.phone" class="default" id="phone">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="fileInput">评委照片</label>
                                          <div class="controls">
                                            <input class="input-file uniform_on" id="fileInput" type="file">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">评委简介</label>
                                          <div class="controls">
                                            <textarea class="input-xlarge textarea" name="judge.intorduction" placeholder="Enter text ..." style="width: 98%; height: 200px"></textarea>
                                          </div>
                                        </div>
                                        <div class="form-actions" >
                                          <button type="submit" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                                          <a href="${pageContext.request.contextPath }/admin/judge/list"><button type="button" class="btn" style="margin-left: 50px;">放弃添加</button></a>
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

</html>