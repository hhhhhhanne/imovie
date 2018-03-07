<%@ page isErrorPage="true"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transition al.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Error</title>
<link rel="stylesheet" href="<%=basePath %>static/css/style.css" type="text/css" />
</head>
<body>
    <div style="float:right;width:190px;margin:10% 15% 0 0;">
        <div class="oblique-inverse arrow-btn">
            <a class="nbtn nbtn-white"  href="mailto:zhaoxh45@qq.com" >点击这里</a>
        </div>
        <div class="arrow-img">
            <img src="<%=basePath %>static/img/arrow.png"/>
        </div>
        <div class="oblique arrow-info"><strong>联系我们</strong></div>
    </div>
    <div class="clear"></div>
    <div class="error">
        <div class="error-title">500</div>
        <div class="error-bd">亲，服务器内部发生了错误，我们在加急修复！ :(</div>
    </div>
    <%
    	Throwable e = (Throwable)exception;
    	String msg = e.getMessage();
     %>
     <%// =msg %>
</body>
</html>
	