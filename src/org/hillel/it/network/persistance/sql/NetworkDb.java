package org.hillel.it.network.persistance.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.TextMessage;
import org.hillel.it.network.model.entity.User;



public class NetworkDb extends TextMessage{
	
	
	String string;
	String table;
	String tableColumns;
	Connection connection;
	List<Message> msg;
	
	public NetworkDb(Connection connection){
		this.connection=connection;
	}
	
	public void createTable(String table, String tableColumns){
		if (tableColumns.equals(null) || table.equals(null)) {
			throw new RuntimeException ("Write table columns");
		}else{
			 try (Statement st=connection.createStatement();){
				 String string = String.format("create table %s (%s)", table, tableColumns);
				 System.out.println(string);
				 st.executeUpdate(string);
				 st.close();
			 } catch (SQLException e) {
				 e.printStackTrace();
			 }
		}
	}
		
	
	public void insert(String table, Message msg){
		if (msg.equals(null)|| table.equals(null)){
			throw new RuntimeException ("No message to insert to the table");
		}else{		
		String string = String.format("insert into %s values ('%s', '%s', '%s', '%s')", table, msg.getSender().getName(), 
				msg.getReceiver().getName(), msg.getSubject(), msg.getText());
		System.out.println(string);
			 try (Statement st=connection.createStatement();){
				 int rows=st.executeUpdate(string);
				 st.close();
	} catch (SQLException e1) {
		
		e1.printStackTrace();
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

	

