<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>添加评委</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/fileupload/style.css" rel="stylesheet" media="screen">
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/js/cropbox.js"></script>
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
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/judge/add" enctype="multipart/form-data">
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
                                          	<input id="gender_male" type="radio" value="male" name="judge.gender" checked> 
                                          	<label for="gender_male" style="display: inline-block;margin-left: 10px;">男</label>
                                          	<input id="gender_female" type="radio" value="female" name="judge.gender" style="margin-left: 50px;"> 
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
											  <!--                                           上传图片 -->
											  <label style="margin-top:6px;font-size:12px;color:#22bbcc;">提示：按住Ctrl+Shift，可以实现滚轮缩放</label>
	                                          <div class="fileupload-container">
												  <div class="imageBox">
												    <div class="thumbBox"></div>
												    <div class="spinner" style="display: none">Loading...</div>
												  </div>
												  <div class="action"> 
												    <div class="new-contentarea tc"> <a href="javascript:void(0)" class="upload-img">
												      <label for="upload-file" style="  line-height: 50px; font-size: 17px;">选择照片</label>
												      </a>
												      <input type="file"  name="avatar" id="upload-file" accept="image/gif,png,jpg,jpeg,bmp"/>
												      <input type="hidden" name="imageClipStartX"/>
												      <input type="hidden" name="imageClipStartY"/>
												      <input type="hidden" name="imageClipWidth"/>
												      <input type="hidden" name="imageClipHeight"/>
												    </div>
												    <input type="button" id="btnCrop"  class="Btnsty_peyton" value="裁切">
												    <input type="button" id="btnZoomIn" class="Btnsty_peyton" value="+"  >
												    <input type="button" id="btnZoomOut" class="Btnsty_peyton" value="-" >
												  </div>
												  <div class="cropped"></div>
												</div>
												<!--                                           上传图片 -->
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">评委简介</label>
                                          <div class="controls">
                                            <textarea class="input-xlarge textarea" name="judge.introduction" placeholder="Enter text ..." style="width: 98%; height: 200px"></textarea>
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
	<script type="text/javascript">
		$(function(){
			var options =
			{
				thumbBox: '.thumbBox',
				spinner: '.spinner',
				imgSrc: '${pageContext.request.contextPath}/images/sys/avatar.png'
			}
			var cropper = $('.imageBox').cropbox(options);
			$('#upload-file').on('change', function(){
				var reader = new FileReader();
				reader.onload = function(e) {
					options.imgSrc = e.target.result;
					cropper = $('.imageBox').cropbox(options);
				}
				reader.readAsDataURL(this.files[0]);
				this.files = [];
			})
			$('#btnCrop').on('click', function(){
				var img = cropper.getDataURL();
				$('.cropped').html('');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
				
			})
			$('#btnZoomIn').on('click', function(){
				cropper.zoomIn();
			})
			$('#btnZoomOut').on('click', function(){
				cropper.zoomOut();
			})
		});	
	</script>
</html>