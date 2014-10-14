package org.hillel.it.network.persistance.db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.Ad;
import org.hillel.it.network.model.entity.Device;
import org.hillel.it.network.model.entity.Favorite;
import org.hillel.it.network.persistance.repository.FavoriteRepository;

public class DBFavoriteRepository implements FavoriteRepository {

	public void addFavorite(Favorite favoriteAd) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(favoriteAd);
	        session.getTransaction().commit();	
		} 
		catch (Exception e) {
			System.out.println("Error = "+e.getMessage());
		} 
		finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
		}
	}

	public void delFavorite(int adId, int userId) {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();

	        Query query = session.createSQLQuery("select * from favorite_ads where ad_id = :adId and user_id = :userId").addEntity(Favorite.class);
			Favorite favoriteAd = (Favorite) query.setInteger("adId", adId).setInteger("userId", userId).list().get(0);
			System.out.println("to del id " + favoriteAd.getAdId()+ "user " + favoriteAd.getUserId());
	        if (favoriteAd != null ) {
	 	        session.delete(favoriteAd);
	 	        System.out.println("ready to del");
	        }
	         session.getTransaction().commit();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

	public List<Favorite> getFavorites(int userId) {
	    Session session = null;
	    List <Favorite> favoriteAds = new ArrayList <Favorite>();
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        Query query = session.createSQLQuery("select * from favorite_ads where user_id = :user_id").addEntity(Favorite.class);
	        favoriteAds = (List <Favorite>) query.setInteger("user_id", userId).list();
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	    return favoriteAds;
	}
	
	public boolean matchFavorite(int adId, int userId) {
		boolean isMatch = false;
		Favorite fv=null;
		
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        Query query = session.createSQLQuery("select * from favorite_ads where user_id = :user_id and ad_id = :ad_id").addEntity(Favorite.class);
	        fv = (Favorite) query.setInteger("user_id", userId).setInteger("ad_id", adId).list().get(0);
			if (fv != null) {
				isMatch=true;
			}
		} 
		catch (Exception e) {
			//JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
		} 
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return isMatch;
	}
}
