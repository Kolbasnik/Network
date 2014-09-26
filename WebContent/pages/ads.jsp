<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp" />
	<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
</head>
	<body>
  	  	<div class="content">
		  	<h5>My ads </h5>
			<a class="show-btn" href = "javascript:void(0)" onclick = "document.getElementById('envelope').style.display='block';document.getElementById('fade').style.display='block'">Ad new ads</a>
			<div id="envelope" class="envelope">
				<a class="close-btn" title="Закрыть" href="javascript:void(0)" onclick = "document.getElementById('envelope').style.display='none';document.getElementById('fade').style.display='none'"></a>
				<div class="title">Add your new ad</div>
				<form method="post" action="ads?new">
					<input type="text" name="sender_name" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Ваше Имя':this.value;" value="* Ваше Имя" class="your-name"/>
					<input type="text" name="sender_email" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Ваш Email':this.value;" value="* Ваш Email" class="email-address"/>
					<textarea class="your-message" placeholder="* Ваше сообщение"></textarea>
					<input type="submit" name="send" value="Отправить" class="send-message">
				</form>
			</div>
			<div id="fade" class="black-overlay">
			</div>
		</div>
	 </body>
</html>