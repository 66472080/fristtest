
window.onload = function() {
	
	var initPage = 1 ;
	
	$
			.ajax({
				url : "../findTickets_limit",
				type : "post",
				contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
				datatype : "json", // 数据格式----接收(后台返回的数据)
				data : JSON.stringify(initPage),
				success : function(result) {

					var html = "<tr><td>编号</td><td>车辆型号</td><td>到货时间</td><td>总辆数</td>	<td>剩余辆数</td><td>价格</td><td>状态</td><td></td><td></td></tr>";
					for (var i = 1; i <= result.adminTicket.length; i++) {
						if (result.adminTicket[i - 1].balance > 0 && result.adminTicket[i - 1].status == 1) {

							html += "<tr><td>"
								+ i
								+ "</td>"
								+ "<td id = 'dese"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].dese
								+ "</td>"
								+ "<td id = 'startTime"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].startTime
								+ "</td>"
								+ "<td id = 'amount"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].amount
								+ "</td>"
								+ "<td id = 'balance"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].balance
								+ "</td>"
								+ "<td id = 'price"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].price
								+ "</td>";
							html += "<td><span style = 'color:green' id = 'zhuangTai_"+result.adminTicket[i - 1].tid+"'>售票中</span></td>" ;
							html +="<td><a href = 'javascript:ticket_stop("+ result.adminTicket[i - 1].tid+ ")' id = 'zhuangTai_a"+result.adminTicket[i - 1].tid+"'>停售</a></td>"
							"</td>"
							html += "<td><a href = javascript:update("
									+ result.adminTicket[i - 1].tid
									+ ")>修改本条数据</a></td>" + "</tr>";
							html += "";
						} else if (result.adminTicket[i - 1].balance > 0 && result.adminTicket[i - 1].status == 0) {
							html += "<tr><td>"
									+ i
									+ "</td>"
									+ "<td id = 'dese"+result.adminTicket[i - 1].tid+"'>"
									+ result.adminTicket[i - 1].dese
									+ "</td>"
									+ "<td id = 'startTime"+result.adminTicket[i - 1].tid+"'>"
									+ result.adminTicket[i - 1].startTime
									+ "</td>"
									+ "<td id = 'amount"+result.adminTicket[i - 1].tid+"'>"
									+ result.adminTicket[i - 1].amount
									+ "</td>"
									+ "<td id = 'balance"+result.adminTicket[i - 1].tid+"'>"
									+ result.adminTicket[i - 1].balance
									+ "</td>"
									+ "<td id = 'price"+result.adminTicket[i - 1].tid+"'>"
									+ result.adminTicket[i - 1].price
									+ "</td>"
									+ "<td>"
									+ "<span style = 'color:red' id = 'zhuangTai_"+result.adminTicket[i - 1].tid+"'>已停售</span>"
									+ "</td>" + "<td><a href = 'javascript:ticket_begin("+ result.adminTicket[i - 1].tid+ ")' id = 'zhuangTai_a"+result.adminTicket[i - 1].tid+"'>开启售票</a></td>"
									+ "<td><a href = javascript:update("+result.adminTicket[i - 1].tid+")>修改本条数据</a></td>"
									+ "</tr>";
						} else if (result.adminTicket[i - 1].balance == 0
								|| result.adminTicket[i - 1].status == 2) {
							html += "<tr><td>"
								+ i
								+ "</td>"
								+ "<td id = 'dese"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].dese
								+ "</td>"
								+ "<td id = 'startTime"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].startTime
								+ "</td>"
								+ "<td id = 'amount"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].amount
								+ "</td>"
								+ "<td id = 'balance"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].balance
								+ "</td>"
								+ "<td id = 'price"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].price
								+ "</td>" +
											"<td>"
									+ "<span style = 'color:gray'>无车</span>"
									+ "</td>"
									+ "<td><span style = 'color:gray'>不可操作</span></td>"
									+ "<td><a href = javascript:update("
									+ result.adminTicket[i - 1].tid + ")>修改本条数据</a></td>"
									+ "</tr>";
						}
						var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
	                    page +="<a href='javascript:finsticketsQuery(1);'>   [首页]   </a>";
	                    page +="<a href='javascript:finsticketsQuery("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
	                    page +="<a href='javascript:finsticketsQuery("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
	                    page +="<a href='javascript:finsticketsQuery("+result.adminPage.totalPage+")'>   [尾页]   </a>";
	                    $("#page").html(page);
					}
					$("#table_ticket").html(html);
					
					
			
				},
				error : function(status){
					alert("查询无结果,请更换查询条件");
				}
			});
}


