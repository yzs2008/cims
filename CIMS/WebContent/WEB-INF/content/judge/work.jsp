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
					<div class="total-score" data-state="0">
						<section id="score-show">
							<article class="big-score" id="total-show">0</article>
							<div id="progressBarContainer" class="progressBar-hidden">
								<div id="progressBar"></div>
							</div>
							<a href="javascript:void(0);" onmousedown="submitPress()" onmouseup="submitRelease()">长按2秒提交成绩</a>
						</section>
						<section id="keyboard-show">
							<p class="user-score">
								<!-- 								<span style="position: absolute; left: 0px; top: 0; color: black; font-size: 0.6em; display: inline-block;    font-weight: normal;">上限：20</span> -->
								<span id="user-input" data-max="100" data-target=""></span>
							</p>
							<div class="keyborad-container">
								<ul class="keys">
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="0">0</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="1">1</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="2">2</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="3">3</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="4">4</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="5">5</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="6">6</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="7">7</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="8">8</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="numberInput(this)" class="key-for-tap" data-item="9">9</a></li>
									<li class="key-item"><a href="javascript:void(0);" onclick="dotInput(this)" class="key-for-tap" data-item="0">.</a></li>
									<li class="fun-item"><a href="javascript:void(0);" onclick="backspace(this)" class="key-for-tap">&#8592;</a></li>
									<li class="fun-item"><a href="javascript:void(0);" onclick="clearInput(this)" class="key-for-tap">清空</a></li>
									<li class="fun-item"><a href="javascript:void(0);" onclick="cancel(this)" class="key-for-tap" data-item="0">取消</a></li>
									<li class="fun-item"><a href="javascript:void(0);" onclick="accept(this)" class="key-for-tap" data-item="0">确定</a></li>
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
				<div class="12u" style="text-align: center; margin-bottom: 20px;">
					<section class="item-inline">
						<header>
							<article class="item-score" id="standard-item0"></article>
						</header>
						<article style="margin: 0px;">
							<img class="item-icon" alt="对应" onclick="turnKeyboard(this)" data-max="100" data-standard="standard-item0" src="${pageContext.request.contextPath }/images/judge/Triangle.jpg">
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
		//var beginTime;
		var duringMilliseconds=1800;
		function submitPress() {
			beginTime=new Date().getTime();
			console.info(beginTime);
			$('#progressBarContainer').removeClass('progressBar-hidden');
			$('#progressBar').animate({'width':'193px'},duringMilliseconds,function(){
				submitScore();	
			})
		}
		function submitRelease() {
			//var endTime=new Date().getTime();
			//var interval=endTime-beginTime;
			//console.info(interval);
// 			if(interval>=duringMilliseconds){
// 				submitScore();	
// 			}
			$('#progressBar').stop().css({'width':'0px'});
			$('#progressBarContainer').addClass('progressBar-hidden');
		}
		function submitScore(){
			noty({
				text : '提交成功',
				type : 'notification',
				dismissQueue : true,
				layout : 'topCenter',
				maxVisible : 1,
				theme : 'defaultTheme'
			});	
			location.href="/cims";
		}

		var inputError = null;

		function turnKeyboard(evt) {
			var state = $('div.total-score').data('state');
			if (state == 1) {
				//state==1 说明案板已经翻转，显示的已经是键盘输入案板了
				return;
			}
			$('div.total-score').addClass('total-hover');

			var orignalScore = $(evt).parents('section.item-inline').find(
					'article.item-score').text();//原始值
			if (orignalScore == null || orignalScore == 0) {
				$('#user-input').text('');
			} else {
				$('#user-input').text(orignalScore);
			}
			//键盘案板显示标志
			$('div.total-score').data('state', 1);
			//设置本次输入最大值
			var max = $(evt).data('max');
			$('#user-input').data('max', max);
			//设置本次输入对象
			var targetId = $(evt).data('standard');
			$('#user-input').data('target', targetId);
		}
		//输入确认
		function accept(evt) {
			var itemMax = $('#user-input').data('max');
			var itemVar = $('#user-input').text().trim();
			if (itemVar == null || itemVar == "") {
				itemVar = 0;
			}
			var itemInput = parseFloat(itemVar).toFixed(0);

			if (itemMax >= itemInput) {
				//接受输入
				var target = $('#user-input').data('target');
				$('#' + target).text(itemInput);//设置分项分
				//设置总分
				updateTotal();

				$('div.total-score').removeClass('total-hover');//翻转
				$('div.total-score').data('state', 0);//成绩显示案板标志

			} else {
				//拒绝输入无效值	
				//弹出通知说明，无效值
				if (inputError != null) {
					return;
				}
				var msg = '超过最大值【' + itemMax + '】';
				inputError = noty({
					text : msg,
					type : 'error',
					dismissQueue : true,
					layout : 'topCenter',
					maxVisible : 1,
					theme : 'defaultTheme'
				});
				setTimeout(function() {
					$.noty.close(inputError.options.id);
					inputError = null;
				}, 2000);

			}
		}
		function updateTotal() {
			var total = 0;
			$('article.item-score').each(function() {
				var itemVar = $(this).text();
				if (itemVar == null || itemVar == "") {
					itemVar = 0;
				}
				var itemInput = parseFloat(itemVar);
				total += itemInput;
			});
			total = total.toFixed(0);
			$('#total-show').text(total);
		}
		//取消输入
		function cancel(evt) {
			$('div.total-score').removeClass('total-hover');
			//成绩显示案板标志
			$('div.total-score').data('state', 0);
		}
		//清空输入
		function clearInput(evt) {
			$('#user-input').text('');
		}
		//退格键
		function backspace(evt) {
			var screenValue = $('#user-input').text();
			if (screenValue == null || screenValue.length < 1) {
				return;
			}
			var newInput = screenValue.substr(0, screenValue.length - 1);
			$('#user-input').text(newInput);
		}
		//点号输入
		function dotInput(evt) {
			var screenValue = $('#user-input').text();
			//点号作为小数点，智能输入一次
			if (screenValue.indexOf('.', 0) != -1) {
				return;
			}
			var newInput = screenValue + '.';
			$('#user-input').text(newInput);
		}
		//数字输入
		function numberInput(evt) {
			var screenValue = $('#user-input').text();
			if (screenValue.length >= 10) {
				return;
			}
			var newInput = $(evt).data('item');
			screenValue += newInput;
			$('#user-input').text(screenValue);
		}
	</script>
</body>
</html>