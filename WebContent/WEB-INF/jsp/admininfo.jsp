<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">

	function pageCl(pageno){
		window.location.href="show.action?pageNo="+pageno;
	}


</script>


</head>
<body>
	<center>
	<table cellpadding="10"  cellspacing="0" border="1">
        <thead>
            <tr><td>用户id</td><td>用户名</td><td>密码</td><td>性别</td>
            <td>生日</td><td>家乡</td><td>身高</td><td>级别</td>
            <td>修改用户权限 </td><td>删除用户 </td></tr>
        </thead>
        <tbody>
          <s:iterator value="users" id="value"> 
             <tr>
             	
             	<td><s:property value="#value.userId"/></td>
             	<td><s:property value="#value.userName"/></td>
             	<td><s:property value="#value.userPassword"/></td>
             	<td><s:property value="#value.userGender"/></td>
             	<td><s:property value="#value.userBirthday"/></td>
             	<td><s:property value="#value.userHeight"/></td>
             	<td><s:property value="#value.userHometown"/></td>
             	<td><s:property value="#value.userLevel"/></td>
             
             </tr>
             </s:iterator>
        </tbody> 
     </table>
     		 <br />
     		<s:if test="pageNo>1">
             	 <a href="<s:url action='show' ><s:param name='pageNo' value='pageNo-1' /></s:url>">
             	 	上一页
             	 </a>
             </s:if>
             
     		<s:if test="pageNo>3">
     			<s:iterator begin="1" end="5" var="i">
     				<s:if test="#i==3">
     					<a  style="font: italic,bold;color: red;font-size: 15pt;"><s:property value="pageNo-3+#i" /></a>
     				</s:if>
     				<s:else>
	     				<a  href="<s:url action='show' ><s:param name='pageNo' value='pageNo-3+#i' /></s:url>">
	     					<s:property value="pageNo-3+#i"/>
	     				</a>
     				</s:else>
     				
     			</s:iterator>
     		</s:if>
     		<s:else>
     			<s:iterator begin="1" end="5" var="i">
     				<s:if test="pageNo==#i">
     					<a href="javascript:{0}" style="font: italic,bold;color: red;font-size: 15pt;"><s:property value="#i" /></a>
     				</s:if>
     				<s:else>
     					<a href="<s:url action='show' ><s:param name='pageNo' value='#i' /></s:url>">
     						<s:property value="#i"/>
     					</a>
     				</s:else>
     			
     			</s:iterator>
     		</s:else>
     		  <s:if test="pageNo<pageCount">
     		 	 <a href="<s:url action='show' ><s:param name='pageNo' value='pageNo+1' /></s:url>">
     					下一页
     				</a>
             </s:if>
     		
        </center>  
</body>
</html>