function finsticketsQuery(currentPage){
	
		var goPage = currentPage ;
	
	$
			.ajax({
				url : "../findTickets_limit",
				type : "post",
				contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
				datatype : "json", // 数据格式----接收(后台返回的数据)
				data : JSON.stringify(goPage),
				success : function(result) {

					var html = "<tr><td>编号</td><td>车辆型号</td><td>到货时间</td><td>总辆数</td>	<td>剩余辆数</td><td>价格</td><td>状态</td><td></td><td></td></tr>";					for (var i = 1; i <= result.adminTicket.length; i++) {
						if (result.adminTicket[i - 1].balance > 0 && result.adminTicket[i - 1].status == 1) {

							html += "<tr><td>"
								+ i
								+ "</td>"
								+ "<td id = 'dese"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].dese
								+ "</td>"
								+ "<td id = 'startTime"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].startTime
								+ "</td>"
								+ "<td id = 'amount"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].amount
								+ "</td>"
								+ "<td id = 'balance"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].balance
								+ "</td>"
								+ "<td id = 'price"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].price
								+ "</td>" +
										"<td>"
								+ "<span style = 'color:green;display:block' id = 'zhuangTai_"+result.adminTicket[i - 1].tid+"'>销售中</span>"
								+ "</td>" + "<td><a href = 'javascript:ticket_stop("+ result.adminTicket[i - 1].tid+ ")' id = 'zhuangTai_a"+result.adminTicket[i - 1].tid+"'>停售</a></td>";
								html += "<td><a href = javascript:update("
									+ result.adminTicket[i - 1].tid
									+ ")>修改本条数据</a></td>" + "</tr>";
							html += "";
						} else if (result.adminTicket[i - 1].balance > 0 && result.adminTicket[i - 1].status == 0) {
							html += "<tr><td>"
								+ i
								+ "</td>"
								+ "<td id = 'dese"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].dese
								+ "</td>"
								+ "<td id = 'startTime"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].startTime
								+ "</td>"
								+ "<td id = 'amount"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].amount
								+ "</td>"
								+ "<td id = 'balance"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].balance
								+ "</td>"
								+ "<td id = 'price"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].price
								+ "</td>" +
											"<td>"
									+ "<span style = 'color:red' id = 'zhuangTai_"+result.adminTicket[i - 1].tid+"'>已停售</span>"
									+ "</td>" + "<td><a href = 'javascript:ticket_begin("+ result.adminTicket[i - 1].tid+ ")' id = 'zhuangTai_a"+result.adminTicket[i - 1].tid+"'>开启售票</a></td>"
									+ "<td><a href = javascript:update("+result.adminTicket[i - 1].tid+")>修改本条数据</a></td>"
									+ "</tr>";
						} else if (result.adminTicket[i - 1].balance == 0
								|| result.adminTicket[i - 1].status == 2) {
							html += "<tr><td>"
								+ i
								+ "</td>"
								+ "<td id = 'dese"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].dese
								+ "</td>"
								+ "<td id = 'startTime"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].startTime
								+ "</td>"
								+ "<td id = 'amount"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].amount
								+ "</td>"
								+ "<td id = 'balance"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].balance
								+ "</td>"
								+ "<td id = 'price"+result.adminTicket[i - 1].tid+"'>"
								+ result.adminTicket[i - 1].price
								+ "</td>"
									+ "</td><td><span style = 'color:gray'>无车</span></td>"
									+ "<td><span style = 'color:gray'>不可操作</span></td>"
									+ "<td><a href = javascript:update("
									+ result.adminTicket[i - 1].tid + ")>修改本条数据</a></td>"
									+ "</tr>";
						}
						var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
	                    page +="<a href='javascript:finsticketsQuery(1);'>   [首页]   </a>";
	                    page +="<a href='javascript:finsticketsQuery("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
	                    page +="<a href='javascript:finsticketsQuery("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
	                    page +="<a href='javascript:finsticketsQuery("+result.adminPage.totalPage+")'>   [尾页]   </a>";
	                    $("#page").html(page);
					}
					$("#table_ticket").html(html);
				}
			});
}


function update(tid){
	
	var div = document.getElementById("div_updateTicket");
	div.style.display = "block";
	
	var adminTicket = {};
	adminTicket.tid = tid ;
	
	$.ajax({
		url : "../updateTicket",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminTicket),
		success : function(result){
			for(var i = 1 ; i <= result.length ; i++){
				$("#span_10").html("<input style='display:none' type = 'text' name = 'update_tid' id = 'update_tid' value = '"+result[i-1].tid+"'/>");
				$("#span_1").html("名&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称:<input type = 'text' name = 'update_dese' id = 'update_dese' value = '"+result[i-1].dese+"'/>");
				$("#span_2").html("派送时间:<input type='datetime-local' id = 'update_startTime' name='update_startTime' value = '"+formatDate(result[i-1].startTime)+"'/>");
				$("#span_3").html("总&nbsp;&nbsp;辆&nbsp;&nbsp;数:<input type = 'text' id ='update_amount'  name = 'update_amount' value = '"+result[i-1].amount+"'>");
				$("#span_9").html("剩余票数:<input type = 'text' id ='update_balance'  name = 'update_balance' value = '"+result[i-1].balance+"'>");
				$("#span_4").html("价&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;格:<input type = 'text' id ='update_price'  name = 'update_price' value = '"+result[i-1].price+"'/>");
				$("#span_5").html("状&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;态:<input type = 'radio' id ='update_status'  name = 'update_status' value = '1' />正常销售");
				$("#span_6").html("<input type = 'radio' id ='update_status'  name = 'update_status' value = '0' />暂不销售");
				$("#span_7").html("<input type = 'button' onclick = 'adminUpdateTicket()' value = '更改数据'>");
				$("#span_8").html("<input type = 'button' onclick = 'exitUpdateTicket()' value = '取消更改'>");
			}
		}
	});
}

