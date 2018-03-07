<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div id="content">
	<div class="cartlist">
	<dl>
		<dt class="cartfix"> 
			<b class="c1"> 
				<b method="checkall" class="" pan=""></b>
				选择</b> 
			<b>商品信息</b> 
			<b>单价</b> 
			<b>数量</b> 
			<b>小计</b> 
			<b>操作</b> 
			</dt>
	</dl>
	<dl><dt><dd></dd></dt></dl>
	</div>
	<div id="gotopay">
	<p>共 件商品，商品总价(不含运费):</p>
	<s:submit value="去结算" id="topay" />
	</div>
	</div>
	<%@ include file="bottom.jsp"%>
</body>
</html>