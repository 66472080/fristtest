window.onload = function() {
	var currentPage = 1 ;
	$
			.ajax({
				url : "../findOrders_limit",
				type : "post",
				contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
				datatype : "json", // 数据格式----接收(后台返回的数据)
				data : JSON.stringify(currentPage),
				success : function(result) {

					var html = "<tr><td>序号</td><td>订单号</td><td>订单内容</td><td>成交时间</td><td>金额</td>"
							+ "<td>姓名</td><td>用户名</td><td>身份证号</td></tr>";
					for (var i = 1; i <= result.adminOrderModel.length; i++) {

						html += "<tr><td>" + i + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].xuhao + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_dese + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_time + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_money + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_user_name + "</td>"
								+ "<td>" + result.adminOrderModel[i - 1].order_userName
								+ "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_userIdCard + "</td>"
								+ "<td>" + "</tr>"
					}
					var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
                    page +="<a href='javascript:findOrdersQuery_limit(1);'>   [首页]   </a>";
                    page +="<a href='javascript:findOrdersQuery_limit("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
                    page +="<a href='javascript:findOrdersQuery_limit("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
                    page +="<a href='javascript:findOrdersQuery_limit("+result.adminPage.totalPage+")'>   [尾页]   </a>";
                    
                    $("#page").html(page);
					
					$("#table_order").html(html);
				}
			});
}

function backAllList(){
	window.location.reload();
}
function findOrdersQuery_limit(page){
	var currentPage = page ;
	$
	.ajax({
		url : "../findOrders_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(currentPage),
		success : function(result) {

			var html = "<tr><td>序号</td><td>订单号</td><td>订单内容</td><td>成交时间</td><td>金额</td>"
					+ "<td>姓名</td><td>用户名</td><td>身份证号</td></tr>";
			for (var i = 1; i <= result.adminOrderModel.length; i++) {

				html += "<tr><td>" + i + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].xuhao + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_dese + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_time + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_money + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_user_name + "</td>"
						+ "<td>" + result.adminOrderModel[i - 1].order_userName
						+ "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_userIdCard + "</td>"
						+ "<td>" + "</tr>"
			}
			var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
            page +="<a href='javascript:findOrdersQuery_limit(1);'>   [首页]   </a>";
            page +="<a href='javascript:findOrdersQuery_limit("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
            page +="<a href='javascript:findOrdersQuery_limit("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
            page +="<a href='javascript:findOrdersQuery_limit("+result.adminPage.totalPage+")'>   [尾页]   </a>";
            $("#page").html(page);
			
			$("#table_order").html(html);
		}
	});
	
	
}


function checkOrderForTime() {

	var adminForTimeCheck = {};
	adminForTimeCheck.start_time = $("#checkOrder_start_Time").val()+" 00:00:00";
	adminForTimeCheck.end_time = $("#checkOrder_end_Time").val()+" 00:00:00";
	adminForTimeCheck.initPage = 1 ;
	$
			.ajax({
				url : "../checkOrderForTime_limit",
				type : "post",
				contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
				datatype : "json", // 数据格式----接收(后台返回的数据)
				data : JSON.stringify(adminForTimeCheck),
				success : function(result) {
					var html = "<tr><td>序号</td><td>订单号</td><td>订单内容</td><td>成交时间</td><td>金额</td>"
							+ "<td>姓名</td><td>用户名</td><td>身份证号</td></tr>";
					for (var i = 1; i <= result.adminOrderModel.length; i++) {

						html += "<tr><td>" + i + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].xuhao + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_dese + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_time + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_money + "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_user_name + "</td>"
								+ "<td>" + result.adminOrderModel[i - 1].order_userName
								+ "</td>" + "<td>"
								+ result.adminOrderModel[i - 1].order_userIdCard + "</td>"
								+ "<td>" + "</tr>"
					}

					var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
                    page +="<a href='javascript:findOrdersQueryForTime_limit(1);'>   [首页]   </a>";
                    page +="<a href='javascript:findOrdersQueryForTime_limit("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
                    page +="<a href='javascript:findOrdersQueryForTime_limit("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
                    page +="<a href='javascript:findOrdersQueryForTime_limit("+result.adminPage.totalPage+")'>   [尾页]   </a>";
                    page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
                    $("#page").html(page);
		            
					$("#table_order").html(html);

				}
			});
}


