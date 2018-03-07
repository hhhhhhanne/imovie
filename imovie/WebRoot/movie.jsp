<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><s:property value="movie.getName()" /></title>
<link rel="stylesheet" type="text/css" href="static/css/style.css" />
</head>
<body>
	<%@ include file="topbar.jsp"%>
	<div id="content">
		<div id="mp">
			<div class="main">
				<img src="<s:property value="movie.getImgurl()"/>" />
				<div class="main-info">
					<div class="title">
						<h3>
							<a href="#"><s:property value="movie.getName()" /></a>
						</h3>
						<span class="grade"> <sub><s:property
									value="movie.getSub()" /></sub> <sup>.<s:property
									value="movie.getSup()" /></sup>
						</span>
					</div>
					<div class="clear"></div>
					<p class="ui_summary_big">
						<span class="first"></span>
						<s:property value="movie.getSummary()" />
						<span></span>
					</p>
					<p>
						类型：
						<s:property value="movie.getType()" />
					</p>
					<p>
						年份：
						<s:property value="movie.getYear()" />
					</p>
					<p>
						国家：
						<s:property value="movie.getCountry()" />
					</p>
					<p>
						导演：
						<s:property value="movie.getDirector()" />
					</p>
				</div>

			</div>
			<div class="clear"></div>
			<ul style="list-style: none;">
				<s:iterator value="cinemas">
					<li>
						<ul class="ultb">
							<li><strong>影院</strong><br /> <s:property value="cinema" /></li>
							<li><strong>影厅</strong><br /> <s:property value="roomname" /></li>
							<li><strong>时间</strong><br /> <s:property value="starttime" /></li>
							<li><strong>类型</strong><br /> <s:property value="mptype" /></li>
							<li><strong>价格</strong><br /> <s:property value="price" /></li>
							<li><a href="seat?id=<s:property value="mid" />&cid=<s:property value="cid" />">选座</a></li>
						</ul>
						<div class="clear"></div>
					</li>
				</s:iterator>
			</ul>
		</div>

	</div>
	<%@ include file="bottom.jsp"%>
	<script type="text/javascript">
		
	</script>
</body>
</html>
