package org.hillel.it.network.persistance.memory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.persistance.repository.MessageRepository;

public class MemoryMessageRepository implements MessageRepository{
	private static int messageId;
	private List <Message> messages;
	Calendar calendar;
	
	public MemoryMessageRepository () {
		messages = new ArrayList <Message>();
		calendar = new GregorianCalendar();
	}

	public void saveMessage(Message message) {
		if (message == null) {
			System.out.println("No message to save");
		}
		else {
			int index = messages.indexOf(message);

			if (index < 0) {
				message.setId(messageId++);
				messages.add(message);
			}
			else {
				calendar.getTime();
				message.setModifiedDate(calendar);
				messages.set(index, message);
			}
		}
	}

	public void delMessage(Message message) {
		if(!messages.remove(message)) {
			System.out.println("Not found such user");
		}
	}

	public List <Message> searchMessage(String searchParam) {
		List <Message> findMessages = new ArrayList <Message>();

		for (Message currentMessage: messages) {
			if (currentMessage.match(searchParam)) {
				findMessages.add(currentMessage);
			}
		}
		return findMessages;
	}

	public List<Message> getMessages() {
		return messages;
	}
}