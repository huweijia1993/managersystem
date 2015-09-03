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
	<s:debug></s:debug>
	
	<h3 align="center">密码重置</h3>
	<form action="checkAnswer.action" method="post">
		<h3>方式一：回管安全问题</h3>
		questionContent:<s:property value="model.questionContent" /> 
		<input type="text" name="inputanswer" />
		<input type="hidden" name="answer" value="<s:property value='model.answer' />" />
		<input type="submit" value="submit" />
	</form>
	
	
<%-- 	<s:form action="checkAnswer"> --%>
		
		
<%-- 		<s:textfield name="inputanswer" key="answer" /> --%>
<%-- 		<s:submit  key="submit" /> --%>
<%-- 	</s:form> --%>
	
	<s:form>
		<h3>方式二：邮箱重置</h3>
		<s:submit key="send mail to your mailbox" />
	</s:form>
	
</body>
</html>