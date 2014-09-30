package org.hillel.it.network.persistance.db;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.Ad;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.repository.AdRepository;

public class DBAdRepository implements AdRepository{

	private static DBAdRepository instance = null;

	public static synchronized DBAdRepository getInstance(){
        if (instance == null){
          instance = new DBAdRepository();
        }
        return instance;
  }

	public void saveAd(Ad ad) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(ad);
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

	public boolean delAd(int id) {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        Query query = session.createSQLQuery("select * from ads where ad_id = :id").addEntity(Ad.class);
			Ad ad = (Ad) query.setInteger("id", id).list().get(0);
 	        session.delete(ad);
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }

		return false;
	}

	public Ad getAdById(int id) {
		return null;
	}

	public List<Ad> getAds() {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        return (List<Ad>)session.createSQLQuery("select * from ADS").addEntity(Ad.class).list();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	        return null;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

	public List<Ad> getOwnerAds(int idOwner) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();

			Query query = session.createSQLQuery("select * from ads where id_owner = :idOwner").addEntity(Ad.class);
			return (List<Ad>) query.setInteger("idOwner", idOwner).list();
		} 
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
			return null;
		} 
		finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	
}