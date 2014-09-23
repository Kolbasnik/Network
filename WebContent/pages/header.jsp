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
	<div id="menu">
		<ul>
			<li><a href="index.jsp">Main</a></li>
			
		</ul>
	</div>

	
	<div class="left_menu">
	<H4>My Menu</H4>
	<%if (session.getAttribute("user") != null) {%>
	<h5>
		Hello, <%=service.getUserName(session.getAttribute("user"))%>
		
	</h5>
		<ul>
			<li><a href="ads">My ads</a></li>
			<li><a href="profile.jsp?friends">My groups</a></li>
			<li><a href="profile.jsp?page">My page</a>
			<li><a href="register.jsp">Registration	</a>
			<li><a href="profile.jsp">Hello, <%=service.getUserName(session.getAttribute("user"))%></a>
			<li><a href="autorization?exit">Exit</a></li>
		</ul>
	<%} 
	else {%>
		<ul>
			<form name="form_login" action="autorization" method="POST" onsubmit="return validate()">
			<table>
				<tr>
					<td>
						E-mail:
					</td>
					<td>
						<input type="text" id="email" name="email">
					</td>
				</tr>
				<tr>
					<td>
						Password: 
					</td>
					<td>
						<input type="password" id="password" name="password"> 
					</td>
				</tr>
				<tr> 
					<td>
					</td>
					<td>
						<input type="submit" value="Sing in">
					</td>
				</tr>
				</table> 
				</form>
		
			<li><a href="register.jsp">Register</a></li>
		</ul>
	<%}%>
	</div>
</body>
</html>