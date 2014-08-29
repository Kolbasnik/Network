package org.hillel.it.network.persistance.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.TextMessage;
import org.hillel.it.network.model.entity.User;



public class NetworkDb extends TextMessage{
	
	
//	String string;
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
	
	public NetworkDb(Connection connection){
		this.connection=connection;
		createTables();
	}

	public void createTables(){
		try (Statement st=connection.createStatement();){
			 System.out.println(CREATEUSERTABLESQL);
			 st.executeUpdate(CREATEUSERTABLESQL);
			 st.close();
			}
		catch (SQLException e) {
				 e.printStackTrace();
		}
	}
		
	
	public void insertUser(User user){
		if (user == null) {
			
		}
		else {
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
//			String insertUser = "INSERT INTO USER"
//					+ "SET"
//					+ "'ID'=1,"
//					+ "'NICKNAME'='kolbas'";
//			
			try (Statement st=connection.createStatement();){
				 System.out.println(insertUser);
				 st.executeUpdate(insertUser);
				 st.close();
				}
			catch (SQLException e) {
					 e.printStackTrace();
			}
		}
	}



		public void select(String table){
			if(table.equals(null)){
				throw new RuntimeException ("No table");
			}else{
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
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		}
		}
		

 }

	

