<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">


<jsp:include page="header.jsp" />


</head>
<body>
		<%if (session.getAttribute("user") == null) {%>
			<form name="form_login" action="index.jsp" method="POST" onsubmit="return validate()">
			E-mail: <input type="text" id="login">
			Password: <input type="password" id="password">
			<input type="hidden" id="redirect" value='<%=request.getParameter("redirect")%>'>
			<input type="submit" value="Sing in">
			</form>
		<%}%>
		
<!--             
<jsp:useBean id="test" class="org.hillel.it.network.serviceImpl.SimpleBean" />
-->         
<H1>Message: <I>

<jsp:getProperty name="test" property="message" /> <br>

<a><jps:test.getMessage() /></a>
</I></H1>

</body>
</html>