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
	<h6>
		Hello, <%=service.getUserName(session.getAttribute("user"))%>
		
	</h6>
		<ul>
			<li><a href="profile.jsp?ads">My ads</a></li>
			<li><a href="profile.jsp?friends">Groups</a></li>
			<li><a href="profile.jsp?page">My page</a>
			<li><a href="register.jsp?exit" id="exit">Exit</a></li>
		</ul>
	<%} 
	else {%>
		<ul>
			<li><a href="register.jsp?singin" id="singin" >Sing in</a></li>
			<li><a href="register.jsp?register" id="register">Register</a></li>
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