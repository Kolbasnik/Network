package org.hillel.it.network.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.service.Service;

	@WebServlet(name = "Authorisation", description = "This is a simple servlet with annotations", urlPatterns = "/pages/autorization")
	public class Authorisation extends HttpServlet {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();

			String url = request.getQueryString(); 
			
			if (url.equalsIgnoreCase("exit") && url != null){
				session.setAttribute("user", null);
				response.sendRedirect(request.getContextPath() + "/pages/index.jsp");
			}
			
//			if (request.getQueryString().equals("profile")) {
//				response.sendRedirect(request.getContextPath() + "/pages/profile.jsp");
//			}
		}

		
	
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			User currentUser;
			
			HttpSession session = request.getSession();
			Service service = (Service) session.getAttribute("service");
			String url = request.getQueryString();
			
			if (url.equalsIgnoreCase("login") && url != null) {
				currentUser = service.userIsValidate(request.getParameter("email"),request.getParameter("password")); 

				if (currentUser != null) {
					session.setAttribute("user", (Object) currentUser);
				}
			}

			if (url.equalsIgnoreCase("register") && url != null) {
				// create users and admin
				String nickname=request.getParameter("nickname");
				String name=request.getParameter("name");
				String surname=request.getParameter("surname");
				String city=request.getParameter("city");
				String email=request.getParameter("email");
				String password=request.getParameter("password");
				
				int accesLevel = 1; // 0-user, 1-admin

				User user = new User(nickname, name, surname, city, email, password, accesLevel);
			
				service.saveUser(user);
			}
			response.sendRedirect(request.getContextPath() + "/pages/index.jsp");
//			request.getRequestDispatcher("../pages/index.jsp").forward(request,	response);
		}
		

	}