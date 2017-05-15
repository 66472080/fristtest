window.onload = function() {
	
	var initPage = 1 ;
	$.ajax({
				url : "../findUsers_limit",
				type : "post",
				datatype : "json",
					type : "post",
					contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送					
					data : JSON.stringify(initPage),					
				success : function(result) {
				
					var html = "<tr><td>序号</td><td>姓名</td><td>用户名</td><td>密码</td>" +
							"<td>性别</td><td>身份证号</td><td>家庭住址</td><td>电话号</td><td>注册时间</td>" +
							"<td>账户余额</td><td>状态</td><td></td><td></td></tr>";
					for (var i = 1; i <= result.user.length; i++) {
						if (result.user[i - 1].status == 1) {
								html += "<tr><td>" + i + "</td>" + "<td>"
								+ result.user[i - 1].name + "</td>"+ "<td>"
								+ result.user[i - 1].userName + "</td>"+ "<td>"
								+ result.user[i - 1].userPwd + "</td>"+ "<td>"
								+ result.user[i - 1].gender + "</td>"+ "<td>"
								+ result.user[i - 1].idCard + "</td>"+ "<td>"
								+ result.user[i - 1].address + "</td>"+ "<td>"
								+ result.user[i - 1].telon + "</td>"+ "<td>"
								+ result.user[i - 1].regTime + "</td>"+ "<td>"
								+ result.user[i - 1].balance + "</td>"
								+ "<td><span style = 'color:green' id = userZhuangtai_"+result.user[i - 1].uid+">正常</span></td>"
								+ "<td><a href = 'javascript:stopUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">禁用</a></td></tr>"
						}else if(result.user[i - 1].status == 0){
							html += "<tr><td>" + i + "</td>" + "<td>"
							+ result.user[i - 1].name + "</td>"+ "<td>"
							+ result.user[i - 1].userName + "</td>"+ "<td>"
							+ result.user[i - 1].userPwd + "</td>"+ "<td>"
							+ result.user[i - 1].gender + "</td>"+ "<td>"
							+ result.user[i - 1].idCard + "</td>"+ "<td>"
							+ result.user[i - 1].address + "</td>"+ "<td>"
							+ result.user[i - 1].telon + "</td>"+ "<td>"
							+ result.user[i - 1].regTime + "</td>"+ "<td>"
							+ result.user[i - 1].balance + "</td>"
							+ "<td><span style = 'color:red' id = userZhuangtai_"+result.user[i - 1].uid+">停用</span></td>"
							+ "<td><a href = 'javascript:openUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">解封</a></td></tr>"
						}
						var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
	                    page +="<a href='javascript:finsusersQuery(1);'>   [首页]   </a>";
	                    page +="<a href='javascript:finsusersQuery("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
	                    page +="<a href='javascript:finsusersQuery("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
	                    page +="<a href='javascript:finsusersQuery("+result.adminPage.totalPage+")'>   [尾页]   </a>";
	                    $("#page").html(page);
					}
					$("#table_user").html(html);
					
				}

			});

}

