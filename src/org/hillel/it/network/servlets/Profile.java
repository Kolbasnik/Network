package org.hillel.it.network.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hillel.it.network.model.entity.User;

@WebServlet(name = "Profile", description = "This is a simple servlet with annotations", urlPatterns = "/pages/profile.jsp")
public class Profile extends HttpServlet {

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("user", null);

		request.getRequestDispatcher("../pages/index.jsp").forward(request,
				response);

	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user"); 
		System.out.println("USER PROFILE = " + user);
		
		session.setAttribute("nick", (Object) user.getNickname());
		session.setAttribute("name", (Object) user.getName());
		session.setAttribute("email", (Object) user.getEmail());
		session.setAttribute("job", (Object) user.getJob());
		
		request.getRequestDispatcher("../pages/profile.jsp").forward(request,
				response);
	}
}
