package org.hillel.it.network.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hillel.it.network.model.entity.Ad;
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
		String url = request.getQueryString();
		User user = (User) session.getAttribute("user");
		
		if (url.equalsIgnoreCase("myAds") && url != null) {
			session.setAttribute("myads", service.getOwnerAds(user.getId()));
		}

		if (url.equalsIgnoreCase("favorites") && url != null) {
			// in this block I must return list of ads, which include in table "favorites_ads"
			// select * from ads where ad_ad in (select ad_id from favorites where user_id=user.getId())
			session.setAttribute("favorites", service.getOwnerAds(user.getId()));	
		}

		if (url.equalsIgnoreCase("addToFavorites") && url != null) {
			String sId = url.split("&")[1];
			if (!sId.isEmpty() || sId != null) {
				int id=Integer.parseInt(sId);
				service.addToFarites(id);
			}
//			session.setAttribute("favorites", service.getOwnerAds(user.getId()));	
		}

		
		if (url.startsWith("id") && url != null) {
			int id=Integer.parseInt(url.split("&")[1]);
			session.setAttribute("ad", service.getAdById(id));
		}

		response.sendRedirect(request.getContextPath() + "/pages/ads.jsp");
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Service service = (Service) session.getAttribute("service");
		User user = (User) session.getAttribute("user");
		
		String url = request.getQueryString();
		
		if (url.equalsIgnoreCase("new") && url != null) {
			// Create new ad
			String manufacturer=request.getParameter("manufacturer");
			String model=request.getParameter("model");
			String note=request.getParameter("note");
			String sPrice = request.getParameter("price");
			String sLifeTime = request.getParameter("lifetime");
			
			System.out.println(manufacturer);
			System.out.println(model);
			System.out.println(note);
			System.out.println(sPrice);
			System.out.println(sLifeTime);
			System.out.println();

			int price=0;
			int lifeTime=30;	//one month life ad
			
			if (!sPrice.isEmpty() || sPrice != null) {
				price=Integer.parseInt(sPrice);
			}
			if (!sLifeTime.isEmpty() || sLifeTime != null) {
				lifeTime=Integer.parseInt(sLifeTime);
			}
			
			Ad ad = new Ad(manufacturer, model, note, lifeTime, user.getId(), price);
			service.saveAd(ad);
//			response.sendRedirect(request.getContextPath() + "/pages/ads.jsp?myads");
			request.getRequestDispatcher("../pages/ads.jsp?myads").forward(request, response);

		}
		else {
			request.getRequestDispatcher("../pages/register.jsp").forward(request, response);
		}
	}
}
