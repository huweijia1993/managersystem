<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title></title>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap-responsive.css" />
    <link rel="stylesheet" type="text/css" href="css/style.css" />
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.sorted.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
    <script type="text/javascript" src="js/ckform.js"></script>
    <script type="text/javascript" src="js/common.js"></script>
    <style type="text/css">
        body {
            padding-bottom: 40px;
        }
        .sidebar-nav {
            padding: 9px 0;
        }

        @media (max-width: 980px) {
            /* Enable use of floated navbar text */
            .navbar-text.pull-right {
                float: none;
                padding-left: 5px;
                padding-right: 5px;
            }
        }


    </style>
    <script type="text/javascript">
    	function selectMonth(month){
    		var yearSelect=document.getElementById("year");
    		var yearValue=yearSelect.options[yearSelect.selectedIndex].value;
    		var monthValue=month.options[month.selectedIndex].value;
    		var day=document.getElementById("day");
    		if(monthValue==1||monthValue==3||monthValue==5||monthValue==7||monthValue==8||monthValue==10||monthValue==12){
    			//每月有31天
    			day.options.length=0;
    			for(var i=1;i<32;i++){
    				day.options.add(new Option(i,i));
    			}
    		}else if(monthValue==2){
    			//再分闰年与平年
    			if(yearValue%400==0||(year%4==0&&year%100!=0)){
    				//该年是闰年
    				day.options.length=0;
    				for(var i=1;i<30;i++){
    					day.options.add(new Option(i,i));
    				}
    			}else{
    				//该年是平年
    				day.options.length=0;
    				for(var i=1;i<29;i++){
    					day.options.add(new Option(i,i));
    				}
    			}
    		}else{
    			day.options.length=0;
				for(var i=1;i<31;i++){
					day.options.add(new Option(i,i));
				}
    		}
		
    	
    	}
    
    	function selectDay(day){
    		
    	}
    	
    	
    </script>
    
    
</head>
<body>
<form action="Register.action" method="post">
<h3 align="center"><s:text name="register" /></h3>
<table class="table table-bordered table-hover definewidth m10">
    <tr>
        <td width="10%" class="tableleft">用户名</td>
        <td><input type="text" name="userName" autofocus required value=""/></td>
    </tr>
    <tr>
        <td class="tableleft">密码</td>
        <td><input type="password" name="userPassword" required value=""/></td>
    </tr>       
    <tr>
        <td class="tableleft">重复密码</td>
        <td><input type="password" name="confirmUserPassword" required value=""/></td>
    </tr>   
    <tr>
        <td class="tableleft">性别</td>
        <td>
        	<input type="radio" name="userGender" value="M" checked="checked"  /><s:text name="male"></s:text>
        	<input type="radio" name="userGender" value="F"  /><s:text name="female"></s:text>
        	<input type="radio" name="userGender" value="O"  /><s:text name="other"></s:text>
        </td>
    </tr>
    <tr>
        <td class="tableleft">生日</td>
        <td>
        		<input type="date" name="userBirthday" />
        
<%--         	<select id="year"> --%>
<!--         		<option value="-1">年</option> -->
<%--         		<s:iterator begin="0" end="50" var="year"> --%>
<%--         			<option value="2015-${year}"><s:property value="2015-#year" /></option> --%>
<%--         		</s:iterator> --%>
<%--         	</select> --%>
<%--         	<select id="month" onchange="selectMonth(this)"> --%>
<!--         		<option value="-1">月</option> -->
<%--         		<s:iterator begin="1" end="12" var="month"> --%>
<%--         			<option value="${month}"><s:property value="#month" /></option> --%>
<%--         		</s:iterator> --%>
        	
<%--         	</select> --%>
<%--         	<select id="day" onchange="selectDay(this)"> --%>
<!--         		<option value="-1">日</option> -->
<%--         		<s:iterator  begin="1" end="30" var="day"> --%>
<%--         			<option value="${day}"> --%>
<%--         				<s:property value="#day"/> --%>
<!--         			</option> -->
<%--         		</s:iterator> --%>
<%--         	</select> --%>
        
        </td>
    </tr>
    <tr>
        <td class="tableleft">家乡</td>
        <td>
        	<input type="text" name="userHometown" />
        </td>
    </tr>
    <tr>
        <td class="tableleft">身高</td>
        <td>
        	<input type="text" name="userHeight" />
        </td>       
    </tr>
    
     <tr>
        <td class="tableleft">邮箱</td>   
        <td><input type="text" name="userEmail" /></td>    
    </tr>
    
    <tr>
        <td class="tableleft"></td>
        <td>
            <button type="submit" class="btn btn-primary" type="button">保存</button>&nbsp;&nbsp;<button type="button" class="btn btn-success" name="backid" id="backid">返回列表</button>
        </td>
    </tr>
</table>
</form>
</body>
</html>
<script>
    $(function () {       
		$('#backid').click(function(){
				window.location.href="c-index.jsp";
		 });
    });
</script>