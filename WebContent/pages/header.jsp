<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<script type="text/javascript" src="js/validate.js"></script>
 	<script type="text/javascript" src="js/jquery.js"></script>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/ad.css">
 	<link rel="stylesheet" type="text/css" href="css/register.css"> 
	<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
	<%@ page import="org.hillel.it.network.model.entity.User"%>
<%
	if (session.getAttribute("service") == null) {
		session.setAttribute("service", service);
	}
%> 

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Стыковка</title>
</head>
<body>
	<div class="menu">
		<ul>
			<li><a href="index.jsp">Main</a></li>
		</ul>
	</div>

	<div class="left_menu"> <h5>Menu for 
		<%if (session.getAttribute("user") != null) {%>
			<%=service.getUserName(session.getAttribute("user"))%></h5>
			<%User user = (User)session.getAttribute("user");  %>
			<br>
			<h5>ID = <%=user.getId() %></h5>
			<ul>
				<%if (user.getAccesLevel() == 2) {%>
					<li><a href="ads?allads">All ads</a></li>
					<li><a href="ads?favorite">My favorite ads</a></li>
				<%}
				else {%>
					<li><a href="ads?myads">My ads</a></li>
				<%} %>
				<li><a href="profile.jsp?friends">My groups</a></li>
				<li><a href="profile.jsp?page">My page</a>
				<li><a href="autorization?exit">Exit</a></li>
			</ul>
		<%} else {%>
			</h5>
			<form name="form_login" action="autorization?login" method="POST" onsubmit="return validate()">
				<table>
					<tr>
						<td>E-mail:</td>
						<td><input type="text" id="email" name="email"></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="password" id="password" name="password"></td>
					</tr>
					<tr> 
						<td><input type="submit" class="show-btn" value="Sing in"></td>
						<td><a class="show-btn" href = "javascript:void(0)" onclick = "document.getElementById('register').style.display='block';document.getElementById('fade').style.display='block'">Register</a></td>
					</tr>
				</table> 
			</form>
		<%}%>
	</div>
	<div id="register" class="register">
		<a class="close-btn" title="Закрыть" href="javascript:void(0)" onclick = "document.getElementById('register').style.display='none';document.getElementById('fade').style.display='none'"></a>
		<div class="title">input your registration information</div>
			<form method="POST" action="autorization?register">
				<table>
					<tr>
						<td>Nick :</td>
						<td><input type="text" name="nickname"/></td>
					</tr>
					<tr>
						<td>Name :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>Surname :</td>
						<td><input type="text" name="surname" /></td>
					</tr>
					<tr>
						<td>Birth Day :</td>
						<td><input type="text" name="birthday" /></td>
					</tr>
					<tr>
						<td>Access level :</td>
						<td>
							<input type="radio" name="accesslevel" value="1" checked="true">User
							<input type="radio" name="accesslevel" value="2">Seller
						</td>
					</tr>
					<tr>
						<td>City :</td>
						<td>
							<select name="city">
								<option value="odessa">Odessa</option>
								<option value="kiev">Kiev</option>
								<option value="herson">Herson</option>
								<option value="balta">Balta</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>Email :</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Password :</td>
						<td><input type="text" name="password" /></td>
					</tr>
					<tr>
						<td><!--&nbsp;--></td>
						<td><input type="submit" value="Save"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="fade" class="black-overlay">
		</div>
	</body>
</html>