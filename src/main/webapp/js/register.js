function validate() {
	var uid = document.getElementById("uid").value;
	if (uid == "")
		return;
	if(uid.length < 6){
		alert("请输入6位数以上的账号")
		return;
	}
	var request = new XMLHttpRequest();
	var url = "isexist?uid=" + uid;
	request.open("GET", url, true);
	request.onreadystatechange = function() {
		if (request.readyState == 4 && request.status == 200) {
			if (request.responseText == "1") {
				document.getElementById("message").innerHTML = "<span style='color:red'>用户名已经存在</span><br>";
				document.getElementById("button").disabled=true;
			} else {
				document.getElementById("message").innerHTML = "<span style='color:green'>用户名可以使用</span><br>";
				document.getElementById("button").disabled=false;
			}
		}
	};
	request.send();
};
function register() {
	var uid = document.getElementById("uid").value;
	var password = document.getElementById("password").value;
	var username = document.getElementById("username").value;
	if (uid == "") {
		alert("请输入账号");
		return;
	} else if (password == "") {
		alert("请输入密码");
		return;
	} else if (username == "") {
		alert("请输入用户名");
		return;
	} else {
		var request = new XMLHttpRequest();
		var url = "register";
		$.post(url, {
			"uid" : uid,
			"password" : password,
			"username" : username
		}, function(date) {
			if (date == false) {
				alert("注册失败，请重试");
			} else {
				alert("注册成功");
				window.location.href="login.jsp";
			}
		});
	}
};
function login(){
	window.location.href="login.jsp";
}