function finsusersQuery(current){
	var initPage = current ;
	$.ajax({
		url : "../findUsers_limit",
		type : "post",
		datatype : "json",
			type : "post",
			contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送					
			data : JSON.stringify(initPage),					
		success : function(result) {
		
			var html = "<tr><td>序号</td><td>姓名</td><td>用户名</td><td>密码</td>" +
					"<td>性别</td><td>身份证号</td><td>家庭住址</td><td>电话号</td><td>注册时间</td>" +
					"<td>账户余额</td><td>状态</td><td></td><td></td></tr>";
			for (var i = 1; i <= result.user.length; i++) {
				if (result.user[i - 1].status == 1) {
						html += "<tr><td>" + i + "</td>" + "<td>"
						+ result.user[i - 1].name + "</td>"+ "<td>"
						+ result.user[i - 1].userName + "</td>"+ "<td>"
						+ result.user[i - 1].userPwd + "</td>"+ "<td>"
						+ result.user[i - 1].gender + "</td>"+ "<td>"
						+ result.user[i - 1].idCard + "</td>"+ "<td>"
						+ result.user[i - 1].address + "</td>"+ "<td>"
						+ result.user[i - 1].telon + "</td>"+ "<td>"
						+ result.user[i - 1].regTime + "</td>"+ "<td>"
						+ result.user[i - 1].balance + "</td>"
						+ "<td><span style = 'color:green' id = userZhuangtai_"+result.user[i - 1].uid+">正常</span></td>"
						+ "<td><a href = 'javascript:stopUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">禁用</a></td></tr>"
				}else if(result.user[i - 1].status == 0){
					html += "<tr><td>" + i + "</td>" + "<td>"
					+ result.user[i - 1].name + "</td>"+ "<td>"
					+ result.user[i - 1].userName + "</td>"+ "<td>"
					+ result.user[i - 1].userPwd + "</td>"+ "<td>"
					+ result.user[i - 1].gender + "</td>"+ "<td>"
					+ result.user[i - 1].idCard + "</td>"+ "<td>"
					+ result.user[i - 1].address + "</td>"+ "<td>"
					+ result.user[i - 1].telon + "</td>"+ "<td>"
					+ result.user[i - 1].regTime + "</td>"+ "<td>"
					+ result.user[i - 1].balance + "</td>"
					+ "<td><span style = 'color:red' id = userZhuangtai_"+result.user[i - 1].uid+">停用</span></td>"
					+ "<td><a href = 'javascript:openUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">解封</a></td></tr>"
				}
				var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
                page +="<a href='javascript:finsusersQuery(1);'>   [首页]   </a>";
                page +="<a href='javascript:finsusersQuery("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
                page +="<a href='javascript:finsusersQuery("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
                page +="<a href='javascript:finsusersQuery("+result.adminPage.totalPage+")'>   [尾页]   </a>";
                $("#page").html(page);
			}
			$("#table_user").html(html);
			
		}

	});

}

function finsusersQueryForTime(pageForTime_limit){
	var adminForTimeCheck = {};
	adminForTimeCheck.start_time = $("#checkUser_start_Time").val()+" 00:00:00";
	adminForTimeCheck.end_time = $("#checkUser_end_Time").val()+" 00:00:00";
	adminForTimeCheck.initPage = pageForTime_limit ;
	$.ajax({
		url : "../checkUserForTime_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminForTimeCheck),
		success : function(result){
			var html = "<tr><td>序号</td><td>姓名</td><td>用户名</td><td>密码</td>" +
			"<td>性别</td><td>身份证号</td><td>家庭住址</td><td>电话号</td><td>注册时间</td>" +
			"<td>账户余额</td><td>状态</td><td></td><td></td></tr>";
	for (var i = 1; i <= result.user.length; i++) {
		if (result.user[i - 1].status == 1) {
				html += "<tr><td>" + i + "</td>" + "<td>"
				+ result.user[i - 1].name + "</td>"+ "<td>"
				+ result.user[i - 1].userName + "</td>"+ "<td>"
				+ result.user[i - 1].userPwd + "</td>"+ "<td>"
				+ result.user[i - 1].gender + "</td>"+ "<td>"
				+ result.user[i - 1].idCard + "</td>"+ "<td>"
				+ result.user[i - 1].address + "</td>"+ "<td>"
				+ result.user[i - 1].telon + "</td>"+ "<td>"
				+ result.user[i - 1].regTime + "</td>"+ "<td>"
				+ result.user[i - 1].balance + "</td>"
				+ "<td><span style = 'color:green' id = userZhuangtai_"+result.user[i - 1].uid+">正常</span></td>"
				+ "<td><a href = 'javascript:stopUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">禁用</a></td></tr>"
		}else if(result.user[i - 1].status == 0){
			html += "<tr><td>" + i + "</td>" + "<td>"
			+ result.user[i - 1].name + "</td>"+ "<td>"
			+ result.user[i - 1].userName + "</td>"+ "<td>"
			+ result.user[i - 1].userPwd + "</td>"+ "<td>"
			+ result.user[i - 1].gender + "</td>"+ "<td>"
			+ result.user[i - 1].idCard + "</td>"+ "<td>"
			+ result.user[i - 1].address + "</td>"+ "<td>"
			+ result.user[i - 1].telon + "</td>"+ "<td>"
			+ result.user[i - 1].regTime + "</td>"+ "<td>"
			+ result.user[i - 1].balance + "</td>"
			+ "<td><span style = 'color:red' id = 'userZhuangtai_"+result.user[i - 1].uid+"'>停用</span></td>"
			+ "<td><a href = 'javascript:openUser("+ result.user[i - 1].uid+ ")' id = userZhuangtai_a"+result.user[i - 1].uid+">解封</a></td></tr>"
		}
		var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
        page +="<a href='javascript:finsusersQueryForTime(1);'>   [首页]   </a>";
        page +="<a href='javascript:finsusersQueryForTime("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
        page +="<a href='javascript:finsusersQueryForTime("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
        page +="<a href='javascript:finsusersQueryForTime("+result.adminPage.totalPage+")'>   [尾页]   </a>";
        page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
        $("#page").html(page);
	}
	$("#table_user").html(html);
	
		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}
	
	});
}

