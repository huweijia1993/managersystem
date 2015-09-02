<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><s:text name="userInfo" /></h3>
	<s:debug />
	<s:form action="edit">
		<s:hidden key="userId"></s:hidden>
		<s:textfield key="userName" />
		<s:textfield key="userPassword" />
		<s:textfield key="userBirthday" />
		<s:textfield key="userGender" />
		<s:textfield key="userHeight" />
		<s:textfield key="userHometown" />
		
		<s:submit value="save" />
	</s:form>
	<s:property value="message"/>
	
</body>
</html>