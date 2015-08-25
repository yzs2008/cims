<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>评委视窗</title>
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

.echart-section {
	width: 100%;
	height: 300px;
}

.display-none {
	display: none;
}

.display-inline {
	display: inline-block;
}
.animateContainer {
	
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
							<a href="#" id="logo">CIMS评委视窗</a> <span style="color: white; position: absolute; right: 0px; top: 0px;">评审：<span style="color: yellow;">马亚伟</span></span>
						</h1>
						<nav id="nav">
							<a href="javascript:void(0);" onclick="showJudgeOrProgress(this)" data-state="0">评审进程</a> <a href="index.html">退出比赛</a>
						</nav>
					</header>
				</div>
			</div>
		</div>
	</div>
	<div id="main">
		<div class="container">
			<div class="row main-row">
				<div class="12u">

						<div id="judgeTrack" class="echart-section"></div>
						<div id="progress" class="echart-section"></div>

				</div>
			</div>
			<div class="row main-row">
				<div class="12u">

					<div id="playerTrack" class="echart-section"></div>

				</div>
			</div>
		</div>
	</div>
	<div id="footer-wrapper">
		<div>
			&copy; Untitled. All rights reserved. | Design: <a href="http://html5up.net">HTML5 UP</a>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/refs/echart2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript">
		var judgeChart;
		var playerChart;
		var progressChart;
		$(function() {
			// 路径配置
			require
					.config({
						paths : {
							echarts : '${pageContext.request.contextPath }/refs/echart2.2.7/build/dist'
						}
					});
			//评委评分轨迹
			require([ 'echarts', 'echarts/theme/macarons',
					'echarts/chart/line', 'echarts/chart/bar' ], function(ec) {
				var theme = 'macarons';
				judgeChart = ec.init(document.getElementById('judgeTrack'),
						theme);
				var judgeOption = {
					title : {
						text : '您的评分轨迹'
					},
					tooltip : {
						show : true
					},
					legend : {
						show : false,
						data : [ '分值' ]
					},
					xAxis : [ {
						type : 'category',
						data : [ "刘备", "张飞", "关羽", "诸葛亮", "曹操", "吕布", "刘备",
								"张飞", "关羽", "诸葛亮", "曹操", "吕布" ]
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					calculable : true,
					series : [ {
						"name" : "分值",
						"type" : "line",
						"data" : [ 5, 20, 40, 10, 80, 10, 80, 96, 7, 10, 80,
								10, 80, 0, 0 ],
						markPoint : {
							data : [ {
								name : '标注1',
								value : 5,
								xAxis : 0,
								yAxis : 5
							}, {
								name : '标注2',
								value : 20,
								xAxis : 1,
								yAxis : 20
							}, {
								name : '标注3',
								value : 40,
								xAxis : 2,
								yAxis : 40
							}, {
								name : '标注2',
								value : 10,
								xAxis : 3,
								yAxis : 10
							} ]
						}
					} ]
				};

				// 为echarts对象加载数据 
				judgeChart.setOption(judgeOption);

				playerChart = ec.init(document.getElementById('playerTrack'),
						theme);
				var playerOption = {
					title : {
						text : '参赛选手最终成绩'
					},
					tooltip : {
						show : true
					},
					legend : {
						show : false,
						data : [ '成绩' ]
					},
					xAxis : [ {
						type : 'category',
						data : [ "刘备", "张飞", "关羽", "诸葛亮", "曹操", "吕布", "刘备",
								"张飞", "关羽", "诸葛亮", "曹操", "吕布" ]
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						"name" : "成绩",
						"type" : "bar",
						"data" : [ 5, 20, 40, 10, 80, 10, 80, 96, 7, 10, 80,
								10, 80, 0, 0 ],
						markPoint : {
							data : [ {
								name : '标注1',
								value : 5,
								xAxis : 0,
								yAxis : 5
							}, {
								name : '标注2',
								value : 20,
								xAxis : 1,
								yAxis : 20
							}, {
								name : '标注3',
								value : 40,
								xAxis : 2,
								yAxis : 40
							}, {
								name : '标注2',
								value : 10,
								xAxis : 3,
								yAxis : 10
							} ]
						}
					} ]
				};

				// 为echarts对象加载数据 
				playerChart.setOption(playerOption);

				var judgeTrackDiv=$('#judgeTrack');
				$('#progress').width(judgeTrackDiv.width());

				$('#progress').css({
					position:"absolute",
					top:judgeTrackDiv.position().top,
					left:judgeTrackDiv.position().left,
					opacity:0
				});
				progressChart = ec.init(document.getElementById('progress'),
						theme);
				var progressOption = {
					title : {
						text : '评审详情'
					},
					tooltip : {
						show : true
					},
					legend : {
						show : false,
						data : [ '评分' ]
					},
					xAxis : [ {
						type : 'category',
						data : [ "刘备", "张飞", "关羽", "诸葛亮", "曹操", "吕布", "刘备",
								"张飞", "关羽", "诸葛亮" ]
					} ],
					yAxis : [ {
						type : 'value'
					} ],
					series : [ {
						"name" : "评分",
						"type" : "bar",
						"data" : [ 5, 0, 40, 0, 80, 0, 80, 96, 7, 10 ],
						markPoint : {
							data : [ {
								name : '标注1',
								value : 5,
								xAxis : 0,
								yAxis : 5
							}, {
								name : '标注2',
								value : 20,
								xAxis : 1,
								yAxis : 20
							}, {
								name : '标注3',
								value : 40,
								xAxis : 2,
								yAxis : 40
							}, {
								name : '标注2',
								value : 10,
								xAxis : 3,
								yAxis : 10
							} ]
						}
					} ]
				};

				// 为echarts对象加载数据 
				progressChart.setOption(progressOption);
			});

		});

		function showJudgeOrProgress(evt) {
			var state = $(evt).data("state");
			if (state == "0") {
				//show progress	
// 				$("#judgeTrack").addClass("display-none");
// 				//$("#judgeTrack").fadeOut();
// 				$("#progress").fadeIn();
// 				//$("#progress").removeClass("display-none");
				$("#judgeTrack").animate({opacity:0},"slow");
				$("#progress").animate({opacity:1},"slow");
				$(evt).data("state", 1);
				$(evt).html("我的评分");
			} else {
				//show judge	
// 				$("#progress").addClass("display-none");
// 				//$("#progress").fadeOut();
// 				$("#judgeTrack").fadeIn();
// 				//$("#judgeTrack").removeClass("display-none");
				$("#judgeTrack").animate({opacity:1},"slow");
				$("#progress").animate({opacity:0},"slow");
				$(evt).data("state", 0);
				$(evt).html("评审进程");
			}
		}

		function updateChart(option, target) {

		}
	</script>
</body>
</html>