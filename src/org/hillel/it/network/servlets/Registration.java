package org.hillel.it.network.servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.service.Service;
import org.hillel.it.network.serviceImpl.ServiceImpl;


@WebServlet(name = "Registartion User", description = "This is a simple servlet with annotations", urlPatterns = "/pages/registration")
public class Registration extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("get request");
		response.sendRedirect("../pages/register.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Service service = (Service) session.getAttribute("service");
		
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
		
		request.getRequestDispatcher("../pages/index.jsp").forward(request,
				response);
	}
}