<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sx" uri="/struts-dojo-tags" %>
<!DOCTYPE html>
<html>

<head>
  <s:head theme="xhtml"/> 
    <sx:head parseContent="true"/>    
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3><s:text name="userInfo" /></h3>
	<s:debug />
	<s:form action="edit">
		<s:hidden key="userId"></s:hidden>
		<s:textfield key="userPassword" />
	
		<sx:datetimepicker name="userBirthday" label="生日" displayFormat="yyyy-MM-dd" /> 
		<s:radio list="#{'M':'Male','F':'Female','O':'Other'}" name="userGender" 
			 label="性别"  value="userGender" />
		
		
		<s:textfield key="userHeight" />
		<s:textfield key="userHometown" />
		
		<s:submit value="save" />
	</s:form>
	  	
		  		
	<s:property value="message"/>
	
</body>
</html>