function exitUpdateTicket(){
	var div = document.getElementById("div_updateTicket");
	div.style.display = "none";
}

function adminUpdateTicket(){
	var adminTicke = {};
	adminTicke.tid = $("#update_tid").val();
	adminTicke.dese = $("#update_dese").val();
	adminTicke.startTime = $("#update_startTime").val();
	adminTicke.amount =Number( $("#update_amount").val());
	adminTicke.balance =Number( $("#update_balance").val());
	adminTicke.price = Number($("#update_price").val());
	adminTicke.status = $("input[name='update_status']:checked").val();
	var id = adminTicke.tid ;
	$.ajax({
		url : "../adminupdateTicket",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminTicke),
		success : function(result){
			alert("修改成功");
			var div = document.getElementById("div_updateTicket");
			div.style.display = "none";
			$("#dese"+id).html(adminTicke.dese);
			$("#startTime"+id).html(adminTicke.startTime);
			$("#amount"+id).html(adminTicke.amount);
			$("#balance"+id).html(adminTicke.balance);
		$("#price"+id).html(adminTicke.price);//zhuangTai_
		
		if(adminTicke.balance != 0 && adminTicke.status == 1){
			$("#zhuangTai_"+id).html("<span style = 'color:green'>售票中</span>");
			//<a href = 'javascript:ticket_begin("+ result.adminTicket[i - 1].tid+ ")' id = zhuangTai_a"+result.adminTicket[i - 1].tid+">开启售票</a>
			$("#zhuangTai_a"+id).html("<a href = 'javascript:ticket_stop("+id+ ")' id = zhuangTai_a"+id+">停售</a>");
		}else if(adminTicke.balance != 0 && adminTicke.status == 0){
			$("#zhuangTai_"+id).html("<span style = 'color:red'>已停售</span>");
			$("#zhuangTai_a"+id).html("<a href = 'javascript:ticket_begin("+id+ ")' id = zhuangTai_a"+id+">开启售票</a>");
		}else if(adminTicke.balance == 0 || adminTicke.status == 2){
			$("#zhuangTai_"+id).html("<span style = 'color:gray'>无车</span>");
			$("#zhuangTai_a"+id).html("");
		}
		
		},
		error : function(status){
			alert("操做失败");
		}
	});
}


function addTicket() {
	var div = document.getElementById("div_addTicket");
	div.style.display = "block";

}

function exitAddTicket() {
	var div = document.getElementById("div_addTicket");
	div.style.display = "none";

}



function adminAddTicket(){
	var adminTicket = {};
	adminTicket.dese = $("#dese").val();
	adminTicket.startTime = $("#startTime").val();
	adminTicket.amount =Number( $("#amount").val());
	adminTicket.balance =Number( $("#amount").val());
	adminTicket.price = Number($("#price").val());
	adminTicket.status = $("input[name='status']:checked").val();

	$.ajax({
		url : "../admin_AddTicket",
		type : "post",
		contentType : "application/json;charset=utf-8", //提交数据的内容类型---发送
		datatype : "json",  //数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminTicket),
		success : function(result){
			alert("添加成功,点击返回");
			window.location.href = "http://localhost:8080/java-web-e_business_platform/views/adminTicketMng.html";
		},
		error: function(status){
			alert("信息填写有误");
		},
	
	});

}


function stop(){	
	alert("该票已停止出售");
}
function begin(){
	alert("该票已开放购买");
}

function ticket_stop(id){

	var tid = id ;
	$.ajax({
	url : "../stop_Sall",
	type : "post",
	contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
	datatype : "json", // 数据格式----接收(后台返回的数据)
	data : JSON.stringify(tid),
	success : function(result) {
		
		$("#zhuangTai_"+tid).html("<span style = 'color:red'>已停售</span>");
		$("#zhuangTai_a"+tid).html("<a href = 'javascript:ticket_begin("+ tid+ ")' id = zhuangTai_a"+tid+">开启销售</a>");
	}
	});
}

function ticket_begin(id){
	var tid = id ;
	$.ajax({
	url : "../begin_Sall",
	type : "post",
	contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
	datatype : "json", // 数据格式----接收(后台返回的数据)
	data : JSON.stringify(tid),
	success : function(result) {
		
		$("#zhuangTai_"+tid).html("<span style = 'color:green'>销售中</span>");
		$("#zhuangTai_a"+tid).html("<a href = 'javascript:ticket_stop("+ tid+ ")' id = zhuangTai_a"+tid+">停售</a>");
	}
	});
}










