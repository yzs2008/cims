<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>更新评委信息</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/admin/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/admin/bootstrap/css/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/admin/assets/styles.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/fileupload/style.css" rel="stylesheet" media="screen">
        <!--[if lte IE 8]><script language="javascript" type="text/javascript" src="${pageContext.request.contextPath}/admin/vendors/flot/excanvas.min.js"></script><![endif]-->
        <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
        <!--[if lt IE 9]>
            <script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
        <![endif]-->
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/vendors/jquery-1.11.1.min.js"></script>
        <script type="text/javascript" src="${pageContext.request.contextPath}/admin/vendors/cropbox.js"></script>
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
                                <div class="muted pull-left">更新评委信息</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/judge/update" enctype="multipart/form-data">
                                      <fieldset>
                                        <legend>评委信息</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="name">评委姓名 </label>
                                          <div class="controls">
                                          	<span style="line-height:30px;">${judge.judgeName }</span>
                                          	<input type="hidden" name="judge4update.judgeName"  value="${judge.judgeName }">
                                          	<input type="hidden" name="judge4update.judgeId" value="${judge.judgeId }"> 
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="password">密码</label>
                                          <div class="controls">
                                            <input type="text" name="judge4update.password" class="default" value="${judge.password }" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="email">电子邮箱</label>
                                          <div class="controls">
                                            <input type="text" name="judge4update.email" class="default" value="${judge.email }">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="phone">手机号</label>
                                          <div class="controls">
                                            <input type="text" name="judge4update.phone" class="default" id="phone" value="${judge.phone }">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="fileInput">评委照片</label>
                                          <div class="controls">
											  <!--                                           上传图片 -->
											  <label style="margin-top:6px;font-size:12px;color:#22bbcc;">提示：按住Ctrl+Shift，可以实现滚轮缩放</label>
											  <input type="hidden" name="judge4update.avatar" value="${judge.avatar }">
											  <input type="hidden" name="changeAvatarFlag" id="changeAvatarFlag" value="1">
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
                                            <textarea class="input-xlarge textarea" name="judge4update.introduction" style="width: 98%; height: 200px">${judge.introduction }</textarea>
                                          </div>
                                        </div>
                                        <div class="form-actions" >
                                          <button type="submit" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                                          <a href="${pageContext.request.contextPath }/admin/judge/list"><button type="button" class="btn" style="margin-left: 50px;">放弃更新</button></a>
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
				imgSrc: '${pageContext.request.contextPath }${judge.avatar}'
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
				setTimeout(triggerCrop, 300);
				$("#changeAvatarFlag").val(2);	
			})
			$('#btnCrop').on('click', function(){
				var img = cropper.getDataURL();
				$('.cropped').html('');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
				
				$("#changeAvatarFlag").val(2);	
			})
			$('#btnZoomIn').on('click', function(){
				cropper.zoomIn();
			})
			$('#btnZoomOut').on('click', function(){
				cropper.zoomOut();
			})
			setTimeout(triggerCrop, 300);
		});	
		function triggerCrop(){
			$('#btnCrop').trigger('click');
			$("#changeAvatarFlag").val(1);	
		}
	</script>
</html>