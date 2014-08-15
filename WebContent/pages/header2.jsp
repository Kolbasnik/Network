<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends online</title>
<title>Friends online</title> 
	<script type="text/javascript">
		function validate() {
			var login=document.getElementById("login");
			var password=document.getElementById("password");
	
			if (login.value =="") {
				alert('login must be');
				return false;
			}
			if (password.value =="") {
				alert('password must be');
				return false;
			}
			return true;
		}
	</script>

 	<jsp:useBean id="ServiceImpl" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"></jsp:useBean> 

	<link rel="stylesheet" type="text/css" href="style.css" media="screen" />
	<link rel="stylesheet" type="text/css" href="css/superfish.css" media="screen">
	<link rel="stylesheet" type="text/css" href="css/prettyPhoto.css" media="screen"/>

	<div id="slider" class="header">
		<img src="images/slide1.jpg" alt="" title="#htmlcaption" alighn ="centre"/>
	</div>
</html>