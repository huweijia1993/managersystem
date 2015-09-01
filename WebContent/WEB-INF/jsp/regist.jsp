<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<h2 style="color:red">浏览器崩溃，CSS无法加载！！！！！！！</h2>
<table>
<s:form action="" method="post">
	<s:textfield name="user.userName"></s:textfield>
	<s:textfield name="user.password"></s:textfield>
	<s:textfield name="user.gender"></s:textfield>
	<s:textfield name="user.birthday"></s:textfield>
	<s:textfield name="user.hometown"></s:textfield>
	
	<tr><td></td><td><select name="userqa.questionId">	
		<s:iterator value="#request.list" id="q">
			<option value=<s:property value="#q.questionId"/>><s:property value="#q.questionContent"/></option>
		</s:iterator>
	</select>
	</td></tr>
	
	<s:textfield name="userqa.answer"></s:textfield>
	<s:submit value="哈哈哈"></s:submit>
</s:form>

</table>
</body>
</html>