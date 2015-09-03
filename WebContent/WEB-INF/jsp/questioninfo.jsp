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
		var inputpassword=document.getElementById("password");
		var repassword=inputpassword.value;
		alert(password+"ddd "+repassword)
		if(password==repassword){
			var editForm=document.getElementById("test");
			var checkPwd=document.getElementById("checkPwd");
			editForm.style.display="block";
			checkPwd.style.display='none';
		}else{
			alert("你输入的密码不正确");
		}
		
		
	}


</script>

</head>
<body>

	<s:debug />${user.userPassword}
	<s:property value="#session.user.userName"/>

	<s:if test="#session.user.userActive==0">
		<!-- 安全问题关闭 -->
		<s:form id="addForm" action="QuestionAdd">
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
		<div id="checkPwd">
			<h3>修改安全问题请先输入密码</h3>
			<input type="password" id="password"  />	
			<input type="button" onclick="checkPassword('${user.userPassword}')"	value="确认" />
		</div>
		<form style="display:none;" id="test" action="QuestionUpdate.action" method="post">
			<s:select list="questionList" name="questionId" 
				listKey="questionId" listValue="questionContent" key="question"/>
				<br />
			<s:textfield name="answer"  key="answer" /><br />
			<s:submit key="submit" />
		
		</form>
		
	
	</s:else>
	
	
</body>
</html>