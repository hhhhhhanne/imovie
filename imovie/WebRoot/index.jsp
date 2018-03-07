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
<title>imovie</title>
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/style.css" />
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>static/css/jquery-slide.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div id="content">
		<%@ include file="m14_b_index_1.jsp"%>
		<%@ include file="m14_b_index_3.jsp"%>
		<%@ include file="m14_b_index_2.jsp"%>
	</div>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery.min.js"></script>
	<script type="text/javascript"
		src="<%=basePath%>static/js/jquery.slide.js"></script>
	<script type="text/javascript" src="<%=basePath%>static/js/core.js"></script>
</body>
</html>