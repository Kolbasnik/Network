package org.hillel.it.network.persistance.db;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.Ad;
import org.hillel.it.network.model.entity.Device;
import org.hillel.it.network.model.entity.Manufacturer;
import org.hillel.it.network.persistance.repository.DeviceRepository;

public class DBDeviceRepository implements DeviceRepository{

	public List <Device> getDevices() {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        System.out.println((List<Device>) session.createSQLQuery("select * from devices order by name").addEntity(Device.class).list());
	        return (List<Device>) session.createSQLQuery("select * from devices").addEntity(Device.class).list();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	        return null;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

	public List<Device> getDevicesByManufacturer(int idManufacturer) {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        return (List<Device>) session.createSQLQuery("select * from devices where id_manufacturer="+idManufacturer+" order by name").addEntity(Device.class).list();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	        return null;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}

	public void addDevice(Device device) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(device);
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

	public void delDevice(Device device) {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
 	        session.delete(device);
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
