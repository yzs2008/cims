<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3" id="sidebar">
			<ul class="nav nav-list bs-docs-sidenav nav-collapse collapse">
				<li>
					<a href="${pageContext.request.contextPath }/admin/race/index" class="active">
						<i class="icon-chevron-right"></i> 控制面板
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/admin/round/list">
						 轮次管理
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/admin/race/list">
						 赛事管理
					</a>
				</li>
				<li >
					<a href="${pageContext.request.contextPath }/admin/sign/list">
						 报名管理
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/admin/player/list">
						选手管理
					</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/admin/judge/list">
						评委管理
					</a>
				</li>
			</ul>
		</div>