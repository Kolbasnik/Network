<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp" />
	<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
</head>
<body>
	<div class="left_menu">
	<%if (session.getAttribute("user") != null) {%>
		<ul>
			<li><a href="#messages">Messages</a></li>
			<li><a href="#groups">Groups</a></li>
			<li><a href="profile.jsp">Hello, <%=service.getUserName(session.getAttribute("user"))%></a>
					<form name="form_logout" action="autorization" method="GET">
						<input type="submit" value="Exit">
					</form>
		</ul>
	<%} 
	else {%>
		<ul>
			<li><a href="profile#singin" id="singin" onClick=singIn()>Sing in</a></li>
			<li><a href="profile#register" id="register" onClick=toMessage(register)>Register</a></li>
		</ul>
	<%}%>
	</div>
  	<div class="content">
		Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diem nonummy nibh 
		euismod tincidunt ut lacreet dolore magna aliguam erat volutpat. Ut wisis enim 
		ad minim veniam, quis nostrud exerci tution ullamcorper suscipit lobortis nisl 
		ut aliquip ex ea commodo consequat. Duis te feugifacilisi.
	</div>
 </body>
</html>