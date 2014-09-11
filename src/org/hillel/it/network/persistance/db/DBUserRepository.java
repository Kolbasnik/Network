package org.hillel.it.network.persistance.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;

public class DBUserRepository extends MemoryUserRepository{
	
	String table;
	String tableColumns;
	final String CREATEUSERTABLESQL =  "CREATE TABLE IF NOT EXISTS USER("
		 	+ "USER_ID INT NOT NULL AUTO_INCREMENT,"
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
			+ "COUNTNEWMESSAGES INT,"
			+ "COUNTNEWWALLMESSAGES INT,"
			+ "PRIMARY KEY (ID)"
			+ ");";
	
	final String CREATEMESSAGETABLESQL =  "CREATE TABLE IF NOT EXISTS MESSAGE("
		 	+ "ID INT NOT NULL AUTO_INCREMENT,"
		 	+ "CREATEDATE TIMESTAMP,"
			+ "MODIFIEDDATE TIMESTAMP,"
			+ "CREATEBY INT,"
			+ "MODIFIEDBY INT,"
			+ "SENDERID INT,"
			+ "RECEIVERID INT,"
			+ "SUBJECT VARCHAR(255),"
			+ "TEXT TEXT,"
			+ "PICTUREURL VARCHAR(255)"
			+ "PRIMARY KEY (ID)"
			+ ");";

	private Connection connection;


	public DBUserRepository (Connection connection) {
		super();
		this.connection = connection;
		createTable();
	}

	private void createTable(){
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate(CREATEUSERTABLESQL);
			statement.close();
		}			 
		catch (SQLException e) {
				 e.printStackTrace();
		}
	}
	
	public User searchUserByEmail(String email) { 
		User user = null;
		try {
			Statement statement = connection.createStatement();

			String searchByEmail = "SELECT * FROM USER WHERE EMAIL='" + email + "'";
			ResultSet resultSet = statement.executeQuery(searchByEmail);
			
			if (resultSet != null) 
			{
				resultSet.first();
				
				String nickName = resultSet.getString("NICKNAME");
				System.out.println(("nickName= "+nickName));
				
				String name = resultSet.getString("NAME");
				String surName = resultSet.getString("SURNAME");
				String city = resultSet.getString("CITY");
				String password = resultSet.getString("PASSWORD");

				user = new User (nickName, name, surName, city, email, password, 1);
			}
			
			resultSet.close();
			statement.close();
			
			System.out.println("User = " + user);
			return user;

		} catch (SQLException e) {
			e.printStackTrace();
			return user;
		}
	}		
	
	public User searchUser(String searchParam) { 
		User user = null;
		try {
			Statement statement = connection.createStatement();

			String searchByName = "SELECT * FROM USER WHERE NAME='" + searchParam+"'";
			ResultSet resultSet = statement.executeQuery(searchByName);
			
			resultSet.close();
			statement.close();
			return user;
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return user;
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
				 st.executeUpdate(insertUser);
				 st.close();
				 
//				 saveUser(user);
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
}
