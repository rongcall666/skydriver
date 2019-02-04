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
<script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="css/home.css">
<script type="text/javascript" src="js/info.js"></script>
</head>

<body>
	<div class="container">
		<nav class="navbar navbar-default" role="navigation">
			<div class="container-fluid" id="container-fluid_a">
				<div class="navbar-header">
					<a class="navbar-brand" onclick="goSkydriver()">网盘</a>
				</div>
				<ui class="nav navbar-nav" id="danghanglan">
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" id="username"> 个人中心 <b class="caret"></b>
				</a>
					<ul class="dropdown-menu">
						<li><a onclick="getInfo()">个人信息</a></li>
						<li><a href="#">修改密码</a></li>
						<li><a href="#">系统信息</a></li>
					</ul></li>
				<li><a href="#">升级会员</a></li>
				</ui>
			</div>



			<div class="row">
				<div class="col-sm-10 col-lg-3"
					style="margin-top: 30px; height: 450px;">

					<ul class="nav nav-pills nav-stacked">
						<li class="active"><a onclick="getInfo()">个人信息</a></li>
						<li class="active"><a onclick="updatePassword_click()">修改密码</a></li>
						<li class="active"><a onclick="updateUsername_click()">修改用户名</a></li>
						<!--  <li class="active"><a onclick="getFileupload_click()">上传记录</a></li>-->s
						<li class="active"><a onclick="getFiledownload_click()">下载记录</a></li>
						<li class="active"><a href="#">其它</a></li>
						<li class="active"><a href="#">回收站</a></li>
					</ul>



				</div>
				<div class="col-sm-4 col-lg-9">
					<div>
						<div id="updatePassword" style="display: none; margin-top: 70px;">
							<form>
								<div class="col-lg-8">
									<input type="password" class="form-control" id="oldPassword"
										placeholder="请输入原来的密码">
								</div>
								<div class="col-lg-8" style="margin-top: 20px;">
									<input type="password" class="form-control" 
										name="password" id="newPassword1" name="newPassword1"
										placeholder="请输入新的密码">
								</div>
								<div class="col-lg-8" style="margin-top: 20px;">
									<input type="password" class="form-control" 
										name="password" id="newPassword2" placeholder="请再次输入新的密码">
								</div>
								<div class="col-lg-12" style="margin-top: 20px;">
									<button type="button" class="btn btn-success col-lg-8"
										onclick="updatePassword_form_click()">修改密码</button>
								</div>
							</form>
						</div>


						<div id="updateUsername" style="margin-top: 70px; display: none;">
							<form>
								<div class="col-lg-8" style="margin-top: 20px;">
									<input type="text" class="form-control" id="usernameinput"
										name="username"  placeholder="请输入用户名">
								</div>

								<div class="col-lg-12" style="margin-top: 20px;">
									<button type="button" class="btn btn-success col-lg-8"
										type="button" onclick="updateUsername_form_click()">
										修改用户名</button>
								</div>
							</form>
						</div>


						<div id="info" style="display: none; margin-top: 70px;">
							<h3>
								<span class="label label-primary">姓名：</span> <span id="username"></span>
							</h3>
							<h3>
								<span class="label label-primary">所用容量：</span> <span
									id="capacity"></span>
							</h3>
							<h3>
								<span class="label label-primary">剩余容量：</span> <span
									id="usecapacity"></span>
							</h3>
						</div>


						<div id="record" style="display: none; margin-top: 30px;">
							<table class="table">
								<thead>
									<tr>
										<th>编号</th>
										<th>文件名</th>
										<th>时间</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody id="datas">

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</nav>
	</div>




</body>
</html>