function checkUserForTime(){//checkUser_start_Time
	
	var adminForTimeCheck = {};
	adminForTimeCheck.start_time = $("#checkUser_start_Time").val()+" 00:00:00";
	adminForTimeCheck.end_time = $("#checkUser_end_Time").val()+" 00:00:00";
	adminForTimeCheck.initPage = 1 ;
	$.ajax({
		url : "../checkUserForTime_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminForTimeCheck),
		success : function(result){
			var html = "<tr><td>序号</td><td>姓名</td><td>用户名</td><td>密码</td>" +
			"<td>性别</td><td>身份证号</td><td>家庭住址</td><td>电话号</td><td>注册时间</td>" +
			"<td>账户余额</td><td>状态</td><td></td><td></td></tr>";
	for (var i = 1; i <= result.user.length; i++) {
		if (result.user[i - 1].status == 1) {
				html += "<tr><td>" + i + "</td>" + "<td>"
				+ result.user[i - 1].name + "</td>"+ "<td>"
				+ result.user[i - 1].userName + "</td>"+ "<td>"
				+ result.user[i - 1].userPwd + "</td>"+ "<td>"
				+ result.user[i - 1].gender + "</td>"+ "<td>"
				+ result.user[i - 1].idCard + "</td>"+ "<td>"
				+ result.user[i - 1].address + "</td>"+ "<td>"
				+ result.user[i - 1].telon + "</td>"+ "<td>"
				+ result.user[i - 1].regTime + "</td>"+ "<td>"
				+ result.user[i - 1].balance + "</td>"
				+ "<td><span style = 'color:green' id = userZhuangtai_"+result.user[i - 1].uid+">正常</span></td>"
				+ "<td><a href = 'javascript:stopUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">禁用</a></td></tr>"
		}else if(result.user[i - 1].status == 0){
			html += "<tr><td>" + i + "</td>" + "<td>"
			+ result.user[i - 1].name + "</td>"+ "<td>"
			+ result.user[i - 1].userName + "</td>"+ "<td>"
			+ result.user[i - 1].userPwd + "</td>"+ "<td>"
			+ result.user[i - 1].gender + "</td>"+ "<td>"
			+ result.user[i - 1].idCard + "</td>"+ "<td>"
			+ result.user[i - 1].address + "</td>"+ "<td>"
			+ result.user[i - 1].telon + "</td>"+ "<td>"
			+ result.user[i - 1].regTime + "</td>"+ "<td>"
			+ result.user[i - 1].balance + "</td>"
			+ "<td><span style = 'color:red' id = 'userZhuangtai_"+result.user[i - 1].uid+"'>停用</span></td>"
			+ "<td><a href = 'javascript:openUser("+ result.user[i - 1].uid+ ")' id = userZhuangtai_a"+result.user[i - 1].uid+">解封</a></td></tr>"
		}
		var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
        page +="<a href='javascript:finsusersQueryForTime(1);'>   [首页]   </a>";
        page +="<a href='javascript:finsusersQueryForTime("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
        page +="<a href='javascript:finsusersQueryForTime("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
        page +="<a href='javascript:finsusersQueryForTime("+result.adminPage.totalPage+")'>   [尾页]   </a>";
        page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
        $("#page").html(page);
	}
	$("#table_user").html(html);
	
		},
	error : function(status){
		alert("查询无结果,请更换查询条件");
	}
	});
}



