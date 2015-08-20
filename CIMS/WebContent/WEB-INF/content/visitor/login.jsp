<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6 lt8"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7 lt8"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8 lt8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>用户登录注册</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register/demo.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register/style.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/register/animate-custom.css" />
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<header>
			<h1>
				欢迎来到CIMS <span>（Contest Intelligent Management System）</span>
			</h1>
		</header>
		<section>
			<div id="container_demo">
				<a class="hiddenanchor" id="toregister"></a> <a class="hiddenanchor" id="tologin"></a>
				<div id="wrapper">
					<div id="login" class="animate form">
						<form action="${pageContext.request.contextPath}/login" onsubmit="return login();" autocomplete="on" method="post">
							<h1>登录</h1>
							<p>
								<label for="username" class="uname" data-icon="u"> 用户名 或邮箱</label>
								<input id="username" name="userName" required="required" type="text" placeholder="用户名 或邮箱" value="yzs" />
							</p>
							<p>
								<label for="password" class="youpasswd" data-icon="p"> 密码 </label>
								<input id="password" name="password" required="required" type="password" placeholder="密码" />
							</p>
							<p class="keeplogin">
								<input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
								<label for="loginkeeping">自动登录</label>
							</p>
							<p class="login button">
								<input type="submit" value="登录" />
							</p>
							<p class="change_link">
								还没有帐号？ <a href="#toregister" class="to_register">秒注一个</a>
							</p>
						</form>
					</div>

					<div id="register" class="animate form">
						<form action="register" method="post" autocomplete="on">
							<h1>注 册</h1>
							<p>
								<label for="usernamesignup" class="uname" data-icon="u">用户名</label>
								<input id="usernamesignup" name="user.userName" required="required" type="text" placeholder="用户名" value="yzs" />
							</p>
							<p>
								<label for="emailsignup" class="youmail" data-icon="e">邮箱</label>
								<input id="emailsignup" name="user.email" required="required" type="email" placeholder="email@mail.com" value="yzs2008@yeah.net" />
							</p>
							<p>
								<label for="passwordsignup" class="youpasswd" data-icon="p">密码</label>
								<input id="passwordsignup" name="user.password" required="required" type="password" placeholder="eg. X8df!90EO" value="1" />
							</p>
							<p>
								<label for="passwordsignup_confirm" class="youpasswd" data-icon="p">确认密码</label>
								<input id="passwordsignup_confirm" required="required" type="password" placeholder="" value="1" />
							</p>
							<p class="signin button">
								<input type="submit" value="注册" />
							</p>
							<p class="change_link">
								已有账户？ <a href="#tologin" class="to_register"> 跳转登录 </a>
							</p>
						</form>
					</div>

				</div>
			</div>
			<script type="text/javascript">
				function login() {
					var userName = $("#username").val();
					var password = $("#password").val();

					if (userName == null || userName == "") {
						alert("用户名不能为空");
						return false;
					}
					if (password == null || password == "") {
						alert("登录密码不能为空");
						return false;
					}

					var postData = {
						"userName" : userName,
						"password" : password
					};
					var jsonData = JSON.stringify(postData);
					$.ajax({
						type : "POST",
						url : '${ pageContext.request.contextPath }/login',
						data : jsonData,
						dataType : 'json',
						contentType : 'application/json',
						async : false,
						success : function(data,status,req) {
							if (data.state) {
								var preUrl=req.getResponseHeader('previousUrl');
								if(preUrl!=null){
									location.href=preUrl;
								}else{
									location.href="${ pageContext.request.contextPath }/player/sign";
								}
							} else {
								alert(data.msg);
							}
						}
					});
					return false;
				}
			</script>
		</section>
	</div>
</body>
</html>