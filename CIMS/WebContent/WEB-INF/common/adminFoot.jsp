<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
</div>
</div>
<hr>
<footer>
	<p style="text-align: center;">&copy; 郑州大学 物理工程学院</p>

	<script type="text/javascript">
		$(function() {
			$('div.span3>ul.nav>li').removeClass('active');
			var pageUrl = location.href;
			var start=pageUrl.indexOf('/cims');
			pageUrl=pageUrl.substr(start,pageUrl.length-start);
			$('a[href$="' + pageUrl + '"]').parents().addClass('active');
		});
	</script>
</footer>