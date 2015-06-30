<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<body>
	<h2>this is login page</h2>
	<form action="../userlogin/login.ctrl" >
		<input type="text" value="${userInfo.name}" />
		<input type="password" value="${userInfo.pwd}" />

		<input type="checkbox"  />
	</form>
</body>
</html>
