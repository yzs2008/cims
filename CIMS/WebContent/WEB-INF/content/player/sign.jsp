<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>Astral by HTML5 UP</title>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<!--[if lte IE 8]><script src="${pageContext.request.contextPath }/refs/player/assets/js/ie/html5shiv.js"></script><![endif]-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/player/assets/css/main.css" />
<noscript>
	<link rel="stylesheet" href="${pageContext.request.contextPath }/refs/player/assets/css/noscript.css" />
</noscript>
<!--[if lte IE 8]><link rel="stylesheet" href="${pageContext.request.contextPath }/refs/player/assets/css/ie8.css" /><![endif]-->
<style>
	div.raceDiv{
		height:218px;
		border: solid 3px rgb(189, 188, 193);	
		background-image: url(${pageContext.request.contextPath }/refs/player/images/divBg.png);
		background-repeat:repeat-x;
	}
</style>
</head>
<body>

	<!-- Wrapper-->
	<div id="wrapper">

		<!-- Nav -->
		<nav id="nav">
			<a href="#notice" class="icon fa-question-circle"><span>注意事项</span></a>
			<a href="#user" class="icon fa-user active"><span>个人信息</span></a> 
			<a href="#race" class="icon fa-flag"><span>报名参赛</span></a> 
			<a href="#work" class="icon fa-folder"><span>作品信息</span></a> 
		</nav>

		<!-- Main -->
		<div id="main">

			<!-- user -->
			<article id="user" class="panel">
				<header>
					<h2>个人信息</h2>
				</header>
				<form action="#race" onsubmit="return saveUserInfo();" method="post">
					<div>
						<div class="row">
							<div class="6u 12u$(mobile)">
								<input type="hidden" id="user-id"  name="user.userId" value="${user.userId }"/> 
								<input type="text" id="user-realName" name="user.realName" placeholder="真实姓名"  value="${user.realName }"/>
							</div>
							<div class="6u$ 12u$(mobile)">
								<input type="text" name="user.phone" id="user-phone" placeholder="电话号码"  value="${user.phone }"/>
							</div>
							<div class="12u$">
								<input type="text" name="user.unit" id="user-unit" placeholder="单位名称"  value="${user.unit }"/>
							</div>
							<div class="12u$">
								<textarea name="user.description" id="user-description" placeholder="自我简介" rows="8">${user.description }</textarea>
							</div>
							<div class="12u$">
								<input type="submit" value="下一步" />
							</div>
						</div>
					</div>
				</form>
			</article>

			<!-- race -->
			<article id="race" class="panel">
				<header>
					<h2>参赛选择</h2>
				</header>
				<p>天行健，君子以自强不息；地势坤，君子以厚德载物!</p>
				<section>
					<div class="row">
						<input type="hidden" id="raceId-select" />
						<div class="4u 12u$(mobile)">
							<a href="javascript:void(0);" onclick="raceSelect(this)" data-id="1">
								<div class="raceDiv">
									<p>第三届科技创新比赛</p>
								</div>
							</a>
						</div>
						<div class="4u 12u$(mobile)">
							<a href="javascript:void(0);" onclick="raceSelect(this)" data-id="1">
								<div class="raceDiv">
									<p>第三届科技创新比赛</p>
								</div>
							</a>
						</div>
						<div class="4u 12u$(mobile)">
							<a href="javascript:void(0);" onclick="raceSelect(this)" data-id="1">
								<div class="raceDiv">
									<p>第三届科技创新比赛</p>
								</div>
							</a>
						</div>
					</div>
				</section>
			</article>

			<!-- work -->
			<article id="work" class="panel">
				<header>
					<h2>作品信息</h2>
				</header>
				<form onsubmit="return saveProduct();" method="post">
					<div>
						<div class="row">
							<div class="12u$">
								<input type="text" id="product-name" name="productName" placeholder="作品名称" value="${productName }"/>
							</div>
							<div class="12u$">
								<textarea name="productDescription" id="product-description" placeholder="作品简介" rows="8">${productDescription }</textarea>
							</div>
							<div class="12u$">
								<input type="submit" value="提    交" />
							</div>
						</div>
					</div>
				</form>
			</article>

			<!-- notice -->
			<article id="notice" class="panel">
				<header>
					<h2>注意事项[帮助文档]</h2>
				</header>
				<p>(1)出國旅行安全應該從整理行李時注意起，為避免成為被注意的對象，衣著宜力求簡樸，太亮麗或摩登的衣著易使人一眼就看出您是觀光客，因此儘可能不要打扮得珠光寶氣，過於時髦。 <br/>(2)行李最好簡便。如此，既能使行動便捷自由，又方便裝卸保管。<br/>

					(3)少帶貴重物品，並妥慎保管。把護照、現金或信用卡鎖在旅館的保險箱最為安全。隨身攜帶時，最好分開存放，不要放在同一個皮包或口袋裏，以免成為小偷扒竊的目標。放在衣褲內的口袋或揹在胸前的旅行袋裏較為安全。把貴重物品放進衣服裏面的小袋子或放錢用的袋子最是保險安全。 (4)如果您戴眼鏡，最好多準備一付，把預備的眼鏡跟藥物放在隨身攜帶的手提袋裏。

					(5)為避免通關時遭遇麻煩，最好把藥物放在原裝並有標示的瓶罐或盒子裏，同時攜帶醫生給的處方或藥物的通稱。如因藥物較特別或含有麻醉品成份，要攜帶醫生開給的證明，對攜帶藥物入境是否合法有疑問時，可事先洽詢該國駐華機構或我國駐外館處。 (6)攜帶旅行支票及一兩張較通用的信用卡，少帶現金。 (7)隨身帶著兩三張護照用的照片，及護照重要頁次的複印本，以便護照被竊或遺失時，迅速申請補發。

					(8)在每件行李內外寫上名字、地址及電話號碼。儘可能使用有外蓋的行李標籤，以免暴露身分，並把行李加鎖。 (9)在出國前查清楚從國外打電話回國的方式。 應隨身攜帶並留在家的東西： (1)把護照、機票、駕照及擬攜帶的信用卡各複印二份，一份隨身攜帶，另一份留給國內親友。 (2)把旅行支票號碼表複印二份，一份留給國內親友，另一份隨身攜帶，並在旅行支票使用或兌現後，把號碼逐一劃掉銷去。</p>
			</article>
		</div>

		<!-- Footer -->
		<div id="footer">
			<ul class="copyright">
				<li>&copy; 郑州大学.</li>
				<li>设计： <a href="http://html5up.net">***</a></li>
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
	<script type="text/javascript">
		function saveUserInfo(){
			var userId=$("#user-id").val();	
			var realName=$("#user-realName").val();	
			var phone=$("#user-phone").val();	
			var unit=$("#user-unit").val();	
			var description=$("#user-description").val();	
			
			var postData={"user":{"userId":userId,"realName":realName,"unit":unit,"description":description,"phone":phone}};
			var jsonData=JSON.stringify(postData);
			var accept=false;
			$.ajax({
				   type: "POST",
				   url: '${ pageContext.request.contextPath }/player/saveUserInfo',
				   data:jsonData,
				   dataType:'json',
				   contentType: 'application/json',
				   async:false,
				   success: function(data){
					   if(data.msg.state){
						   accept=true; 
					   }else{
						   alert(data.msg.msg);
						   accept=false; 
					   }
				   }
				});		
			return accept;
		}
		
		function raceSelect(evt){
			var raceId=$(evt).data("id");	
			$("#raceId-select").val(raceId);
			//获取用户的作品信息
			var postData={"raceId":raceId};
			var jsonData=JSON.stringify(postData);
			$.ajax({
				   type: "POST",
				   url: '${ pageContext.request.contextPath }/player/getProductInfo',
				   data:jsonData,
				   dataType:'json',
				   contentType: 'application/json',
				   async:true,
				   success: function(data){
					   if(data.msg.state){
						   $("#product-name").val(data.sign.productName);
						   $("#product-description").val(data.sign.productDescription);
					   }else{
					   }
				   }
				});	
			$('a[href="#work"]').trigger("click");	
		}
		
		function saveProduct(){
			var raceId=$("#raceId-select").val();
			var productName=$("#product-name").val();
			var productDescription=$("#product-description").val();
			
			if(raceId==null|| raceId==""){
				alert("请先选择报名赛事");
				$('a[href="#race"]').trigger("click");
				return false;
			}
			if(productName==null || productName==""){
				alert("请填写参赛作品名称");
				return false;
			}
			
			var postData={"raceId":raceId,"description":productDescription,"productName":productName};
			var jsonData=JSON.stringify(postData);
			var accept=false;
			$.ajax({
				   type: "POST",
				   url: '${ pageContext.request.contextPath }/player/saveProductInfo',
				   data:jsonData,
				   dataType:'json',
				   contentType: 'application/json',
				   async:false,
				   success: function(data){
					   if(data.msg.state){
						   accept=true; 
					   }else{
						   alert(data.msg.msg);
						   accept=false; 
					   }
				   }
				});		
			return accept;
		}
	</script>

</body>
</html>
