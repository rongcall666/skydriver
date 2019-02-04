<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<title></title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/login.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>

	<div class="mycenter">
		<div class="mysign">
			<div class="col-lg-12 text-center text-info">
				<h2 class="text-center text-success">用户登录</h2>
			</div>

			<form name="f" action="${pageContext.request.contextPath }/logins"
				method="POST">
				<div class="col-lg-12" id="hang">
					<input type="text" class="form-control" id="uid" name="username"
						placeholder="请输入登录的账号">
				</div>

				<div class="col-lg-12" id="hang">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="请输入登录的密码">
				</div>

				<div class="col-lg-12" id="hang">

					<input type="submit" class="btn btn-success col-lg-12" value="登录">


				</div>
			</form>
		</div>

		<div class="col-lg-12">
			<a class="btn btn-default" id="heng" onclick="register()">注册</a> <a
				class="btn btn-default" id="heng" onclick="">忘记密码</a>
		</div>


	
	</div>

</body>
</html>