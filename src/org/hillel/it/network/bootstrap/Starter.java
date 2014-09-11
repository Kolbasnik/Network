package org.hillel.it.network.bootstrap;

import java.sql.Connection;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.db.DBUserRepository;
import org.hillel.it.network.persistance.memory.MemoryGroupRepository;
import org.hillel.it.network.persistance.memory.MemoryMessageRepository;
import org.hillel.it.network.persistance.repository.GroupRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;
import org.hillel.it.network.persistance.repository.UserRepository;
import org.hillel.it.network.persistance.repository.WallRepository;
import org.hillel.it.network.pull.DBConnectionPool;
import org.hillel.it.network.service.Service;
import org.hillel.it.network.serviceImpl.ServiceImpl;

public class Starter {

	public static void main(String[] args){
		System.out.println("Progect was running");
//		
//		User user = new User ("Alibaba", "Vasiliy", "Alibabaev", "Izmail", "alibaba@gmail.com", "qwerty", 0);
//
//		Session session = null;
//		
//		try {
//			System.out.println("try to connect");
////		    session = HibernateUtil.getSessionFactory().getCurrentSession();
//			session = HibernateUtil.getSessionFactory().openSession();
//			System.out.println("session= "+ session);
//	        session.beginTransaction();
//	        session.save(user);
//	        session.getTransaction().commit();	
//		} 
//
//		catch (Exception e) {
////			JOptionPane.showMessageDialog(null, e.getMessage(), "������ I/O", JOptionPane.OK_OPTION);
//			System.out.println("Error = "+e.getMessage());
//		} 
//		finally {
//			if (session != null) {
//				session.close();
//			}
//		}
//	}
		Service service = new ServiceImpl();
		User currentUser = service.userIsValidate("1","1");
		System.out.println("currentUser= "+currentUser.getName());
	}
}
