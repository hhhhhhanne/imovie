<%@ taglib prefix="s" uri="/struts-tags"%>
<div id="topbar">
	<div class="header">
		<div class="title">
			<span>i</span>movie
		</div>
		<div id="searchbox">
			<form method="get" action="search" >
				<input type="text" id="search"
					placeholder="We really have all the movies you want!" value=""
					name="s" autocomplete="off"> <input type="submit"
					id="searchButton" value="search">
			</form>
		</div>
		<s:if test="#session !=null && #session.status=='true'">
			<label class="info">您好，<s:property value="#session.username" /></label>
			<a class="btn" href="logout.action">登出</a>
			<a class="btn" href="myorders.jsp">订单</a>
		</s:if>
		<s:else>
			<label class="info">请登录</label>
			<a class="btn" href="logindialog.jsp">登录</a>
			<a class="btn" href="register.jsp">注册</a>
		</s:else>
	</div>
	<div class="clear"></div>
	<div class="navbar">
		<ul>
			<li><a href="index">首页</a></li>
			<li><a href="http://news.mtime.com">新闻</a></li>
			<li><a href="http://theater.mtime.com/">影院</a></li>
			<li><a href="http://mall.mtime.com/">商城</a></li>
			<li><a href="http://www.mtime.com/community/">社区</a></li>
			<li><a href="http://movie.mtime.com/">发现</a></li>
		</ul>
	</div>
</div>
<script type="text/javascript">
document.getElementById('searchButton').onclick = function() {
	var input = document.getElementById('search');
	if (input.value == "") {
		return false;
	}
}
</script>