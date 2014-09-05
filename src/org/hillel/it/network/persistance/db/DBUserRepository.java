package org.hillel.it.network.persistance.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;

public class DBUserRepository extends MemoryUserRepository{
	
	String table;
	String tableColumns;
	final String CREATEUSERTABLESQL =  "CREATE TABLE IF NOT EXISTS USER("
		 	+ "ID INT,"
			+ "CREATEDATE TIMESTAMP,"
			+ "MODIFIEDDATE TIMESTAMP,"
			+ "CREATEBY INT,"
			+ "MODIFIEDBY INT,"
		  	+ "NICKNAME VARCHAR(255),"
			+ "NAME VARCHAR(255),"
			+ "SURNAME VARCHAR(255),"
			+ "BIRTHDAY DATE,"
			+ "EDUCATION VARCHAR(255),"
			+ "JOB VARCHAR(255),"
			+ "CITY VARCHAR(255),"
			+ "EMAIL VARCHAR(255),"
			+ "PASSWORD VARCHAR(255),"
			+ "ACCESLEVEL INT,"
			+ "COUNTNWEMESSAGES INT,"
			+ "COUNTNEWWALLMESSAGES INT,"
			+ "PRIMARY KEY (ID)"
			+ ");";
	
	Connection connection;
	List<Message> msg;


	public DBUserRepository (Connection connection) {
		super();
		this.connection = connection;
		createTables();
	}

	public void createTables(){
		try (Statement st=connection.createStatement();){
			 System.out.println(CREATEUSERTABLESQL);
			 st.executeUpdate(CREATEUSERTABLESQL);
			 st.close();
			 
			 System.out.println("we created tables");
			}
		catch (SQLException e) {
				 e.printStackTrace();
		}
	}
		
	
	public void saveUser(User user){
		if (user != null) {
			String insertUser = "INSERT INTO "
				+ "USER (ID,NICKNAME,NAME,SURNAME,"
				+ "EDUCATION,JOB,CITY,EMAIL,PASSWORD) "
				+ "VALUES ('"
				+ user.getId() + "','" 
				+ user.getNickname() + "','"
				+ user.getName() + "','"
				+ user.getSurname() + "','"
				+ user.getEducation() + "','"
				+ user.getJob() + "','"
				+ user.getCity() + "','"
				+ user.getEmail() + "','"
				+ user.getPassword()
				+ "')";
			try (Statement st=connection.createStatement();){
				 System.out.println(insertUser);
				 st.executeUpdate(insertUser);
				 st.close();
				 
				 super.saveUser(user);
				}
			catch (SQLException e) {
					 e.printStackTrace();
			}
		}
	}


	public void select(String table){
		if(table.equals(null)){
			throw new RuntimeException ("No table");
		}
		else{
			try (Statement st=connection.createStatement();){
				String string = String.format("select * from %s", table);
				ResultSet rs= st.executeQuery(string);
			
				while (rs.next()){
					String sender =rs.getString(rs.findColumn("sender"));
					String receiver =rs.getString(rs.findColumn("receiver"));
					String text =rs.getString(rs.findColumn("text"));
					System.out.println("sender= " + sender + ",receiver=" + receiver + ",text=" + text);
				}

				rs.close();
				st.close();
			} 
			catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}
		

	public void delUser(User user) {

	}

	public User searchUser(String searchParam) {
		return null;
	}

//	public List<User> getUsers() {
//		return null;
//	}

}
