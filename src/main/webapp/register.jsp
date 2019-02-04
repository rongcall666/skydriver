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
<script type="text/javascript" src="js/register.js"></script>
</head>
<body>

	<form>
		<div class="mycenter">
			<div class="mysign">
				<div class="col-lg-12 text-center text-info">
					<h2 class="text-center text-success">用户注册</h2>
				</div>
				<div class="col-lg-12" id="hang">
					<input type="text" class="form-control" id="uid" name="uid"
						onblur="validate()" placeholder="请输入注册的账号">
				</div>
				<div class="col-lg-12">
					<div id="message"></div>
				</div>
				<div class="col-lg-12" id="hang">
					<input type="text" class="form-control" id="username"
						name="username" placeholder="请输入注册的用户名">
				</div>
				<div class="col-lg-12" id="hang">
					<input type="password" class="form-control" id="password"
						name="password" placeholder="请输入注册的密码">
				</div>

				<div class="col-lg-12" id="hang">

					<button type="button" class="btn btn-success col-lg-12"
						onclick="register()">注册</button>


				</div>
			</div>


			<div class="col-lg-12">
				<a class="btn btn-default" id="heng" onclick="login()">登录</a>
			</div>



		</div>
		</div>
		</div>
	</form>

</body>
</html>