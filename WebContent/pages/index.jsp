<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="header.jsp" />
</head>
<body>
	<H1>
		Login <%=request.getAttribute("login")%><br>
		Password <%=request.getAttribute("passworsd")%><br>
	</H1>

</body>
</html>