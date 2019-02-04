function F_Open_dialog() {
	document.getElementById("btn_file").click();
};
function uploadFile() {
	var myform = new FormData($("#myform")[0]);
	if (myform == "") {
		return;
	}
	$.ajax({
		url : "uploadfile",
		type : "POST",
		data : myform,
		contentType : false,
		processData : false,
		success : function(data) {
			if (data == "login") {
				window.location.href = "login.jsp";
			} else if (data == "error1") {
				alert("请上传文件");
			} else if (data == "error2") {
				alert("请上传符合条件的文件");
			} else if (data == "updateVip") {
				alert("磁盘容量不足，请压缩文件或者扩容");
			} else if (data == "error") {
				alert("上传失败，请重试");
			} else if (data == "chongshi") {
				alert("已经有同样的文件存在请修改名字后在上传");
			} else {
				alert("上传成功");
			}
		},
		error : function(data) {
			alert("上传失败，请重试");
		}
	});
	this.load();
};
$(function() {
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
	var url = "getFile";
	$
			.get(
					url,
					function(data) {
						for (var n = 0; n < data.length; n++) {
							$("#datas").empty();
							var templates = "<tr><td>"
									+ data[n].fileId
									+ "</td>"
									+ "<td><a href='filedownload?fileId="
									+ data[n].fileId
									+ "'>"
									+ data[n].fileName
									+ "</a></td>"
									+ "<td>"
									+ data[n].fileSize
									+ "</td>"
									+ "<td><button value='"
									+ data[n].fileId
									+ "'  onclick='delete_click(this.value)'>删除</button></td></tr>";
							$("#datas").append(templates);
						}
					});
});

function delete_click(val) {
	var url = "deleteFile?fileId=" + val;
	$.get(url, function(data) {
		if (data == "login") {
			window.location.href = "login.jsp";
		} else if (data == "success") {
			alert("删除成功");
		} else {
			alert("删除失败请重试");
		}
	});
	this.load();
};

function mv() {
	$
			.ajax({
				url : "getFileByType?filetypeId=4",
				type : "GET",
				success : function(data) {
					$("#datas").empty();
					for (var n = 0; n < data.length; n++) {
						$("#datas").empty();
						var templates = "<tr><td>"
								+ data[n].fileId
								+ "</td>"
								+ "<td><a href='filedownload?fileId="
								+ data[n].fileId
								+ "'>"
								+ data[n].fileName
								+ "</a></td>"
								+ "<td>"
								+ data[n].fileSize
								+ "</td>"
								+ "<td><button value='"
								+ data[n].fileId
								+ "'  onclick='delete_click(this.value)'>删除</button></td></tr>";
						$("#datas").append(templates);
					}
				}
			});
};
function load() {
	location.reload();
};
function getInfo() {
	window.location.href = "info.jsp";
};

function images() {
	$
			.ajax({
				url : "getFileByType?filetypeId=1",
				type : "GET",
				success : function(data) {
					$("#datas").empty();
					for (var n = 0; n < data.length; n++) {
						$("#datas").empty();
						var templates = "<tr><td>"
								+ data[n].fileId
								+ "</td>"
								+ "<td><a href='filedownload?fileId="
								+ data[n].fileId
								+ "'>"
								+ data[n].fileName
								+ "</a></td>"
								+ "<td>"
								+ data[n].fileSize
								+ "</td>"
								+ "<td><button value='"
								+ data[n].fileId
								+ "'  onclick='delete_click(this.value)'>删除</button></td></tr>";
						$("#datas").append(templates);
					}
				}
			});
};

function music() {
	$
			.ajax({
				url : "getFileByType?filetypeId=3",
				type : "GET",
				success : function(data) {
					$("#datas").empty();
					for (var n = 0; n < data.length; n++) {
						$("#datas").empty();
						var templates = "<tr><td>"
								+ data[n].fileId
								+ "</td>"
								+ "<td><a href='filedownload?fileId="
								+ data[n].fileId
								+ "'>"
								+ data[n].fileName
								+ "</a></td>"
								+ "<td>"
								+ data[n].fileSize
								+ "</td>"
								+ "<td><button value='"
								+ data[n].fileId
								+ "'  onclick='delete_click(this.value)'>删除</button></td></tr>";
						$("#datas").append(templates);
					}
				}
			});
};
function other() {
	$
			.ajax({
				url : "getFileByType?filetypeId=5",
				type : "GET",
				success : function(data) {
					$("#datas").empty();
					for (var n = 0; n < data.length; n++) {
						$("#datas").empty();
						var templates = "<tr><td>"
								+ data[n].fileId
								+ "</td>"
								+ "<td><a href='filedownload?fileId="
								+ data[n].fileId
								+ "'>"
								+ data[n].fileName
								+ "</a></td>"
								+ "<td>"
								+ data[n].fileSize
								+ "</td>"
								+ "<td><button value='"
								+ data[n].fileId
								+ "'  onclick='delete_click(this.value)'>删除</button></td></tr>";
						$("#datas").append(templates);
					}
				}
			});
};

function word() {
	$
			.ajax({
				url : "getFileByType?filetypeId=2",
				type : "GET",
				success : function(data) {
					$("#datas").empty();
					for (var n = 0; n < data.length; n++) {
						$("#datas").empty();
						var templates = "<tr><td>"
								+ data[n].fileId
								+ "</td>"
								+ "<td><a href='filedownload?fileId="
								+ data[n].fileId
								+ "'>"
								+ data[n].fileName
								+ "</a></td>"
								+ "<td>"
								+ data[n].fileSize
								+ "</td>"
								+ "<td><button value='"
								+ data[n].fileId
								+ "'  onclick='delete_click(this.value)'>删除</button></td></tr>";
						$("#datas").append(templates);
					}
				}
			});
};