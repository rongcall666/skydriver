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
<link rel="stylesheet" type="text/css" href="css/home.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/home.js"></script>
<script type="text/javascript" src="js/json.js"></script>

</head>

<body>

	<nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid" id="container-fluid_a">
			<div class="navbar-header">
				<a class="navbar-brand" onclick="load()">网盘</a>
			</div>

			<ui class="nav navbar-nav" id="danghanglan">
			<li class="dropdown"><a onclick="getInfo()"
				class="dropdown-toggle" data-toggle="dropdown" id="username">
					用户中心 <b class="caret"></b>
			</a>
				<ul class="dropdown-menu">
					<li><a href="#">个人中心</a></li>
					<li><a href="#">修改密码</a></li>
					<li><a href="#">系统信息</a></li>
				</ul></li>
			<li><a href="#">加入我们</a></li>
			<li><a href="#">升级会员</a></li>
			</ui>
	</nav>
	</div>

	<div class="container">
		<div class="row">
			<div class="col-sm-7 col-lg-3">
				<ul class="nav nav-pills nav-stacked">
					<li class="active"><a onclick="load()">全部文件</a></li>
					<li class="active"><a onclick="images()">图片</a></li>
					<li class="active"><a onclick="mv()">视频</a></li>
					<li class="active"><a onclick="word()">文档</a></li>
					<li class="active"><a onclick="music()">音乐</a></li>
					<li class="active"><a onclick="other()">其它</a></li>
					<li class="active"><a href="#">回收站</a></li>
				</ul>
				<h4>
					可用容量 <span id="capacity"></span>
				</h4>
				<h4>
					已使用容量<span id="usecapacity"></span>
				</h4>
			</div>
			<div class="col-sm-4 col-lg-9">
				<nav role="navigation">
					<div class="container-fluid">
						<form id="myform" method="POST" enctype="multipart/form-data">
							<input type="file" name="file" id="btn_file"
								style="display: none" onchange="uploadFile()">
						</form>
						<button class="btn btn-primary" onclick="F_Open_dialog()">上传</button>
						<button class="btn btn-primary" onclick="F_Open_dialog()">新建文件夹</button>
						<div class="nav navbar-nav" id="danghanglan">
							<form id="search_form">
								<input type="text" id="search_input">
								<button class="btn btn-primary" onclick="search()">搜索</button>
							</form>
						</div>
					</div>
				</nav>

				<table class="table" id="datas">
					<thead>
						<tr>
							<th>编号</th>
							<th>文件名</th>
							<th>大小</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<tr id="template">
							<td id="fileId">111</td>
							<td id="fileName">123</td>
							<td id="fileSize">123</td>
							<td id="fileDelete">1231</td>
						</tr>
					</tbody>
				</table>
			</div>

		</div>
	</div>
</body>

</html>