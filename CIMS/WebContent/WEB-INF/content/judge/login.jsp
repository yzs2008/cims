<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>评委登录页面</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="${pageContext.request.contextPath }/refs/judge/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/skel-layers.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/init.js"></script>
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/skel.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/style-desktop.css" />
</noscript>
<!--[if lte IE 9]><link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><script src="${pageContext.request.contextPath }/refs/judge/js/html5shiv.js"></script><![endif]-->

<style type="text/css">
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

::-webkit-input-placeholder { /* WebKit, Blink, Edge */
	color: #fff;
}

:-moz-placeholder { /* Mozilla Firefox 4 to 18 */
	color: #fff;
	opacity: 1;
}

::-moz-placeholder { /* Mozilla Firefox 19+ */
	color: #fff;
	opacity: 1;
}

:-ms-input-placeholder { /* Internet Explorer 10-11 */
	color: #909;
}
</style>
</head>
<body>
	<div id="header-wrapper">
		<div class="container">
			<div class="row">
				<div class="12u">

					<header id="header">
						<h1 style="text-align: center; width: 90%;">
							<a href="javascript:void(0);" id="logo">欢迎使用CIMS评分系统</a>
						</h1>
					</header>

				</div>
			</div>
		</div>
	</div>
	<div id="banner-wrapper">
		<div class="container">

			<div id="banner">
				<div style="text-align: left; width: 260px; margin: 0 auto; min-width: 260px; padding-top: 30px;">
					<input id="name" type="text" placeholder="用户名" class="input-style" />
					<input id="password" type="text" placeholder="密码" class="input-style" />
					<a class="myButton" href="javascript:void(0);" onclick="judgeLogin()">评 委 登 录</a>
				</div>
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
						location.href="${ pageContext.request.contextPath }/judge/racelist";
					} else {
						alert(data.msg);
					}
				}
			});
		}
	</script>
</body>
</html>