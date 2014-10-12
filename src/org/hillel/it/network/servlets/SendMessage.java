package org.hillel.it.network.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.service.Service;

/**
 * Servlet implementation class Message
 */
@WebServlet(name = "Message", description = "This is a simple servlet with annotations", urlPatterns = "/pages/sendmessage")
public class SendMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		Service service = (Service) session.getAttribute("service");
		User user = (User) session.getAttribute("user");
		Message message = new Message (
				user.getId(),
				Integer.parseInt(request.getParameter("receiverId")),
				request.getParameter("subject"),
				request.getParameter("text"));

		service.saveMessage(message);
	}

/*
 * 		protected void doGet(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			HttpSession session = request.getSession();
			session.setAttribute("user", null);

			request.getRequestDispatcher("../pages/index.jsp").forward(request,
					response);

		}
	
		protected void doPost(HttpServletRequest request,
				HttpServletResponse response) throws ServletException, IOException {

			User currentUser;
			
			HttpSession session = request.getSession();
			Service service = (Service) session.getAttribute("service");
			currentUser = service.userIsValidate(request.getParameter("email"),request.getParameter("password")); 
			
			if (currentUser != null) {
				session.setAttribute("user", (Object) currentUser);
			}

			request.getRequestDispatcher("../pages/index.jsp").forward(request,
					response);
	
 */
	
	
	
}
