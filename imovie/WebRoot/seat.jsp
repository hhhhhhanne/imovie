<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>选座</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div class="content">
		<div class="seat-sign">
			<ul>
				<li><a class="seat active"></a>可选座位</li>
				<li><a class="seat disabled"></a>不可选座位</li>
				<li><a class="seat selected"></a>已选座位</li>
				<li><a class="seat love"></a>情侣座位</li>
			</ul>
		</div>
		<div class="clear"></div>

		<div id="seats-info">
			<h2></h2>
			<div class="seat-content"></div>
		</div>
		<ul id="ticket">
		</ul>
		<div class="clear"></div>
		<div style="text-alien: center; margin: 30px auto; width: 106px;">
			<a class="nbtn nbtn-white" id="buybuybuy">确定购买</a>
		</div>
	</div>

	<div id="json" class="hidden">
		<s:property value="seats" />
	</div>
	<form id="form1" class="hidden">
		<s:textfield name="id" id="mid" value="%{id}" />
		<s:textfield name="cid" id="cid" value="%{cid}" />
		<s:textfield name="crid" id="crid" value="" />
	</form>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery.min.js"></script>
	<script type="text/javascript">
		function drawSeats(json) {
			var info = document.getElementById("seats-info");
			var content = info.getElementsByTagName("div")[0];
			for ( var rowid in json["info"]) {
				// 取出行

				var row = json["info"][rowid]["row"]["data"];
				var r_n = document.createElement("p");
				for ( var s in row) {
					var seat = document.createElement("a");
					var s_n = row[s];
					seat.setAttribute("title", s_n.title);
					seat.setAttribute("crid", s_n.crid);
					seat.setAttribute("href", "javascript:void(0);");
					if ('0' == s_n.type)
						seat.className = "seat";
					else
						seat.className = "seat love";
					if ('0' == s_n.statu) {
						seat.className += " active";// 未选定
						seat
								.addEventListener(
										"click",
										function() {
											var count = document
													.getElementsByClassName('selected');
											var tickets = document
													.getElementById("ticket");
											if (this.className
													.match(new RegExp(
															'(\\s|^)selected(\\s|$)'))) {
												this.className = this.className
														.replace(/selected/, "");

												var children = tickets.children;
												console.log(children.length);
												for (i = 0; i < children.length; i++) {
													if (children[i]
															.getAttribute("crid") == this
															.getAttribute("crid")) {
														tickets
																.removeChild(children[i]);
														break;
													}

												}
											} else {
												if (count.length < 5) {
													this.className += " selected";
													var tk = document
															.createElement("li");
													tk
															.setAttribute(
																	"crid",
																	this
																			.getAttribute("crid"));
													tk.innerHTML = this
															.getAttribute("title");
													tickets.appendChild(tk);
												} else {
													alert("最多选择4张票");
												}

											}
										});
					} else
						seat.className += " disabled";// 已选定
					r_n.appendChild(seat);
				}
				content.appendChild(r_n);
			}
		}

		// 绘图
		var jsonstr = document.getElementById("json").innerHTML;
		drawSeats(JSON.parse(jsonstr));

		buybuybuy.addEventListener("click", function() {
			var tickets = document.getElementById("ticket");
			var tk = tickets.children;
			if (tk.length > 0) {
				var tkstr = "";
				for (i = 0; i < tk.length; i++) {
					if (i == (tk.length - 1))
						tkstr += tk[i].getAttribute("crid");
					else
						tkstr += tk[i].getAttribute("crid") + ",";
				}
				document.getElementById("crid").value = tkstr;
				$.ajax({
					url : 'order',
					type : 'get',
					data : $('#form1').serialize(),
					async : false,
					dataType : "html",
					error : function() {
						alert('error');
					},
					success : function(data) {
						$("body").html(data);
					}
				});

			} else {
				alert('请选择座位！');
			}
		});
	</script>
</body>
</html>
