<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>评审视窗</title>
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

.next-btn{
    border: solid 1px black;
    padding: 10px 20px;
    color: white;
    background-color: #F89E38;
    border-radius: 5px;
    width: 20%;
    margin-bottom: -10px;
    margin-top: -10px;
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
							<a href="#" id="logo">CIMS评审视窗</a>
							<span style="color: white; position: absolute; right: 0px; top: 0px;">评审：<span style="color: yellow;">${displayName }</span></span>
						</h1>
						<nav id="nav">
							<a href="javascript:void(0);" onclick="showJudgeOrProgress(this)" data-state="0">评审进程</a>
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
				<div class="12u">

					<div id="judgeTrack" class="echart-section"></div>
					<div id="progress" class="echart-section"></div>
					<input type="hidden" id="raceId" value="${raceId }"/>
				</div>
			</div>
			<div style="text-align: center;position: relative;z-index: 100;">
				<a href="${pageContext.request.contextPath }/judge/work" class="next-btn" >为下一位选手评判</a>
			</div>
			<div class="row main-row">
				<div class="12u" style="padding-top: 0px;">

					<div id="playerTrack" class="echart-section"></div>

				</div>
			</div>
		</div>
	</div>
	<div id="footer-wrapper">
		<div>
			&copy; Untitled. All rights reserved. | Design:
			<a href="http://html5up.net">HTML5 UP</a>
		</div>
	</div>

	<script src="${pageContext.request.contextPath }/refs/echart2.2.7/build/dist/echarts.js"></script>
	<script type="text/javascript">
		var judgeChart;
		var playerChart;
		var progressChart;
		$(function() {
			// 路径配置
			require.config({
						paths : {
							echarts : '${pageContext.request.contextPath }/refs/echart2.2.7/build/dist'
						}
					});
			//评委评分轨迹
			require([ 'echarts', 'echarts/theme/macarons', 'echarts/chart/line', 'echarts/chart/bar' ], 
					function(ec) {
				var theme = 'macarons';
				judgeChart = ec.init(document.getElementById('judgeTrack'), theme);

				var judgeOption = getJudgeOpt();
				// 为echarts对象加载数据 
				judgeChart.setOption(judgeOption);

				playerChart = ec.init(document.getElementById('playerTrack'), theme);
				var playerOption = getPlayerOpt(); 
				// 为echarts对象加载数据 
				playerChart.setOption(playerOption);

				var judgeTrackDiv = $('#judgeTrack');
				$('#progress').width(judgeTrackDiv.width());

				$('#progress').css({
					position : "absolute",
					top : judgeTrackDiv.position().top,
					left : judgeTrackDiv.position().left,
					opacity : 0
				});
				progressChart = ec.init(document.getElementById('progress'), theme);
				var progressOption = getProgressOpt();				// 为echarts对象加载数据 
				progressChart.setOption(progressOption);
			});

		});


		function showJudgeOrProgress(evt) {
			var state = $(evt).data("state");
			if (state == "0") {
				//show progress	
				$("#judgeTrack").animate({
					opacity : 0
				}, "slow");
				$("#progress").animate({
					opacity : 1
				}, "slow");
				$(evt).data("state", 1);
				$(evt).html("我的评分");
			} else {
				//show judge	
				$("#judgeTrack").animate({
					opacity : 1
				}, "slow");
				$("#progress").animate({
					opacity : 0
				}, "slow");
				$(evt).data("state", 0);
				$(evt).html("评审进程");
			}
		}

		function getJudgeOpt() {
			var url = "getJudgeScoreTrace";
			var resultData = getData(url);
			var xData = new Array();
			var yData = new Array();
			var markPointerData = new Array();

			for (var i = 0; i < resultData.length; i++) {
				var item = resultData[i];
				xData[i] = item.user.realName;
				yData[i] = item.score;
				var markPointer = {
					name : xData[i],
					value : yData[i],
					xAxis : i,
					yAxis : yData[i]
				};
				markPointerData[i] = markPointer;
			}

			var judgeOpt = {
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
					data : xData
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				calculable : true,
				series : [ {
					"name" : "分值",
					"type" : "line",
					"data" : yData,
					markPoint : {
						data : markPointerData
					}
				} ]
			};
			return judgeOpt;
		}
		function getPlayerOpt() {
			var url = "getFinalScore";
			var resultData = getData(url);
			var xData = new Array();
			var yData = new Array();
			var markPointerData = new Array();

			for (var i = 0; i < resultData.length; i++) {
				var item = resultData[i];
				xData[i] = item.user.realName;
				yData[i] = item.score;
				var markPointer = {
					name : xData[i],
					value : yData[i],
					xAxis : i,
					yAxis : yData[i]
				};
				markPointerData[i] = markPointer;
			}
			
			var playerOpt = {
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
					data :xData 
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					"name" : "成绩",
					"type" : "bar",
					"data" : yData,
					markPoint : {
						data : markPointerData
					}
				} ]
			};
			return playerOpt;
		}
		function getProgressOpt() {
			var url = "getProgress";
			var resultData = getData(url);
			var xData = new Array();
			var yData = new Array();
			var markPointerData = new Array();

			for (var i = 0; i < resultData.length; i++) {
				var item = resultData[i];
				xData[i] = item.raceJudge.displayName;
				yData[i] = item.score;
				var markPointer = {
					name : xData[i],
					value : yData[i],
					xAxis : i,
					yAxis : yData[i]
				};
				markPointerData[i] = markPointer;
			}
			var progressOpt = {
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
					data : xData
				} ],
				yAxis : [ {
					type : 'value'
				} ],
				series : [ {
					"name" : "评分",
					"type" : "bar",
					"data" : yData,
					markPoint : {
						data :markPointerData 
					}
				} ]
			};
			return progressOpt;
		}

		function getData(dataUrl) {
			var resultData;

			var raceId = $('#raceId').val();

			var postData = {
				"raceId" : raceId
			};
			var jsonData = JSON.stringify(postData);
			$.ajax({
				type : "POST",
				url : '${ pageContext.request.contextPath }/judge/' + dataUrl,
				data : jsonData,
				dataType : 'json',
				contentType : 'application/json',
				async : false,
				success : function(data) {
					resultData = data.resultData;
				}
			});
			return resultData;
		}

		function updateChart(target) {
			switch(target){
				case 'all':
					judgeChart.setOption(getJudgeOpt());
					playerChart.setOption(getPlayerOpt());
					progressChart.setOption(getProgressOpt());
					break;
				case 'judge':
					judgeChart.setOption(getJudgeOpt());
					break;
				case 'player':
					playerChart.setOption(getPlayerOpt());
					break;
				case 'progress':
					progressChart.setOption(getProgressOpt());
					break;
			}
		}
	</script>
	<script type="text/javascript">
	</script>
</body>
</html>