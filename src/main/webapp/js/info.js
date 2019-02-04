function getInfo() {
	$("#updatePassword").hide();
	$("#updateUsername").hide();
	$("#info").show();
	$.ajax({
		url : "getUsers",
		type : "GET",
		success : function(data) {
			var userName = data.username;
			$("#username").text(userName);
			var capacity = data.capacity;
			var usecapacity = data.usecapacity;
			$("#capacity").text(capacity);
			$("#usecapacity").text(usecapacity);
		},
		error : function(data) {
			alert("请重试");
		}
	});
};

function goSkydriver() {
	window.location.href = "home.jsp";
};
function updateUsername_click() {
	$("#updatePassword").hide();
	$("#updateUsername").show();
	$("#record").hide();
	$("#info").hide();
};
function updatePassword_click() {
	$("#updatePassword").show();
	$("#updateUsername").hide();
	$("#record").hide();
	$("#info").hide();
};
function getFileupload_click() {
	$("#updatePassword").hide();
	$("#updateUsername").hide();
	$("#info").hide();
	$("#record").show();
	var url = "getFileupload";
	$.post(url, function(data) {
		for (var n = 0; n < data.length; n++) {
			$("#datas").empty();
			var templates = "<tr><td>" + data[n].fileuploadId + "</td>" + "<td>"
					+  data[n].file.fileName + "</td>" + "<td>" +  data[n].uploadDate + "</td>"
					+ "<td><button value='" +  data[n].fileuploadId
					+ "'  onclick='deleteRecord_click(this.value)'>删除</button></td></tr>";
			$("#datas").append(templates);
		}
		
		
	});
};
function getFiledownload_click() {
	$("#updatePassword").hide();
	$("#updateUsername").hide();
	$("#info").hide();
	$("#record").show();
	var url = "getFiledownload";
	$.post(url, function(data) {
		for (var n = 0; n < data.length; n++) {
			$("#datas").empty();
			var templates = "<tr><td>" + data[n].filedownloadId + "</td>" + "<td>"
					+  data[n].file.fileName + "</td>" + "<td>" +  data[n].filedownloadDate + "</td>"
					+ "<td><button value='" +  data[n].filedownloadId
					+ "'  onclick='deleteDRecord_click(this.value)'>删除</button></td></tr>";
			$("#datas").append(templates);
		}
		
	});
};
function deleteRecord_click(val){
	var url = "deleteFileupload?fileuploadId=" + val;
	$.get(url,function(data){
		if(data == "login"){
			window.location.href="login.jsp";
		}else if(data == "success"){
			alert("删除成功");
		}else{
			alert("删除失败请重试");
		}
	});
};
function deleteRecordAll_click(){
	var url = "deleteFileuploadAll";
	$.post(url,function(data){
		if(data == "login"){
			window.location.href="login.jsp";
		}else if(data == "success"){
			alert("删除成功");
		}else{
			alert("删除失败请重试");
		}
	});
};
function deleteDRecordAll_click(){
	var url = "deleteFiledownloadAll";
	$.post(url,function(data){
		if(data == "login"){
			window.location.href="login.jsp";
		}else if(data == "success"){
			alert("删除成功");
		}else{
			alert("删除失败请重试");
		}
	});
};
function deleteDRecord_click(val){
	var url = "deleteFiledownload?filedownloadId=" + val;
	$.get(url,function(data){
		if(data == "login"){
			window.location.href="login.jsp";
		}else if(data == "success"){
			alert("删除成功");
		}else{
			alert("删除失败请重试");
		}
	});
};





function updatePassword_form_click() {
	var oldpassword = $("#oldPassword").val();
	var password1 = $("#newPassword1").val();
	var password2 = $("#newPassword1").val();
	oldpassword = $.trim(oldpassword);
	password1 = $.trim(password1);
	password2 = $.trim(password2);
	if (oldpassword == "") {
		alert("请输入原始密码");
		return;
	}
	if (password1 == "") {
		alert("请输入新密码");
		return;
	}
	if (password2 == "") {
		alert("请输入新密码");
		return;
	}
	if (password1 != password2) {
		alert("两次密码不一致");
		return;
	}
	var url = "updatePassword"
	$.post(url, {
		"oldPassword" : oldpassword,
		"newPassword" : password1
	}, function(data) {
		if (data == "true") {
			alert("修改成功");
			window.location.href = "login.jsp";
		} else {
			alert("密码不正常，请重试");
		}
	});
};
function updateUsername_form_click() {
	var username = $("#usernameinput").val();
	username = $.trim(username);
	alert(username);
	if (username == "") {
		alert("请输入用户名");
		return;
	}
	var url = "updateUsername";
	$.post(url, {
		"username" : username
	}, function(data) {
		if (data == "true") {
			alert("修改成功");
		} else {
			alert("修改失败，请重试");
		}
	});
};