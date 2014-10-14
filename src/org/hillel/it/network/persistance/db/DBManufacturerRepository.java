package org.hillel.it.network.persistance.db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.Device;
import org.hillel.it.network.model.entity.Favorite;
import org.hillel.it.network.model.entity.Manufacturer;
import org.hillel.it.network.persistance.repository.ManufacturerRepository;

public class DBManufacturerRepository implements ManufacturerRepository{

	public List<Manufacturer> getManufacturers() {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        return (List<Manufacturer>) session.createSQLQuery("select * from manufacturers order by name").addEntity(Manufacturer.class).list();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	        return null;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

	public void addManufacturer(Manufacturer manufacturer) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(manufacturer);
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

	public void delManufacturer(Manufacturer manufacturer) {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
 	        session.delete(manufacturer);
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}
}
