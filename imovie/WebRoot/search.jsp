<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>搜索：${s}</title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div id="content">
		<p>${message}</p>
		<ul>
			<s:iterator value="movies">
				<li mid="<s:property value="mid"/>">
					<h3>
						<a href="movie?id=<s:property value="mid"/>"><s:property
								value="name" /> </a> <small>(<s:property value="year" />)
						</small>
					</h3> <s:if test="nickname != null">
						<i><small><s:property value="nickname" /></small></i>
					</s:if>
					<div>
						导演：
						<s:property value="director" />
					</div>
					<div>
						国家：
						<s:property value="country" />
					</div>
					<div>
						类型：
						<s:property value="type" />
					</div>
					<div>
						剧情：
						<s:property value="summary" />
					</div>
				</li>
			</s:iterator>
		</ul>
	</div>
	<%@ include file="bottom.jsp"%>

</body>
</html>