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

		@Override
		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			session.setAttribute("user", null);

			request.getRequestDispatcher("../pages/index.jsp").forward(request,
					response);

		}

		@Override
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			User currentUser;
			
			HttpSession session = request.getSession();
			Service service = (Service) session.getAttribute("service");
			currentUser =service.userIsValidate(request.getParameter("login"),request.getParameter("password")); 
			
			session.setAttribute("user", (Object) currentUser);

			request.getRequestDispatcher("../pages/index.jsp").forward(request,
					response);
		}
	}