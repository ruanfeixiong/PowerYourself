<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>PowerYourself--掌握你的生活</title>
		<link media="all" type="text/css" rel="stylesheet" href="css/bootstrap.min.css">
		<link media="all" type="text/css" rel="stylesheet" href="css/loginstyle.css">
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div class="col-md-offset-3 col-md-6">
					<form class="form-horizontal">
						<span class="heading">PowerYourself--注册</span>
						<div class="form-group">
							<input name="username" type="text" class="form-control" id="username" value="请输入用户名" />
						</div>
						<div class="form-group">
							<input name="password" type="text" class="form-control" id="password" value="请输入密码" />
						</div>
						<div class="form-group">
							<li class="li4">
								<input class="submit" type="submit" id="btnSubmit" value="注册">
							</li>
							<li class="li3">
								<a class="visitor" href="login.ftl">>>>> 登录</a>
							</li>
						</div>
					</form>
				</div>
			</div>
		</div>
	</body>
	
	<script src="js/jquery.min.js"></script>
	<!--动态背景-->
	<script src="js/jquery.gradientify.min.js"></script>
	<script>
		$(document).ready(function() {
			$("body").gradientify({
				gradients: [
					{ start: [49,76,172], stop: [242,159,191] },
					{ start: [255,103,69], stop: [240,154,241] },
					{ start: [33,229,241], stop: [235,236,117] }
				]
			});
		});
	</script>
		
	<!--登录验证-->
    <script type="text/javascript"> 
		$('#username').focus(function () { 
			$('#username').val(''); 
		}) 
		$('#password').focus(function () { 
			$('#password').val(''); 
		}) 
		$('#username').blur(function () { 
			if ($('#username').val() =='') { 
				$('#username').val('用户名不能为空'); 
				$('#username').css({'color':'red'}); 
			} 
		}) 
		$('#username').focus(function () {
			$('#username').css({'color':'#ADADAD'}); 
		});
			
		$('#password').blur(function () { 
			if ($('#password').val() == '') { 
				$('#password').val('密码不能为空'); 
				$('#password').css({'color':'red'}); 
			} 
		}) 
		$('#password').focus(function () {
			$('#password').css({'color':'#ADADAD'}); 
		});
			
		$('#btnSubmit').click(function () { 
			if ($('#username').val() == 'Zazzing' && $('#password').val() == '123456') { 
				alert('登录成功！'); 
				window.open('index.html');
			}
			else { 
				alert('登录失败！'); 
			}
		}) 
	</script> 	
</html>
