<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的订单</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div id="content">
		<div id="mp"></div>
	</div>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery.min.js"></script>
	<script type="text/javascript">
		$(function() {
			var mp = $("#mp");
			$
					.ajax({
						type : "GET",
						url : "myorders.action",
						data : null,
						dataType : "json",
						success : function(json) {
							if (json ==0) {
								alert("您的订单为空!");
							} else {
								var orders = json["orders"][0];
								for ( var rowid in orders) {
									// 多个订单
									var order = $('<div>', {
										'class' : 'datetime'
									});
									var datetime = orders[rowid]["datetime"][0].createdatetime;
									order.append("<strong>订单时间：" + datetime
											+ "</strong>")
									var tickets = orders[rowid]["ticket"];
									var ul = $("<ul>", {
										"class" : "ticketlist"
									});
									for ( var id in tickets) {
										var movie = $("<li>" + tickets[id].name
												+ "</li>");
										var price = $("<li>价钱："
												+ tickets[id].price + "</li>");
										var cinema = $("<li>影院："
												+ tickets[id].cinema + "</li>");
										var starttime = $("<li>放映时间："
												+ tickets[id].starttime
												+ "</li>");
										var seat = $("<li>座位："
												+ tickets[id].seat_x + "排"
												+ tickets[id].seat_y + "列</li>");
										var roomname = $("<li>映厅："
												+ tickets[id].roomname
												+ "</li>");
										ul.append($("<li>", {
											"class" : "nullline"
										}));
										ul.append(movie);
										ul.append(price);
										ul.append(cinema);
										ul.append(starttime);
										ul.append(seat);
										ul.append(roomname);

									}
									order.append(ul);
									mp.append(order);
									mp.append($("<div>", {
										"class" : "clear"
									}));
								}
							}

						}
					});
		})
	</script>
</body>
</html>