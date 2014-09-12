package org.hillel.it.network.persistance.db;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.repository.UserRepository;


public class DBUserRepository implements UserRepository{
	
	private static DBUserRepository instance = null;
	
	public static synchronized DBUserRepository getInstance(){
        if (instance == null){
          instance = new DBUserRepository();
        }
        return instance;
  }

	public void saveUser(User user){
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.save(user);
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
	public void delUser(User user) {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        session.beginTransaction();
	        session.delete(user);
	        session.getTransaction().commit();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}  
		

	@Override
	public User searchUser(String searchParam) {
	    Session session = null;
	    User user = null;
	    Query query = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();

	        query = session.createSQLQuery("select * from users where nickname = :searchParam").addEntity(User.class);
	        if (query != null) {
	        	user = (User) query.setString("searchParam", searchParam).list().get(0);
	        }

	        System.out.println("user = "+user);
	        
	        if (user == null) {
		        query = session.createSQLQuery("select * from users where name = :searchParam").addEntity(User.class);
		        if (query != null) {
		        	user = (User) query.setString("searchParam", searchParam).list().get(0);
		        }
		        
		        if (user == null) {
			        query = session.createSQLQuery("select * from users where surname = :searchParam").addEntity(User.class);
			        user = (User) query.setString("searchParam", searchParam).list().get(0);
		        }
	        }
	        System.out.println("user = "+user);
	        return user;

	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	        return null;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}


	@Override
	public List <User> getUsers() {
	    Session session = null;
	    try {
	        session = HibernateUtil.getSessionFactory().openSession();
	        return session.createSQLQuery("select * from USERS").addEntity(User.class).list();
	    } catch (Exception e) {
	        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
	        return null;
	    } finally {
	        if (session != null && session.isOpen()) {
	            session.close();
	        }
	    }
	}


public User searchUserByEmail(String email) {
    Session session = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();

//		http://javaxblog.ru/article/java-hibernate-2/
//      List <User> users = (List<User>)session.createSQLQuery("select * from USERS where email=1 ").addEntity(User.class).list();

        Query query = session.createSQLQuery("select * from users where email = :email").addEntity(User.class);
        return (User) query.setString("email", email).list().get(0);

    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
        return null;
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
}
//public void deleteStudent(Student stud) throws SQLException {
//    Session session = null;
//    try {
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.delete(stud);
//        session.getTransaction().commit();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
//    } finally {
//        if (session != null && session.isOpen()) {
//            session.close();
//        }
//    }
//}  
}
