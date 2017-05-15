
function check_name(){
	$("#span_1").html("<span style = 'font-size: 18px ; color:gray'>若忘记账号请联系系统管理员</span>");
}

function check_password(){
	$("#span_1").html("<span style = 'font-size: 18px ; color:gray'>若忘记账号请联系系统管理员</span>");
}

function check_login(){
	
	var adminUser = {};
	adminUser.userName = $("#adminName").val();
	adminUser.password = $("#adminPassword").val();
	
	$.ajax({
		url : "adminLogin",
		type : "post",
		contentType : "application/json;charset=utf-8",  //提交数据的内容类型---发送
		datatype : "json",  //数据格式----接收(后台返回的数据)
		data :JSON.stringify(adminUser),
		success : function(result){
				if(result == "yes"){
					window.location.href = "views/adminIndex.html";
				}else{
					$("#span_1").html("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span style = 'font-size: 18px ; color:red'>❌用户名或密码不正确</span>");
				}
		}
	});
}









