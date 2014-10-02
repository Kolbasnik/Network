<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<jsp:include page="header.jsp" />
	<jsp:useBean id="service" class="org.hillel.it.network.serviceImpl.ServiceImpl" scope="application"/>
	<%@ page import="java.util.List"%>
	<%@ page import="org.hillel.it.network.model.entity.Ad"%>
</head>
	<body>
  	  	<div class="content">
		  	<h5>My ads </h5>
		  	<%if (session.getAttribute("ad") != null) {
		  	 	Ad ad = (Ad) session.getAttribute("ad");%>
         		<td><%=ad.getManufacturer()%></td>
     			<td><%=ad.getModel()%></td>
     			<td><%=ad.getNote()%></td>
     			<td><%=ad.getCreateDate()%></td>
     			<td><%=ad.getPrice()%></td>
		  	 <%}%>
		  	<%if (session.getAttribute("user") != null) {%>
				<table>
					<thead>
                		<tr>
                    		<th width="5%">Id</th>
                    		<th width="20%">Производитель</th>
                    		<th width="20%">Модель</th>
                    		<th width="20%">Цена</th>
                    		<th width="20%">Дата публикации</th>
                		</tr>
					</thead>
  			<tbody>
  	  		<%List <Ad> ads = (List<Ad>)session.getAttribute("myads");
  	  			int id;
  	  			for (int i=0; i< ads.size(); i++) {
  	  				id=ads.get(i).getId();
            	%>
	            	<tr>
	                	<td><a href="ads?id&<%=id%>"><%=id%></a></td>
	                	<td><a href="ads?id&<%=id%>"><%=ads.get(i).getManufacturer()%></a></td>
                		<td><a href="ads?id&<%=id%>"><%=ads.get(i).getModel()%></a></td>
                		<td><a href="ads?id&<%=id%>"><%=ads.get(i).getCreateDate()%></a></td>
                		<td><a href="ads?id&<%=id%>"><%=ads.get(i).getPrice()%></a></td>
            		</tr>
            	<%}%>
            </tbody>
            <%} 
		  	else { %>
		  	<p>Please register</p>
		  	<%} %>
</table>

			<a class="show-btn" href = "javascript:void(0)" onclick = "document.getElementById('newad').style.display='block';document.getElementById('fade').style.display='block'">Ad new ads</a>
			<div id="newad" class="register">
				<a class="close-btn" title="Закрыть" href="javascript:void(0)" onclick = "document.getElementById('newad').style.display='none';document.getElementById('fade').style.display='none'"></a>
				<div class="title">Add your new adssss</div>
				<form method="POST" action="ads?new">
					<input type="text" name="manufacturer" id="manufacturer" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Производитель':this.value;" value="* manufacturer"/>
					<input type="text" name="model" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Модель':this.value;" value="* Model"/>
					<input type="text" name="note" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Примичание':this.value;" value="* Note"/>
					<select name="lifetime">
						<option value="1">1 day</option>
						<option value="5">5 days</option>
						<option value="10">10 days</option>
						<option value="30">30 days</option>
					</select>
					<input type="text" name="price" onclick="this.value='';" onfocus="this.select()" onblur="this.value=!this.value?'* Желаемая цена':this.value;" value="* Price"/>
					<!-- <textarea class="your-message" placeholder="* Ваше сообщение"></textarea> -->
					<input type="submit" name="send" value="Отправить" class="send-message">
				</form>
			</div>
			<div id="fade" class="black-overlay">
			</div>
		</div>
	 </body>
</html>