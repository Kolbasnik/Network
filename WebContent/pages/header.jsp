<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
<%
	if (session.getAttribute("service") == null) {
		session.setAttribute("service", service);
	}
%> 
<script type="text/javascript">
	function validate() {
		var login = document.getElementById("email");
		var password = document.getElementById("password");

		if (login.value == "") {
			alert('Enter email');
			return false;
		}
		if (password.value == "") {
			alert('Enter password');
			return false;
		}
		return true;
	}
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Friends online</title>

 
</head>
<body>
	<div class="header_menu">
		<ul>
			<li><a href="index.jsp">главная</a></li>
			<li><a href="users.jsp">Users</a></li>
			<li><a href="#">CSS</a></li>
			<li><a href="#" id="nowopen">PHP</a></li>
			
			<%if (session.getAttribute("user") == null) {%>
				<li><a href="register.jsp">Registration	</a>
			
				<form name="form_login" action="autorization" method="POST" onsubmit="return validate()">
					E-mail: <input type="text" id="email" name="email"> 
					Password: <input type="password" id="password" name="password"> 
					<input type="hidden" id="redirect" value=<%=request.getParameter("redirect")%>> 
					<input type="submit" value="Sing in"> 
				</form>
				<%} else {	%>
					<li><a href="profile.jsp">Hello, <%=service.getUserName(session.getAttribute("user"))%></a>
					<form name="form_logout" action="autorization" method="GET">
						<input type="submit" value="Exit">
					</form>
				<%}%>
		</ul>
	</div>


</body>
</html>