function checkseeUserForField(){
	
	var adminCkeckUserForField = {};
	adminCkeckUserForField.name = "%"+$("#checkUser_name").val()+"%";
	adminCkeckUserForField.userName = "%"+$("#checkUser_userName").val()+"%";
	adminCkeckUserForField.idCard = "%"+$("#checkUser_idCard").val()+"%";
	adminCkeckUserForField.telon = "%"+$("#checkUser_telon").val()+"%";
	adminCkeckUserForField.current = 1 ;

	$.ajax({
		url : "../checkseeUserForField_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminCkeckUserForField),
		success : function(result){
			var html = "<tr><td>序号</td><td>姓名</td><td>用户名</td><td>密码</td>" +
			"<td>性别</td><td>身份证号</td><td>家庭住址</td><td>电话号</td><td>注册时间</td>" +
			"<td>账户余额</td><td>状态</td><td></td><td></td></tr>";
	for (var i = 1; i <= result.user.length; i++) {
		if (result.user[i - 1].status == 1) {
				html += "<tr><td>" + i + "</td>" + "<td>"
				+ result.user[i - 1].name + "</td>"+ "<td>"
				+ result.user[i - 1].userName + "</td>"+ "<td>"
				+ result.user[i - 1].userPwd + "</td>"+ "<td>"
				+ result.user[i - 1].gender + "</td>"+ "<td>"
				+ result.user[i - 1].idCard + "</td>"+ "<td>"
				+ result.user[i - 1].address + "</td>"+ "<td>"
				+ result.user[i - 1].telon + "</td>"+ "<td>"
				+ result.user[i - 1].regTime + "</td>"+ "<td>"
				+ result.user[i - 1].balance + "</td>"
				+ "<td><span style = 'color:green' id = userZhuangtai_"+result.user[i - 1].uid+">正常</span></td>"
				+ "<td><a href = 'javascript:stopUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">禁用</a></td></tr>"
		}else if(result.user[i - 1].status == 0){
			html += "<tr><td>" + i + "</td>" + "<td>"
			+ result.user[i - 1].name + "</td>"+ "<td>"
			+ result.user[i - 1].userName + "</td>"+ "<td>"
			+ result.user[i - 1].userPwd + "</td>"+ "<td>"
			+ result.user[i - 1].gender + "</td>"+ "<td>"
			+ result.user[i - 1].idCard + "</td>"+ "<td>"
			+ result.user[i - 1].address + "</td>"+ "<td>"
			+ result.user[i - 1].telon + "</td>"+ "<td>"
			+ result.user[i - 1].regTime + "</td>"+ "<td>"
			+ result.user[i - 1].balance + "</td>"
			+ "<td><span style = 'color:red' id = 'userZhuangtai_"+result.user[i - 1].uid+"'>停用</span></td>"
			+ "<td><a href = 'javascript:openUser("+ result.user[i - 1].uid+ ")' id = userZhuangtai_a"+result.user[i - 1].uid+">解封</a></td></tr>"
		}
		var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
        page +="<a href='javascript:finsusersQueryForField(1);'>   [首页]   </a>";
        page +="<a href='javascript:finsusersQueryForField("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
        page +="<a href='javascript:finsusersQueryForField("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
        page +="<a href='javascript:finsusersQueryForField("+result.adminPage.totalPage+")'>   [尾页]   </a>";
        page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
        $("#page").html(page);
	}
	$("#table_user").html(html);
	
		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}
	
	});
}

