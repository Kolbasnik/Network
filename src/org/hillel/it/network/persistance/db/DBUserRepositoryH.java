package org.hillel.it.network.persistance.db;

import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.hillel.it.network.infa.config.HibernateUtil;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.repository.UserRepository;


//http://javaxblog.ru/article/java-hibernate-1/
public class DBUserRepositoryH implements UserRepository{
//	private static UserRepository userRepository = null;
	
	private static DBUserRepositoryH instance = null;
	
	public static synchronized DBUserRepositoryH getInstance(){
        if (instance == null){
          instance = new DBUserRepositoryH();
        }
        return instance;
  }


	public void saveUser(User user){
		Session session = null;
		
		try {
			System.out.println("try to connect");
			session = HibernateUtil.getSessionFactory().openSession();
			System.out.println("session= "+ session);
	        session.beginTransaction();
	        session.save(user);
        
	        session.getTransaction().commit();	
		} 

		catch (Exception e) {
//			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
			System.out.println("Error = "+e.getMessage());
		} 
		finally {
			if (session != null) {
				session.close();
			}
		}
	}


	@Override
	public void delUser(User user) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public User searchUser(String searchParam) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<User> getUsers() {
		// TODO Auto-generated method stub
		return null;
	}


//	@Override
//	public User searchUserByEmail(String email) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//public void updateStudent(Student stud) throws SQLException {
//    Session session = null;
//    try {
//        session = HibernateUtil.getSessionFactory().openSession();
//        session.beginTransaction();
//        session.update(stud);
//        session.getTransaction().commit();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
//    } finally {
//        if (session != null && session.isOpen()) {
//            session.close();
//        }
//    }
//}
//
public User searchUserByEmail(String email) {
    Session session = null;
    User user = null;
    System.out.println("start");
    try {
        session = HibernateUtil.getSessionFactory().openSession();
//        List <User> users = session.createCriteria(User.class).add( Expression.eq("email", email)).list();

//http://javaxblog.ru/article/java-hibernate-2/
        List <User> users = (List<User>)session.createQuery("select * from users").list();

        System.out.println("users= "+users);
        //user=users.get(0);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
    } finally {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    return user;
}
//
//public List<Student> getAllStudents() throws SQLException {
//    Session session = null;
//    List<Student> studs = new ArrayList<Student>();
//    try {
//        session = HibernateUtil.getSessionFactory().openSession();
//        studs = session.createCriteria(Student.class).list();
//    } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O", JOptionPane.OK_OPTION);
//    } finally {
//        if (session != null && session.isOpen()) {
//            session.close();
//        }
//    }
//    return studs;
//}
//
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