function findOrdersQueryForTime_limit(page){
	var adminForTimeCheck = {};
	adminForTimeCheck.start_time = $("#checkOrder_start_Time").val()+" 00:00:00";
	adminForTimeCheck.end_time = $("#checkOrder_end_Time").val()+" 00:00:00";
	adminForTimeCheck.initPage = page ;
	$
	.ajax({
		url : "../checkOrderForTime_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminForTimeCheck),
		success : function(result) {
			var html = "<tr><td>序号</td><td>订单号</td><td>订单内容</td><td>成交时间</td><td>金额</td>"
					+ "<td>姓名</td><td>用户名</td><td>身份证号</td></tr>";
			for (var i = 1; i <= result.adminOrderModel.length; i++) {

				html += "<tr><td>" + i + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].xuhao + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_dese + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_time + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_money + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_user_name + "</td>"
						+ "<td>" + result.adminOrderModel[i - 1].order_userName
						+ "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_userIdCard + "</td>"
						+ "<td>" + "</tr>"
			}

			var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
            page +="<a href='javascript:findOrdersQueryForTime_limit(1);'>   [首页]   </a>";
            page +="<a href='javascript:findOrdersQueryForTime_limit("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
            page +="<a href='javascript:findOrdersQueryForTime_limit("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
            page +="<a href='javascript:findOrdersQueryForTime_limit("+result.adminPage.totalPage+")'>   [尾页]   </a>";
            page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
            $("#page").html(page);
            
			$("#table_order").html(html);

		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}
	});
	
}


function checkseeOrderForField(){

	var adminOrderModel = {};
	adminOrderModel.order_user_name = "%"+$("#checkOrder_name").val()+"%";
	adminOrderModel.order_userName = "%"+$("#checkOrder_userName").val()+"%";
	adminOrderModel.order_userIdCard = "%"+$("#checkOrder_idCard").val()+"%";
	adminOrderModel.order_id = "%"+$("#checkOrder_id").val()+"%";
	adminOrderModel.current = 1 ;
	$
	.ajax({
		url : "../checkseeOrderForField_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminOrderModel),
		success : function(result) {
			var html = "<tr><td>序号</td><td>订单号</td><td>订单内容</td><td>成交时间</td><td>金额</td>"
					+ "<td>姓名</td><td>用户名</td><td>身份证号</td></tr>";
			for (var i = 1; i <= result.adminOrderModel.length; i++) {

				html += "<tr><td>" + i + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].xuhao + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_dese + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_time + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_money + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_user_name + "</td>"
						+ "<td>" + result.adminOrderModel[i - 1].order_userName
						+ "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_userIdCard + "</td>"
						+ "<td>" + "</tr>"
			}
			var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
            page +="<a href='javascript:findOrdersQueryForField_limit(1);'>   [首页]   </a>";
            page +="<a href='javascript:findOrdersQueryForField_limit("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
            page +="<a href='javascript:findOrdersQueryForField_limit("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
            page +="<a href='javascript:findOrdersQueryForField_limit("+result.adminPage.totalPage+")'>   [尾页]   </a>";
            page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
            $("#page").html(page);

			$("#table_order").html(html);

		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}
	});
}

function findOrdersQueryForField_limit(page){
	var adminOrderModel = {};
	adminOrderModel.order_user_name = "%"+$("#checkOrder_name").val()+"%";
	adminOrderModel.order_userName = "%"+$("#checkOrder_userName").val()+"%";
	adminOrderModel.order_userIdCard = "%"+$("#checkOrder_idCard").val()+"%";
	adminOrderModel.order_id = "%"+$("#checkOrder_id").val()+"%";
	adminOrderModel.current = page ;
	$
	.ajax({
		url : "../checkseeOrderForField_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminOrderModel),
		success : function(result) {
			var html = "<tr><td>序号</td><td>订单号</td><td>订单内容</td><td>成交时间</td><td>金额</td>"
					+ "<td>姓名</td><td>用户名</td><td>身份证号</td></tr>";
			for (var i = 1; i <= result.adminOrderModel.length; i++) {

				html += "<tr><td>" + i + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].xuhao + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_dese + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_time + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_money + "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_user_name + "</td>"
						+ "<td>" + result.adminOrderModel[i - 1].order_userName
						+ "</td>" + "<td>"
						+ result.adminOrderModel[i - 1].order_userIdCard + "</td>"
						+ "<td>" + "</tr>"
			}
			var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
            page +="<a href='javascript:findOrdersQueryForField_limit(1);'>   [首页]   </a>";
            page +="<a href='javascript:findOrdersQueryForField_limit("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
            page +="<a href='javascript:findOrdersQueryForField_limit("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
            page +="<a href='javascript:findOrdersQueryForField_limit("+result.adminPage.totalPage+")'>   [尾页]   </a>";
            page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
            $("#page").html(page);

			$("#table_order").html(html);

		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}
	
	});
	
}




