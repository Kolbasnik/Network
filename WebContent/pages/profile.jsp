<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>
		Nick
		<%=session.getAttribute("nick")%></h1>
	<br>
	<h1>
		Name
		<%=session.getAttribute("name")%></h1>
	<br>
	<h1>
		E-mail
		<%=session.getAttribute("email")%></h1>
	<br>
	<h1>
		Job
		<%=session.getAttribute("job")%></h1>
	<br>
</body>
</html>