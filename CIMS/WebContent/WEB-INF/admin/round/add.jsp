<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    
    <head>
        <title>添加赛事</title>
        <!-- Bootstrap -->
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/bootstrap-responsive.min.css" rel="stylesheet" media="screen">
        <link href="${pageContext.request.contextPath}/css/admin/styles.css" rel="stylesheet" media="screen">
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
                                <div class="muted pull-left">添加赛事</div>
                            </div>
                            <div class="block-content collapse in">
                                <div class="span12">
                                    <form class="form-horizontal" method="post" action="${pageContext.request.contextPath }/admin/race/add" >
                                      <fieldset>
                                        <legend>赛事信息</legend>
                                        <div class="control-group">
                                          <label class="control-label" for="name">赛事名称 </label>
                                          <div class="controls">
                                            <input type="text" name="race.raceName" class="default" required="required" id="name" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="round">赛事轮次</label>
                                          <div class="controls">
                                            <input type="text" name="race.roundId" class="default" required="required" id="round" >
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="host">主办方</label>
                                          <div class="controls">
                                            <input type="text" class="default" name="race.host" id="host" required="required">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="startTime">开始时间</label>
                                          <div class="controls">
                                            <input type="text" class="default" name="race.startTime" id="startTime" required="required">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="qualification">参赛资格</label>
                                          <div class="controls">
                                            <input type="text" class="default" name="race.qualification" id="qualification" required="required">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="place">举办地点</label>
                                          <div class="controls">
                                            <input type="text" name="race.place" class="default" id="place">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="judgePattern">评分模式</label>
                                          <div class="controls">
                                            <input type="text" name="race.judgePattern" class="default" id="judgePattern">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="voteTime">投票时长</label>
                                          <div class="controls">
                                            <input type="text" name="race.voteTime" class="default" id="voteTime">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="drawPattern">抽签模式</label>
                                          <div class="controls">
                                            <input type="text" name="race.drawPattern" class="default" id="drawPattern">
                                          </div>
                                        </div>
                                        <div class="control-group">
                                          <label class="control-label" for="eraseGroup">是否抹去分组标志</label>
                                          <div class="controls">
                                            <input type="text" name="race.eraseGroup" class="default" id="eraseGroup">
                                          </div>
                                        </div>
                                       
                                        <div class="control-group">
                                          <label class="control-label" for="textarea2">赛事简介</label>
                                          <div class="controls">
                                            <textarea class="input-xlarge textarea" name="race.description" placeholder="Enter text ..." style="width: 98%; height: 200px"></textarea>
                                          </div>
                                        </div>
                                        <div class="form-actions" >
                                          <button type="submit" class="btn btn-primary" onclick="validate()">提&nbsp;&nbsp;&nbsp;&nbsp;交</button>
                                          <a href="${pageContext.request.contextPath }/admin/race/list"><button type="button" class="btn" style="margin-left: 50px;">放弃添加</button></a>
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
				imgSrc: '${pageContext.request.contextPath}/images/sys/default_avatar.png'
			};
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
			});
			$('#btnCrop').on('click', function(){
				var img = cropper.getDataURL();
				$('.cropped').html('');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:64px;margin-top:4px;border-radius:64px;box-shadow:0px 0px 12px #7E7E7E;" ><p>64px*64px</p>');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:128px;margin-top:4px;border-radius:128px;box-shadow:0px 0px 12px #7E7E7E;"><p>128px*128px</p>');
				$('.cropped').append('<img src="'+img+'" align="absmiddle" style="width:180px;margin-top:4px;border-radius:180px;box-shadow:0px 0px 12px #7E7E7E;"><p>180px*180px</p>');
				
			});
			$('#btnZoomIn').on('click', function(){
				cropper.zoomIn();
			});
			$('#btnZoomOut').on('click', function(){
				cropper.zoomOut();
			});
			setTimeout(triggerCrop, 300);
		});	
		function triggerCrop(){
			$('#btnCrop').trigger('click');
		}
		function validate(){
			var name=$("#name").val();
			var passA=$("#password").val();
			var passB=$("#password_confirm").val();
			if(name==null||passA==null||passB==null){
				alert("姓名密码不能为空");
			}
			if(passA!=passB){
				alert("密码输入不一致");
			}
			return false;
		}
	</script>
</html>