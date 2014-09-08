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

		<form method="post" action="registration">
			<table>
				<tr>
					<td>Nick :</td>
					<td><input type="text" name="nickname" /></td>
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
				<!-- 	nikname, name, surname, birthDay, education, job, city, email, password,  -->
				<tr>
					<td>Education :</td>
					<td><input type="radio" name="education" value="Higher">Higher
						<input type="radio" name="education" value="School">School</td>
				</tr>
				<tr>
					<td>Job :</td>
					<td><input type="text" name="job"/></td>
				</tr>
				<tr>
					<td>City :</td>
					<td><select name="city">
							<option value="odessa">Odessa</option>
							<option value="kiev">Kiev</option>
							<option value="herson">Herson</option>
							<option value="balta">Balta</option>
					</select></td>
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
					<td>&nbsp;</td>
					<td><input type="submit" value="Save"></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>