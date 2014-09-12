package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.Message;

public interface MessageRepository {
	void saveMessage (Message message);
	void delMessage (Message message);
//	void sendMessage (Message message);
	List<Message> searchMessage (String searchParam);
	List<Message> getMessages();
}
