function see() {

	var adminForTimeCheck = {};
	adminForTimeCheck.start_time = $("#start_Time").val() + " 00:00:00";// end_Time
	adminForTimeCheck.end_time = $("#end_Time").val() + " 00:00:00";
	adminForTimeCheck.initPage = 1 ;

	$.ajax({
				url : "../admin_seeTicket_limit",
				type : "post",
				contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
				datatype : "json", // 数据格式----接收(后台返回的数据)
				data : JSON.stringify(adminForTimeCheck),
				success : function(result) {
					var html = "<tr><td>编号</td><td>车辆型号</td><td>到货时间</td><td>总辆数</td>	<td>剩余辆数</td><td>价格</td><td>状态</td><td></td><td></td></tr>";					for (var i = 1; i <= result.adminTicket.length; i++) {
						if (result.adminTicket[i - 1].balance > 0
								&& result.adminTicket[i - 1].status == 1) {

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
										+ "<span style = 'color:green;display:block' id = 'zhuangTai_"+result.adminTicket[i - 1].tid+"'>销售中</span>"
										+ "</td>" + "<td><a href = 'javascript:ticket_stop("+ result.adminTicket[i - 1].tid+ ")' id = 'zhuangTai_a"+result.adminTicket[i - 1].tid+"'>停售</a></td>";
										html += "<td><a href = javascript:update("
											+ result.adminTicket[i - 1].tid
											+ ")>修改本条数据</a></td>" + "</tr>";
						} else if (result.adminTicket[i - 1].balance > 0
								&& result.adminTicket[i - 1].status == 0) {
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
								+ "</td>"
									+ "<td><span style = 'color:gray'>无车</span></td>"
									+ "<td><span style = 'color:gray'>不可操作</span></td>"
									+ "<td><a href = javascript:update("
									+ result.adminTicket[i - 1].tid + ")>修改本条数据</a>"
									+ "</td>" + "</tr>";
						}

						var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
	                    page +="<a href='javascript:finsUsersQueryForTime(1);'>   [首页]   </a>";
	                    page +="<a href='javascript:finsUsersQueryForTime("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
	                    page +="<a href='javascript:finsUsersQueryForTime("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
	                    page +="<a href='javascript:finsUsersQueryForTime("+result.adminPage.totalPage+")'>   [尾页]   </a>";
	                    page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
	                    $("#page").html(page);
					}
					$("#table_ticket").html(html);
				},
				error : function(status) {
					alert("查询无结果,请更换查询条件");
				}

			});

}

function finsUsersQueryForTime(current){
	
	var adminForTimeCheck = {};
	adminForTimeCheck.start_time = $("#start_Time").val() + " 00:00:00";// end_Time
	adminForTimeCheck.end_time = $("#end_Time").val() + " 00:00:00";
	adminForTimeCheck.initPage = current ;
	
	$
	.ajax({
		url : "../admin_seeTicket_limit",
		type : "post",
		contentType : "application/json;charset=utf-8", // 提交数据的内容类型---发送
		datatype : "json", // 数据格式----接收(后台返回的数据)
		data : JSON.stringify(adminForTimeCheck),
		success : function(result) {
			var html = "<tr><td>编号</td><td>车辆型号</td><td>到货时间</td><td>总辆数</td>	<td>剩余辆数</td><td>价格</td><td>状态</td><td></td><td></td></tr>";			for (var i = 1; i <= result.adminTicket.length; i++) {
				if (result.adminTicket[i - 1].balance > 0
						&& result.adminTicket[i - 1].status == 1) {

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
					html += "<td>"
								+ "<span style = 'color:green;display:block' id = 'zhuangTai_"+result.adminTicket[i - 1].tid+"'>销售中</span>"
								+ "</td>" + "<td><a href = 'javascript:ticket_stop("+ result.adminTicket[i - 1].tid+ ")' id = 'zhuangTai_a"+result.adminTicket[i - 1].tid+"'>停售</a></td>";
								html += "<td><a href = javascript:update("+ result.adminTicket[i - 1].tid+ ")>修改本条数据</a></td>" + "</tr>";
				} else if (result.adminTicket[i - 1].balance > 0
						&& result.adminTicket[i - 1].status == 0) {
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
						+ "</td>"
							
							+ "<td><span style = 'color:gray'>无车</span></td>"
							+ "<td><span style = 'color:gray'>不可操作</span></td>"
							+ "<td><a href = javascript:update("
							+ result.adminTicket[i - 1].tid + ")>修改本条数据</a>"
							+ "</td>" + "</tr>";
				}

				var page = "<span>共"+result.adminPage.totalNumber+"条     第  "+result.adminPage.currentPage+" / "+result.adminPage.totalPage+" 页</span>";
                page +="<a href='javascript:finsUsersQueryForTime(1);'>   [首页]   </a>";
                page +="<a href='javascript:finsUsersQueryForTime("+(result.adminPage.currentPage-1)+");'>   [上一页]   </a>";
                page +="<a href='javascript:finsUsersQueryForTime("+(result.adminPage.currentPage+1)+");'>   [下一页]   </a>";
                page +="<a href='javascript:finsUsersQueryForTime("+result.adminPage.totalPage+")'>   [尾页]   </a>";
                page +="<a href='javascript:backAllList()'>   [返回总列表]   </a>";
                $("#page").html(page);
			}
			$("#table_ticket").html(html);
		},
		error : function(status){
			alert("查询无结果,请更换查询条件");
		}

	});

}

function backAllList(){
	window.location.reload();
}
	
/* 格式化日期 */
Date.prototype.format = function(fmt) { 
    var o = { 
       "M+" : this.getMonth()+1,                 // 月份
       "d+" : this.getDate(),                    // 日
       "h+" : this.getHours(),                   // 小时
       "m+" : this.getMinutes(),                 // 分
       "s+" : this.getSeconds(),                 // 秒
       "q+" : Math.floor((this.getMonth()+3)/3), // 季度
       "S"  : this.getMilliseconds()             // 毫秒
   }; 
   if(/(y+)/.test(fmt)) {
           fmt=fmt.replace(RegExp.$1, (this.getFullYear()+"").substr(4 - RegExp.$1.length)); 
   }
    for(var k in o) {
       if(new RegExp("("+ k +")").test(fmt)){
            fmt = fmt.replace(RegExp.$1, (RegExp.$1.length==1) ? (o[k]) : (("00"+ o[k]).substr((""+ o[k]).length)));
        }
    }
   return fmt; 
}
function formatDate(date){
	 var oldTime = (new Date(date)).getTime();
	 var curTime = new Date(oldTime).format("yyyy-MM-ddThh:mm");
	 return curTime;
}

function stop() {
	alert("该票已停止出售");
}
function begin() {
	alert("该票已开放购买");
}
