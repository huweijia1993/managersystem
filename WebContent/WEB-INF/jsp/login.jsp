<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1.0,minimum-scale=0.5 maximum-scale=1.0" />
<title><s:text name="login" /></title>

<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css" />

<style type="text/css">
html,body{
	height:100%
}
.box {
	background-image:linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-o-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-moz-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-webkit-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	background-image:-ms-linear-gradient(bottom, #6699FF 0%, #6699FF 100%);
	
	margin: 0 auto;
	position: relative;
	width: 100%;
	height: 100%;
}
.login-box {
	width: 100%;
	max-width:500px;
	height: 400px;
	position: absolute;
	top: 50%;

	margin-top: -200px;
	/*设置负值，为要定位子盒子的一半高度*/
	
}
@media screen and (min-width:500px){
	.login-box {
		left: 50%;
		/*设置负值，为要定位子盒子的一半宽度*/
		margin-left: -250px;
	}
}	

.form {
	width: 100%;
	max-width:500px;
	height: 275px;
	margin: 25px auto 0px auto;
	padding-top: 25px;
}	
.login-content {
	height: 300px;
	width: 100%;
	max-width:500px;
	background-color: rgba(255, 250, 2550, .6);
	float: left;
}			
.input-group {
	margin: 0px 0px 30px 0px !important;
}
.form-control,
.input-group {
	height: 40px;
}

.form-group {
	margin-bottom: 0px !important;
}
.login-title {
	padding: 20px 10px;
	background-color: rgba(0, 0, 0, .6);
}
.login-title h1 {
	margin-top: 10px !important;
}
.login-title small {
	color: #fff;
}

.link p {
	line-height: 20px;
	margin-top: 30px;
}
.btn-sm {
	padding: 8px 24px !important;
	font-size: 16px !important;
}
</style>
</head>

<body>
<div class="box">
		<div class="login-box">
			<div class="login-title text-center">
				<h1><small><s:text name="login" /></small></h1>
			</div>
			<div class="login-content ">
			<div class="form">
			<form id="testForm" method="post" action="Login.action" >
				<div class="form-group">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-user"></span></span>
							<input type="text" id="username" name="userName" class="form-control" placeholder="用户名" autocomplete="off" autofocus required>
						</div>
					</div>
				</div>
				
				<div class="form-group">
					<div class="col-xs-12">
						<div class="input-group">
							<span class="input-group-addon"><span class="glyphicon glyphicon-lock"></span></span>
							<input type="text" id="password" name="userPassword" class="form-control" placeholder="密码" autocomplete="off" required>
						</div>
					</div>
				</div>
				
				<div class="form-group form-actions">
					<div class="col-xs-1 col-xs-offset-4 ">
						<button type="submit" class="btn btn-sm btn-info" ><span class="glyphicon glyphicon-off">
						</span><s:text name="login" /></button>	
					</div>
				</div>

				<div class="col-xs-11 link">
					<p class="text-center remove-margin"><small><s:text name="forgetpassword" /></small> 
						<a href="javascript:void(0)" ><small><s:text name="find"></s:text></small></a>
					</p>
				</div>
								
			</form>
			</div>
		</div>
	</div>
</div>

<% String judge1=(String)session.getAttribute("judge");
  if(judge1=="false")
     out.println("    ！您 的 账 号 或 者 密 码"+"<br>&nbsp"+" 不 正 确 ，请 重 新 输 入");  
  %>
  
<div style="text-align:center;">
<p><a href="#" target="_blank">clps官网</a></p>
</div>

</body>

</html>