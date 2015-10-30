<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

.input-style {
	display: block;
	height: 30px;
	background: transparent;
	border: 1px solid rgba(255, 255, 255, 0.6);
	border-radius: 2px;
	color: #fff;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 400;
	padding: 4px;
	width: 250px;
	margin: 20px 0px;
}

a.myButton:hover {
	background: #0986A2;
}

.myButton {
	display: block;
	width: 250px;
	height: 35px;
	background: #96A588;
	border: 1px solid #fff;
	cursor: pointer;
	border-radius: 2px;
	color: white;
	font-family: 'Exo', sans-serif;
	font-size: 16px;
	font-weight: 600;
	padding: 6px;
	margin-top: 20px;
	vertical-align: middle;
	text-align: center;
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
#banner-wrapper{
    width: 930px;
    background-color: aliceblue;
    height: 300px;
    margin: 0 auto;
    padding-right: 20px;
}
</style>
</head>
<body>
	<div id="div-container">
		<div id="header-wrapper">
			<img alt="logo" id="logoImage" src="${pageContext.request.contextPath }/images/main/logo.png">
			<div class="title-main">
				第五届电子科学与技术-科技创新比赛
			</div>
			<div class="title-subhead">
					
			</div>
		</div>
		<div id="banner-wrapper">
			<div id="banner">
				<img alt="order" src="${pageContext.request.contextPath }/images/main/num.png">
				<div class="order-info">
					<ul>
						<li>张三枫</li>	
						<li>武当山</li>	
						<li>太极拳</li>	
						<li>89.09</li>	
					</ul>
				</div>
			</div>
		</div>
		<div id="footer-wrapper">
			<div class="container">
				<div class="row">
					<div class="12u">

						<div id="copyright">&copy; 郑州大学. | 设计: CIMS团队</div>

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