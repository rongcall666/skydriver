function login(){
	var uid = $("#uid").val();
	var password = $("#password").val();
	uid = $.trim(uid);
	password = $.trim(password);
	if(uid == ""){
		alert("请输入账号");
		return ;
	}
	else if(password == ""){
		alert("请输入密码");
		return ;
	}else{
		var url = "login";
		$.post(url,{"uid":uid,"username":uid,"password":password},function(data){
			if(data == true){
				window.location.href="home.jsp";
			}else{
				alter("用户名密码不正确");
			}
		});
	}
};
function register(){
	window.location.href="register.jsp";
};