function finsusersQueryForField(currentPage){
	
	var adminCkeckUserForField = {};
	adminCkeckUserForField.name = "%"+$("#checkUser_name").val()+"%";
	adminCkeckUserForField.userName = "%"+$("#checkUser_userName").val()+"%";
	adminCkeckUserForField.idCard = "%"+$("#checkUser_idCard").val()+"%";
	adminCkeckUserForField.telon = "%"+$("#checkUser_telon").val()+"%";
	adminCkeckUserForField.current = currentPage ;

	$.ajax({
		url : "../checkseeUserForField_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminCkeckUserForField),
		success : function(result){
			var html = "<tr><td>序号</td><td>姓名</td><td>用户名</td><td>密码</td>" +
			"<td>性别</td><td>身份证号</td><td>家庭住址</td><td>电话号</td><td>注册时间</td>" +
			"<td>账户余额</td><td>状态</td><td></td><td></td></tr>";
	for (var i = 1; i <= result.user.length; i++) {
		if (result.user[i - 1].status == 1) {
				html += "<tr><td>" + i + "</td>" + "<td>"
				+ result.user[i - 1].name + "</td>"+ "<td>"
				+ result.user[i - 1].userName + "</td>"+ "<td>"
				+ result.user[i - 1].userPwd + "</td>"+ "<td>"
				+ result.user[i - 1].gender + "</td>"+ "<td>"
				+ result.user[i - 1].idCard + "</td>"+ "<td>"
				+ result.user[i - 1].address + "</td>"+ "<td>"
				+ result.user[i - 1].telon + "</td>"+ "<td>"
				+ result.user[i - 1].regTime + "</td>"+ "<td>"
				+ result.user[i - 1].balance + "</td>"
				+ "<td><span style = 'color:green' id = userZhuangtai_"+result.user[i - 1].uid+">正常</span></td>"
				+ "<td><a href = 'javascript:stopUser("+ result.user[i - 1].uid+")' id = userZhuangtai_a"+result.user[i - 1].uid+">禁用</a></td></tr>"
		}else if(result.user[i - 1].status == 0){
			html += "<tr><td>" + i + "</td>" + "<td>"
			+ result.user[i - 1].name + "</td>"+ "<td>"
			+ result.user[i - 1].userName + "</td>"+ "<td>"
			+ result.user[i - 1].userPwd + "</td>"+ "<td>"
			+ result.user[i - 1].gender + "</td>"+ "<td>"
			+ result.user[i - 1].idCard + "</td>"+ "<td>"
			+ result.user[i - 1].address + "</td>"+ "<td>"
			+ result.user[i - 1].telon + "</td>"+ "<td>"
			+ result.user[i - 1].regTime + "</td>"+ "<td>"
			+ result.user[i - 1].balance + "</td>"
			+ "<td><span style = 'color:red' id = 'userZhuangtai_"+result.user[i - 1].uid+"'>停用</span></td>"
			+ "<td><a href = 'javascript:openUser("+ result.user[i - 1].uid+ ")' id = userZhuangtai_a"+result.user[i - 1].uid+">解封</a></td></tr>"
		}
		var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
        page +="<a href='javascript:finsusersQueryForField(1);'>   [首页]   </a>";
        page +="<a href='javascript:finsusersQueryForField("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
        page +="<a href='javascript:finsusersQueryForField("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
        page +="<a href='javascript:finsusersQueryForField("+result.adminPage.totalPage+")'>   [尾页]   </a>";
        page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
        $("#page").html(page);
	}
	$("#table_user").html(html);
	
		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}
	
	});

}








function stopUser(u_id){
	var uid = u_id ;
	$.ajax({
		url : "../stopUser",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(uid),
		success : function(result){
			
			$("#userZhuangtai_"+uid).html("<span style = 'color:red' id = 'userZhuangtai_"+uid+"'>停用</span>");
			$("#userZhuangtai_a"+uid).html("<a href = 'javascript:openUser("+uid+ ")' id = userZhuangtai_a"+uid+">解封</a>");
			
		}
	
	});	
}

function backAllList(){
	window.location.reload();
}

function openUser(u_id){
	var uid = u_id ;
	$.ajax({
		url : "../openUser",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(uid),
		success : function(result){
			
			$("#userZhuangtai_"+uid).html("<span style = 'color:green' id = 'userZhuangtai_"+uid+"'>正常</span>");
			$("#userZhuangtai_a"+uid).html("<a href = 'javascript:stopUser("+uid+ ")' id = userZhuangtai_a"+uid+">禁用</a>");
			
		}
	
	});	
	
}







