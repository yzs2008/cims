<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
<head>
<title>成绩排名</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="${pageContext.request.contextPath }/refs/judge/js/jquery.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main/style.css" />
<style type="text/css">
body {
	background-image: url(../images/main/bg.jpg);
}
#header-wrapper{
	background-image: url(../images/main/title.png);
    width: 967px;
    height: 150px;
    background-repeat: no-repeat;
    margin: 0 auto;
}


#logoImage{
    width: 150px;
    height: 144px;
    border-radius: 70px;
    margin-left: 0px;
    margin-top: 1px;
    vertical-align: middle;
}
.title-main{
	display: inline-block;
    width: 700px;
    line-height: 50px;
    text-align: center;
    font-size: 32px;
    font-weight: bolder;
    font-family: 华文北魏;
    color:gold;
}
.title-subhead{
    position: relative;
    display: inline-block;
    left: 160px;
    top: -40px;
}
.title-subhead ul{
    padding: 0px;
    margin: 0px;	
}
.title-subhead ul li{
	display: inline-block;
    line-height: 38px;
    font-size: 20px;
    font-weight: 800;
	color: #A4150F;
}
#banner-wrapper{
    width: 830px;
    height: auto;
    margin: 0 auto;
    min-height: 440px;
}
div.order-info{
    display: inline-block;
    background-color: #E50D06;
    height: 38px;

}
div.order-info ul{
    padding: 0px;
    margin: 0px;	
}
div.order-info ul li{
	display: inline-block;
    line-height: 38px;
    font-size: 20px;
    font-weight: 800;
    color: white;
}
.banner-img{
	vertical-align: middle;
}
div.order-num-div{
	display: inline-block;
    width: 60px;
    height: 37px;
    margin: 0px;
    padding: 0px;
    position: relative;
}
.order-num-span{
	position: absolute;
    top: -2px;
    left: 20px;
    font-size: 35px;
    font-weight: 900;
    color: red;
}
.order-num-span2{
	position: absolute;
    top: -2px;
    left: 12px;
    font-size: 35px;
    font-weight: 900;
    color: red;
}
.copyright{
    margin: 0 auto;
    width: 987px;
    text-align: center;
    padding-top: 10px;
    font-size: 12px;
}
</style>
</head>
<body>
	<div id="div-container">
		<div id="header-wrapper">
			<img alt="logo" id="logoImage" src="${pageContext.request.contextPath }/images/main/logo.png">
			<div class="title-main">
				${srace.raceName }
			</div>
			<div class="title-subhead">
					<ul>
						<li style="width:150px;">选手</li>	
						<li style="width:210px;">单位</li>	
						<li style="width:278px;">作品名称</li>	
						<li style="width:100px;">奖项</li>	
					</ul>
			</div>
		</div>
		<div id="banner-wrapper">
			<s:iterator value="itemList" var="item" status="index">
			<div class="item-banner">
				<div class="order-num-div">
					<img alt="order" class="banner-img" src="${pageContext.request.contextPath }/images/main/num.png">
					<s:if test="#index.index>=9 ">
						<span class="order-num-span2">${index.index+1 }</span>
					</s:if>
					<s:if test="#index.index<9 ">
						<span class="order-num-span">${index.index+1 }</span>
					</s:if>
				</div>
				<div class="order-info">
					<ul>
						<li style="width:150px;">${item.player.realName }</li>	
						<li style="width:210px;">${item.player.unit }</li>	
						<li style="width:278px;">${item.production.productName }</li>	
						<li style="width:100px;">${item.award }</li>	
					</ul>
				</div>
			</div>
			
			</s:iterator>
			</div>
		</div>
		<div id="footer-wrapper">
			<div class="container">
				<div class="row">
					<div class="copyright">

						<div id="copyright">&copy; 麦兜故事. | 设计开发:麦兜故事工作室 </div>
						<div>豫ICP证0371号</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		function judgeLogin() {
			var name = $("#name").val();
			var password = $("#password").val();

			if (name == null || name.trim() == "" || password == null || password.trim() == "") {
				alert("请输入用户名和密码");
				return;
			}

			var postData = {
				"userName" : name,
				"password" : password
			};
			var jsonData = JSON.stringify(postData);
			$.ajax({
				type : "POST",
				url : '${ pageContext.request.contextPath }/judge/login',
				data : jsonData,
				dataType : 'json',
				contentType : 'application/json',
				async : false,
				success : function(data) {
					if (data.state) {
						location.href = "${ pageContext.request.contextPath }/judge/racelist";
					} else {
						alert(data.msg);
					}
				}
			});
		}
	</script>
</body>
</html>