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
							<a href="index.html">评审进程</a> <a href="index.html">退出比赛</a>
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

				</div>
			</div>
			<div class="row main-row">
				<div class="12u">

					<div id="playerTrack" class="echart-section"></div>

				</div>
			</div>
			<div class="row main-row">
				<div class="12u">

					<div id="progress" style="height: 400px;"></div>

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
					'echarts/chart/line', 'echarts/chart/bar',
					'echarts/chart/pie' ], function(ec) {
				var theme = 'macarons';
				var judgeChart = ec.init(document.getElementById('judgeTrack'),
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

				var playerChart = ec.init(document
						.getElementById('playerTrack'), theme);
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

				var pieChart = ec.init(document.getElementById('progress'),
						theme);
				var pieOption = {
					title : {
						text : '评审详情'
					},
					legend : {
						orient : 'vertical',
						x : 'right',
						data : [ '直访问[24]', '邮件销', '联盟告', '视告', '搜索',
								'直接访', '邮件销', '盟广告', '视广告', '索引' ]
					},
					series : [ {
						name : '访问来源',
						type : 'pie',
						radius : [ '40%', '90%' ],
						itemStyle : {
							normal : {
								label : {
									show : true,
									position : 'inner',
									formatter : function(params) {
										return params.name;
									},
									textStyle : {
										fontSize : '13',
										fontWeight : 'bold'
									}
								},
								labelLine : {
									show : false
								}
							},
							emphasis : {
								label : {
									show : true,
									position : 'center',
									formatter : function(params) {
										return params.name;
									},
									textStyle : {
										fontSize : '13',
										fontWeight : 'bold'
									}
								}
							}
						},
						data : [ {
							value : 1,
							name : '直访问[24]'
						}, {
							value : 1,
							name : '邮件[84]'
						}, {
							value : 1,
							name : '盟广告[9]'
						}, {
							value : 1,
							name : '视频告[23.3]'
						}, {
							value : 1,
							name : '搜索引[23.02]'
						}, {
							value : 1,
							name : '直接问[23]'
						}, {
							value : 1,
							name : '邮件销[29]'
						}, {
							value : 1,
							name : '联盟广[29.2]'
						}, {
							value : 1,
							name : '视频广[92.32]'
						}, {
							value : 1,
							name : '搜索[29]'
						} ]
					} ]
				};

				// 为echarts对象加载数据 
				pieChart.setOption(pieOption);
			});
		});
	</script>
</body>
</html>