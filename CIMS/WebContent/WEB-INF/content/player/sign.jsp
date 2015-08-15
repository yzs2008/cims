<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>Astral by HTML5 UP</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<!--[if lte IE 8]><script src="${pageContext.request.contextPath }/refs/player/assets/js/ie/html5shiv.js"></script><![endif]-->
		<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/player/assets/css/main.css" />
		<noscript><link rel="stylesheet" href="${pageContext.request.contextPath }/refs/player/assets/css/noscript.css" /></noscript>
		<!--[if lte IE 8]><link rel="stylesheet" href="${pageContext.request.contextPath }/refs/player/assets/css/ie8.css" /><![endif]-->
	</head>
	<body>

		<!-- Wrapper-->
			<div id="wrapper">

				<!-- Nav -->
					<nav id="nav">
						<a href="#user" class="icon fa-user active"><span>个人信息</span></a>
						<a href="#race" class="icon fa-flag"><span>报名参赛</span></a>
						<a href="#work" class="icon fa-folder"><span>作品信息</span></a>
						<a href="#contact" class="icon fa-envelope"><span>注意事项</span></a>
					</nav>

				<!-- Main -->
					<div id="main">

						<!-- Me -->
							<article id="user" class="panel">
								<header>
									<h2>个人信息</h2>
								</header>
								<form action="#" method="post">
									<div>
										<div class="row">
											<div class="6u 12u$(mobile)">
												<input type="text" name="name" placeholder="Name" />
											</div>
											<div class="6u$ 12u$(mobile)">
												<input type="text" name="email" placeholder="Email" />
											</div>
											<div class="12u$">
												<input type="text" name="subject" placeholder="Subject" />
											</div>
											<div class="12u$">
												<textarea name="message" placeholder="Message" rows="8"></textarea>
											</div>
											<div class="12u$">
												<input type="submit" value="Send Message" />
											</div>
										</div>
									</div>
								</form>
							</article>

						<!-- Work -->
							<article id="work" class="panel">
								<header>
									<h2>Work</h2>
								</header>
								<p>
									Phasellus enim sapien, blandit ullamcorper elementum eu, condimentum eu elit.
									Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia
									luctus elit eget interdum.
								</p>
								<section>
									<div class="row">
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic01.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic02.jpg" alt=""></a>
										</div>
										<div class="4u$ 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic03.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic04.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic05.jpg" alt=""></a>
										</div>
										<div class="4u$ 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic06.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic07.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic08.jpg" alt=""></a>
										</div>
										<div class="4u$ 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic09.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic10.jpg" alt=""></a>
										</div>
										<div class="4u 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic11.jpg" alt=""></a>
										</div>
										<div class="4u$ 12u$(mobile)">
											<a href="#" class="image fit"><img src="${pageContext.request.contextPath }/refs/player/images/pic12.jpg" alt=""></a>
										</div>
									</div>
								</section>
							</article>

						<!-- Contact -->
							<article id="work" class="panel">
								<header>
									<h2>作品信息</h2>
								</header>
								<form action="#" method="post">
									<div>
										<div class="row">
											<div class="12u$">
												<input type="text" name="subject" placeholder="作品名称" />
											</div>
											<div class="12u$">
												<textarea name="message" placeholder="作品简介" rows="8"></textarea>
											</div>
											<div class="12u$">
												<input type="submit" value="提    交" />
											</div>
										</div>
									</div>
								</form>
							</article>

					</div>

				<!-- Footer -->
					<div id="footer">
						<ul class="copyright">
							<li>&copy; 郑州大学.</li><li>设计： <a href="http://html5up.net">殷正帅</a></li>
						</ul>
					</div>

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath }/refs/player/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath }/refs/player/assets/js/skel.min.js"></script>
			<script src="${pageContext.request.contextPath }/refs/player/assets/js/skel-viewport.min.js"></script>
			<script src="${pageContext.request.contextPath }/refs/player/assets/js/util.js"></script>
			<!--[if lte IE 8]><script src="${pageContext.request.contextPath }/refs/player/assets/js/ie/respond.min.js"></script><![endif]-->
			<script src="${pageContext.request.contextPath }/refs/player/assets/js/main.js"></script>

	</body>
</html>
