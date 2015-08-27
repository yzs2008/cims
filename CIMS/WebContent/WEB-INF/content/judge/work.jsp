<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>评审页面</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<script src="${pageContext.request.contextPath }/refs/judge/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/skel.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/skel-layers.min.js"></script>
<script src="${pageContext.request.contextPath }/refs/judge/js/init-wait.js"></script>
<script src="${pageContext.request.contextPath }/refs/noty/packaged/jquery.noty.packaged.js"></script>
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/skel.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/style.css" />
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/style-desktop-wait.css" />
</noscript>
<!--[if lte IE 9]><link rel="stylesheet" href="${pageContext.request.contextPath }/refs/judge/css/ie9.css" /><![endif]-->
<!--[if lte IE 8]><script src="${pageContext.request.contextPath }/refs/judge/js/html5shiv.js"></script><![endif]-->
<style type="text/css">
.wait-header {
	font-size: 1em;
	letter-spacing: 1px;
	margin-bottom: 0.3em;
}

section, article {
	margin-bottom: 0px;
}
</style>
</head>
<body>
	<div id="header-wrapper">
		<div class="container">
			<div class="row">
				<div class="12u">
					<header id="header">
						<h1>
							<a href="#" id="logo">CIMS评审在线 </a><span>郑州市小主持人大赛</span> <span style="color: white; position: absolute; right: 0px; top: 0px;">评审：<span style="color: yellow;">马亚伟</span></span>
						</h1>
						<nav id="nav">
							<a href="index.html">退出比赛</a>
						</nav>
					</header>
				</div>
			</div>
		</div>
	</div>
	<div id="main">
		<div class="container">
			<div class="row main-row">
				<div class="12u container-3d" style="text-align: center;">
					<div class="slide-section">
						<h3>作者</h3>
						<p>单位与个人</p>
					</div>
					<div class="total-score">
						<section id="score-show">
							<article class="big-score">19.00</article>
							<a href="javascript:void(0);" onclick="submitScore()">长按2秒提交成绩</a>
						</section>
						<section id="keyboard-show">
							<p class="user-score">
								<span style="position: absolute; left: 0px; top: 0; color: black; font-size: 0.6em; display: inline-block;    font-weight: normal;">上限：20</span>
								<span id="user-input">&nbsp;</span>
							</p>
							<div class="keyborad-container">
								<ul class="keys">
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="0">0</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="1">1</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="2">2</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="3">3</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="4">4</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="5">5</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="6">6</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="7">7</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)"  class="key-for-tap" data-item="8">8</a></li>
									<li class="key-item"><a href="javascript:void(0);"  onclick="numberInput(this)" class="key-for-tap" data-item="9">9</a></li>
									<li class="key-item"><a href="javascript:void(0);" class="key-for-tap" data-item="0">.</a></li>
									<li class="fun-item"><a href="javascript:void(0);"  onclick="backspace(this)" class="key-for-tap" >&#8592;</a></li>
									<li class="fun-item"><a href="javascript:void(0);" onclick="clearInput(this)" class="key-for-tap" >清空</a></li>
									<li class="fun-item"><a href="javascript:void(0);" class="key-for-tap" data-item="0">取消</a></li>
									<li class="fun-item"><a href="javascript:void(0);" class="key-for-tap" data-item="0" onclick="accept(this)">确定</a></li>
								</ul>
							</div>
						</section>
					</div>
					<div class="slide-section">
						<h3>作品名称</h3>
						<p>作品简介，必须</p>
					</div>
				</div>
			</div>
			<div class="row main-row">
				<div class="12u" style="text-align: center;    margin-bottom: 20px;">
					<section class="item-inline">
						<header>
							<article class="item-score">20</article>
						</header>
						<article style="margin: 0px;">
							<img class="item-icon" alt="对应" src="${pageContext.request.contextPath }/images/judge/Triangle.jpg">
						</article>
						<footer>
							<article class="item-name">色彩搭配，总体印象</article>
						</footer>
					</section>
					<section class="item-inline">
						<header>
							<article class="item-score">20</article>
						</header>
						<article style="margin: 0px;">
							<img class="item-icon" alt="对应" onclick="turnKeyboard(this)" data-max="20" src="${pageContext.request.contextPath }/images/judge/Triangle.jpg">
						</article>
						<footer>
							<article class="item-name">色彩搭配，总体印象</article>
						</footer>
					</section>
					<section class="item-inline">
						<header>
							<article class="item-score">20</article>
						</header>
						<article style="margin: 0px;">
							<img class="item-icon" alt="对应" src="${pageContext.request.contextPath }/images/judge/Triangle.jpg">
						</article>
						<footer>
							<article class="item-name">色彩搭配，总体印象</article>
						</footer>
					</section>
					<section class="item-inline">
						<header>
							<article class="item-score">20</article>
						</header>
						<article style="margin: 0px;">
							<img class="item-icon" alt="对应" src="${pageContext.request.contextPath }/images/judge/Triangle.jpg">
						</article>
						<footer>
							<article class="item-name">色彩搭配，总体印象</article>
						</footer>
					</section>
					<section class="item-inline">
						<header>
							<article class="item-score">20</article>
						</header>
						<article style="margin: 0px;">
							<img class="item-icon" alt="对应" src="${pageContext.request.contextPath }/images/judge/Triangle.jpg">
						</article>
						<footer>
							<article class="item-name">色彩搭配，总体印象</article>
						</footer>
					</section>
				</div>
			</div>
		</div>
	</div>
	<div id="footer-wrapper">
		<div>
			&copy; 郑州大学. | 设计研发: <a href="javascript:void(0);">挂坠儿</a>
		</div>
	</div>

	<script type="text/javascript">
	function turnKeyboard(evt){
		$('div.total-score').addClass('total-hover');
	}
	//输入结束
	function accept(evt){
		$('div.total-score').removeClass('total-hover');
	}
	//取消输入
	function cancel(evt){
		
	}
	//清空输入
	function clearInput(evt){
		$('#user-input').text(' ');
	}
	//退格键
	function backspace(evt){
		var screenValue=$('#user-input').text();	
		if(screenValue.length==1){
			return;
		}
		var newInput=screenValue.substr(0,screenValue.length-1);
		$('#user-input').text(newInput);
	}
	//点号输入
	function dotInput(evt){
		
	}
	//数字输入
	function numberInput(evt){
		var screenValue=$('#user-input').text();	
		if(screenValue.length>=10){
			return;
		}
		var newInput=$(evt).data('item');
		screenValue+=newInput;
		$('#user-input').text(screenValue);
	}

	</script>
</body>
</html>