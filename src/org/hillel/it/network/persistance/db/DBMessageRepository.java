package org.hillel.it.network.persistance.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;

public class DBMessageRepository implements MessageRepository{
	private final String CREATEMESSAGETABLESQL =  "CREATE TABLE IF NOT EXISTS MESSAGE("
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
	
	public DBMessageRepository (Connection connection) {
//		super();
		this.connection = connection;
		createTable();
	}

	private void createTable(){
		try {
			Statement statement=connection.createStatement();
			statement.executeUpdate(CREATEMESSAGETABLESQL);
			statement.close();
		}			 
		catch (SQLException e) {
				 e.printStackTrace();
		}
	}

	
	public List <Integer> loadMessagesById (int id) {
		List <Integer> messages=null;
		
		return messages;
	}
	
		
	@Override
	public void saveMessage(Message message) {
		// TODO Auto-generated method stub
		
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
