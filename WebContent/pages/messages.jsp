<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="header.jsp" />
</head>
<body>
	<center>
		<div style="color: teal; font-size: 30px">Being Java Guys |
			Registration Form</div>

		<form method="post" action="sendmessage">
			<table>
				<tr>
					<td>Receiver :</td>
					<td><input type="text" name="Receiver" /></td>
				</tr>
				<tr>
					<td>subject :</td>
					<td><input type="text" name="subject" /></td>
				</tr>
				<tr>
					<td>Text :</td>
					<td><input type="text" name="text" /></td>
				</tr>
				<tr>
					<td>&nbsp;</td>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>