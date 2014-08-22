<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />

<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
<%
	if (session.getAttribute("service") == null) {
		session.setAttribute("service", service);
	}
%>


<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Nick <%=service.getUserNickname(session.getAttribute("user"))%><br>
		Name <%=service.getUserName(session.getAttribute("user"))%><br>
		Surname <%=service.getUserSurname(session.getAttribute("user"))%><br>
		Education <%=service.getUserEducation(session.getAttribute("user"))%><br>
	</h1>
</body>
</html>