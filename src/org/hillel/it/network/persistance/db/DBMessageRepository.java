package org.hillel.it.network.persistance.db;

import java.util.List;

import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.persistance.repository.MessageRepository;

public class DBMessageRepository implements MessageRepository{

	public void saveMessage(Message message) {
		Session session = null;
		try {
			
			Message msg = new Message (1,1,"x","y");
			System.out.println("try to connect");
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("good session= "+ session);
			System.out.println("good message= "+ message);

			session.beginTransaction();
	        session.save(msg);
        
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

	@Override
	public void delMessage(Message message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Message> searchMessage(String searchParam) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Message> getMessages() {
		// TODO Auto-generated method stub
		return null;
	}

}
