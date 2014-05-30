<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"> 
<head> 
<meta http-equiv="content-type" content="text/html; charset=utf-8" /> 

<jsp:include page="header.jsp"></jsp:include> 

<title>Friends online</title> 
	<script type="text/javascript">
		function validate() {
			var login=document.getElementById("login");
			var password=document.getElementById("password");
	
			if (login.value =="") {
				alert('login must be');
				return false;
			}
			if (password.value =="") {
				alert('password must be');
				return false;
			}
			return true;
	}
</script>

</head> 

<body>

<div id="wrapper">
	<div id="top">
		<header id="header">
			<div class="one-fourth">
				<div class="logo"><a href="index.html"><img src="images/logo.png" alt="" /></a></div>
			</div><!--end one-fourth-->
			
			<div class="three-fourth column-last">
				<nav id="navigation">
					<ul id="mainnav">
						<li><a class="current" href="index.html">MY PAGE</a></li>
						<li><a href="index.html">MY MESSAGES</a></li>
						<li><a href="index.html">MY WALL</a></li>
						<li><a href="index.html">MY FRIENDS</a></li>
						<li><a href="index.html">OUT</a></li>
					</ul>
				</nav><!--end navigation-->
			</div><!--end three-fourth-->
		</header>

		<section class="nivo">
		</section>
	</div><!--end top-->
	
	<div class="centered-wrapper">	
		<%if (session.getAttribute("user") == null) {%>
			<form name="form_login" action="index.jsp" method="POST" onsubmit="return validate()">
			E-mail: <input type="text" id="login">
			Password: <input type="password" id="password">
			<input type="hidden" id="redirect" value='<%=request.getParameter("redirect")%>'>
			<input type="submit" value="Sing in">
			</form>
		<%}%>
	</div><!--end centered-wrapper-->
	
	<div class="centered-wrapper">
		<footer id="footer">
			<div class="double-separator"></div>
			<div id="topfooter">
				<div class="one-fourth">
					<h3>A Few Words About Us</h3>
					<p>Some text about us.</p>
				</div><!--end one-fourth-->
				<div class="one-fourth">
					<h3>Twitter Updates</h3>
					<div class="tweet"></div>
				</div><!--end one-fourth-->
				<div class="one-fourth">
					<h3>Flickr Inspiration</h3>
					<ul id="flickr" class="thumbs"></ul>
				</div><!--end one-fourth-->
				<div class="one-fourth column-last">
					<h3>Get in Touch with Us</h3>
					<p>Address:
					1600 Amphitheatre Parkway <br />
					Mountain View, CA 94043</p>
					<p>Phone: +321 123 456 7 </p>
					<p>E-mail: <a href="mailto:">johndoe@ipsum.com</a><br />
				</div><!--end one-fourth-->
			</div><!--end topfooter-->
		
			<div id="bottomfooter">			
				<div class="one-half">
					<p>Copyright &copy; 2014 - FriendsOnline | All Rights Reserved</p>
				</div><!--end one-half-->

				<div class="one-half column-last">
					<ul id="social">
						<li><a class="rss" href="#">RSS Feed</a></li>
						<li><a class="facebook" href="#">Facebook</a></li>
						<li><a class="twitter" href="#">Twitter</a></li>
						<li><a class="flickr" href="#">Flickr</a></li>
						<li><a class="google" href="#">Google</a></li>
				
					</ul>					
				</div><!--end one-half-->
				<a href="#" class="totop">scroll to top</a>
			</div><!--end bottomfooter-->		
		</footer><!--end footer-->	
	</div><!--end centered-wrapper-->	
</div>
</body> 
</html>