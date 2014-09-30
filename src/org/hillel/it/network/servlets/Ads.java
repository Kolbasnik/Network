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

@WebServlet(name = "My ads", description = "This is a simple servlet with annotations", urlPatterns = "/pages/ads")
public class Ads extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Service service = (Service) session.getAttribute("service");
//		String url = request.getQueryString();
		
//		if (url.equalsIgnoreCase("login") && url != null) {
			session.setAttribute("usersIdName", service.getUsersIdName());
//		}

		response.sendRedirect(request.getContextPath() + "/pages/ads.jsp");
		
//		String url = (( request.getQueryString() != null ) ? "?" + request.getQueryString() : "" );
//		String url = request.getQueryString();
//		System.out.println("url= "+url);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		
		HttpSession session = request.getSession();
//		User user = (User) session.getAttribute("user"); 
//		System.out.println("USER PROFILE = " + user);
		
/*		session.setAttribute("nick", (Object) user.getNickname());
		session.setAttribute("name", (Object) user.getName());
		session.setAttribute("email", (Object) user.getEmail());
		session.setAttribute("job", (Object) user.getJob());
*/		
		request.getRequestDispatcher("../pages/register.jsp").forward(request,
				response);
	}
}
