<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Demo Page</title>
</head>
<body>
	<s:a href="insert.action">增</s:a>
	<s:a href="delete.action">删</s:a>
	<s:a href="update.action">改</s:a>
	<s:a href="select.action">查</s:a>
	<hr />
	<p>select one:</p>
	<s:property value="demo.id"/>,
	<s:property value="demo.name"/>,
	<s:property value="demo.price"/>
	
	<hr />
	
	<p>select multi:</p>
	<s:iterator value="demolist">
		<s:property value="id"/>,
		<s:property value="name"/>,
		<s:property value="price"/>
		<br />
	</s:iterator>
</body>
</html>