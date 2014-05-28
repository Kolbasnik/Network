package org.hillel.it.network.persistance.db;

import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;

public class DBMessageRepository extends MemoryUserRepository implements MessageRepository{

	public void createTable () {
		System.out.println("CREATE TABLE Message (sender_id integer, receiver_id integer, subject varchar(20), text text);	");
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
