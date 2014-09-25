<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp" />
	<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
</head>
<body>
  	<div class="content">
		<div class="register">Being Java Guys |
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

	</div>
 </body>
</html>