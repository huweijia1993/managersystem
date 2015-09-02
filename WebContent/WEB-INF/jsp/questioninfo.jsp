<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	function checkPassword(password){
		alert(password);
		var repassword=document.getElementById("password").value;
		alert(repassword);
	}


</script>

</head>
<body>

	<s:debug />
	<s:property value="#session.user.userName"/>

	<s:if test="#session.user.userActive==0">
		<!-- 安全问题关闭 -->
		<s:form action="QuestionAdd">
			<h3>安全问题没有设置，请设置安全问题</h3>
			<s:select list="questionList" name="questionId" 
				listKey="questionId" listValue="questionContent" key="question"/>
			<s:textfield name="answer"  key="answer" />
			<s:submit key="submit" />
		</s:form>	
		<s:property value="message"/>
	</s:if>
	<s:else>
		<!-- 安全问题开启 -->
		<h3>修改安全问题请先输入密码</h3>
		<input type="text" id="password"  />	
		<input type="button" onclick="checkPassword()"	value="确认" />
		<s:form style="display:none;" id="form" action="QuestionUpdate">
			<s:select list="questionList" name="questionId" 
				listKey="questionId" listValue="questionContent" key="question"/>
			<s:textfield name="answer"  key="answer" />
			<s:submit key="submit" />
		
		</s:form>
	
	
	</s:else>
	
	
</body>
</html>