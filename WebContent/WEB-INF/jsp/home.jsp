<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Gelios Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="js/jquery-1.7.2.min.js"></script>
<!-- Custom Theme files -->
<link href="css/style1.css" rel='stylesheet' type='text/css' />
<!-- Custom Theme files -->
<link href='http://fonts.useso.com/css?family=Playball' rel='stylesheet' type='text/css'>
<!----start-top-nav-script---->
		<script>
			$(function() {
				var pull 		= $('#pull');
					menu 		= $('nav ul');
					menuHeight	= menu.height();
				$(pull).on('click', function(e) {
					e.preventDefault();
					menu.slideToggle();
				});
				$(window).resize(function(){
	        		var w = $(window).width();
	        		if(w > 320 && menu.is(':hidden')) {
	        			menu.removeAttr('style');
	        		}
	    		});
			});
			
			
			function i18n(node){
				var index=node.selectedIndex;
				var value=node.options[index].value;
				if(value=="1"){
					//选中了中文
					window.location.href="Home.action?request_locale=zh";
				}else if(value=="0"){
					//选中了英文
					window.location.href="Home.action?request_locale=en";
				}
			}
			
			
		</script>
		<!----//End-top-nav-script---->
<script src="js/jquery.easydropdown.js"></script>
<!----- start-Share-instantly-slider---->
					 <!-- Prettify -->
						<link href="css/owl.carousel.css" rel="stylesheet">
					    <script src="js/owl.carousel.js"></script>
					<!----- //End-Share-instantly-slider---->
<script type="text/javascript" src="js/hover_pack.js"></script>
</head>
<body>
	<div class="header">
			<div class="container">
			  <div class="dropdown_box">
				   <select onchange="i18n(this)" class="dropdown" tabindex="10" data-settings='{"wrapperClass":"metro"}'>
            			<option value="0">English</option>	
						<option value="1">Chinese</option>
				   </select>
				   
				   
		       </div>
		       <div class="clearfix"></div>
		      <div class="header_top">
				<div class="logo">
				  <a href="index.html"><img src="images/logo.png" alt=""></a>
				</div>
		  		<div class="menu">
					<a class="toggleMenu" href="#"><img src="images/nav_icon.png" alt="" /> </a>
					<ul class="nav" id="nav">
					  <li class="current"><a href="index.html">Home</a></li>
					  <li><a href="LoginForm.action">Login</a></li>
					  <li><a href="register.action">Register</a></li>					  
					</ul>
					<script type="text/javascript" src="js/responsive-nav.js"></script>
				</div>							
	  			<div class="clearfix"> </div>
			    <!----//End-top-nav---->
			 </div>
			</div>
		</div>
		<!----//End-header---->

		<div class="banner">
			<div class="banner_container">
				<div class="wmuSlider example1">
					<div class="wmuSliderWrapper">
						<article style="position: absolute; width: 100%; opacity: 0;"> 
							<div class="banner_right">
								<h1>Welcome to <span class="color1">c</span>lps<span class="color1">.</span></h1>
								<h2>Family company!</h2>
								<a href="#" title="Online Reservation" class="btn btn-primary btn-normal btn-inline " target="_self">Read More about gelios</a>
							</div>
							<div class="clearfix"></div>
						</article>
							<article style="position: relative; width: 100%; opacity: 1;"> 
							<div class="banner_right">
								<h1>Welcome to <span class="color1">C</span>lps<span class="color1">.</span></h1>
								<h2>Clps is a company which has many excellent profession!</h2>
							</div>
							<div class="clearfix"></div>
						</article>
					</div>
						<a class="wmuSliderPrev">Previous</a><a class="wmuSliderNext">Next</a>
						<script src="js/jquery.wmuSlider.js"></script> 
						<script>
						$('.example1').wmuSlider();         
						</script> 	           	      
				</div>
			</div>
		</div>

</body>
</html>