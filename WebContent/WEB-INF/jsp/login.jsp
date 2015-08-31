<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to the background</title>
</head>
<body>
	<h1>Login</h1>
	<s:form action="Login">
		<s:textfield name="user.userName" label="userName" ></s:textfield>
		<s:textfield name="user.userPassword" label="password"></s:textfield>
		<s:submit  />
	</s:form>
</body>
</html>