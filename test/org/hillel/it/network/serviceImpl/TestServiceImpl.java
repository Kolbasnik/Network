package org.hillel.it.network.serviceImpl;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.model.entity.Group;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.model.entity.Wall;
import org.hillel.it.network.persistance.memory.MemoryGroupRepository;
import org.hillel.it.network.persistance.memory.MemoryMessageRepository;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;
import org.hillel.it.network.persistance.memory.MemoryWallRepository;
import org.hillel.it.network.persistance.repository.GroupRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;
import org.hillel.it.network.persistance.repository.UserRepository;
import org.hillel.it.network.persistance.repository.WallRepository;
import org.hillel.it.network.service.Service;
import org.hillel.it.network.serviceImpl.ServiceImpl;
import org.junit.Test;

public class TestServiceImpl {
	UserRepository userRepository = new MemoryUserRepository();
	GroupRepository groupRepository = new MemoryGroupRepository();
	MessageRepository messageRepository = new MemoryMessageRepository();
	WallRepository wallRepository=new MemoryWallRepository();
	Service service = new ServiceImpl (userRepository, groupRepository, messageRepository, wallRepository);
	
	@Test
	public void saveUser() {
		User user;
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		user = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);
		service.saveUser(user);

		user = new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		service.saveUser(user);

		assertEquals(userRepository.getUsers().isEmpty(), false);
		assertEquals(userRepository.getUsers().get(0).getCity(), "Izmail");
	}

	@Test
	public void delUser() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);
		userRepository.saveUser(user1);

		User user2 = new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		service.saveUser(user2);
		
		service.delUser(user1);

		assertEquals(userRepository.getUsers().lastIndexOf(user2), 0);
	}
	
	@Test
	public void searchUser () {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);
		service.saveUser(user1);
		
		User user2=userRepository.searchUser("alibaba");
		
		assertEquals(userRepository.getUsers().get(0).getSurname(), user2.getSurname() );
}

	@Test
	public void saveGroup() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);
		service.saveUser(user);

		user = new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		service.saveUser(user);
		
		Group group = new Group("Berloga", userRepository.getUsers(),user);
		service.saveGroup(group);
		
		assertEquals(groupRepository.getGroups().isEmpty(), false);
	}

	@Test
	public void delGroup() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
			"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);
		service.saveUser(user);

		user = new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		service.saveUser(user);
		
		Group group = new Group("Berloga", userRepository.getUsers(),user);
		service.saveGroup(group);

		service.delGroup(group);
		assertEquals(groupRepository.getGroups().isEmpty(), true);
	}

	@Test
	public void searchGroup() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);
		service.saveUser(user1);

		User user2 = new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
	service.saveUser(user2);

		Group group = new Group("Berloga", userRepository.getUsers(),user1);
		service.saveGroup(group);
		
		service.delUser(user1);
		service.delUser(user2);
		
		user1 = new User ("Kostyan", "Kostya", "Hramoy", birthDay,
				"Yeard", "gopnik", "Izmail", "hramoy@mail.tu", "1111", 0);
		service.saveUser(user1);

		user2 = new User ("Goga", "Genadiy", "Kosoy", birthDay,
				"Kindegaden", "Seller", "Izrail", "gena-na@ukr.net", "mtc", 0);
		service.saveUser(user2);

		group = new Group("Ubejische", userRepository.getUsers(),user2);
		service.saveGroup(group);
		
		group=service.searchGroup("Ubejische");

		assertEquals(group.getUserCreater().getName(), "Genadiy");
	}

	@Test
	public void saveMessage() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);

		User user2= new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		
		Message message = new Message(user1, user2, "Test message", "Hello test friend");
		service.saveMessage(message);
		
		assertEquals(messageRepository.getMessages().isEmpty(), false);
		
		service.sendMessage(message);
		message.setSubject("New subject");
		service.saveMessage(message);
		assertEquals(messageRepository.getMessages().get(0).getSubject(), "New subject");
	}

	@Test
	public void delMessage() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);

		User user2= new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		
		Message message = new Message(user1, user2, "Test message", "Hello test friend");
		service.saveMessage(message);
		
		message = new Message(user2, user1, "Test ok", "Hello. All wright");
		service.saveMessage(message);
		
		service.delMessage(message);
		
		assertEquals(messageRepository.getMessages().get(0).getSubject(), "Test message");
	}

	@Test
	public void sendMessage() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);

		User user2= new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		
		Message message = new Message(user1, user2, "Test message", "Hello test friend");
		service.sendMessage(message);
		
		assertEquals(message.getReceiver().getcountNewMessages(), 1);
		assertEquals(message.getSending(), true);
	}

	
	@Test
	public void searchMessage() {
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);

		User user1 = new User ("Alibaba", "Vasiliy", "Alibabaev", birthDay,
				"High school", "seaman", "Izmail", "alibaba@gmail.com", "qwerty", 0);

		User user2= new User ("Kaba", "Genadiy", "Kabaev", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		
		Message message = new Message(user1, user2, "Test message", "Hello test friend");
		service.saveMessage(message);

		message = new Message(user2, user1, "Test message", "Hello. I received your message");
		service.saveMessage(message);

		assertEquals(service.searchMessage("Test message").size(), 2);
	}
	
	public List <Message> searchMessage (String searchParam) {
		return messageRepository.searchMessage(searchParam);
	}
	
	
	@Test
	public void saveWallMessage() {
		//sender
		Calendar birthDay1 = new GregorianCalendar();
		birthDay1.set(Calendar.DAY_OF_MONTH, 3);
		birthDay1.set(Calendar.MONTH, 3);
		birthDay1.set(Calendar.YEAR, 1988);
		//receiver
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 3);
		birthDay.set(Calendar.MONTH, 3);
		birthDay.set(Calendar.YEAR, 1988);

		User sender = new User ("Tata", "Tanya", "Khristova", birthDay1,
				"High school", "student", "Odessa", "tanya@gmail.com", "hgjhk", 0);

		User receiver= new User ("Sen", "Senya", "Ivanov", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		
		Wall wallmsg = new Wall(sender, receiver, "Hello, my friend");
		service.saveWallMessage(wallmsg);
		
		assertEquals(wallRepository.getWallMsg().isEmpty(), false);
		
		
	}

	@Test
	public void deleteWallMessage() {
		//sender
		Calendar birthDay1 = new GregorianCalendar();
		birthDay1.set(Calendar.DAY_OF_MONTH, 3);
		birthDay1.set(Calendar.MONTH, 3);
		birthDay1.set(Calendar.YEAR, 1988);
		//receiver
		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 3);
		birthDay.set(Calendar.MONTH, 3);
		birthDay.set(Calendar.YEAR, 1988);

		User sender = new User ("Tata", "Tanya", "Khristova", birthDay1,
				"High school", "student", "Odessa", "tanya@gmail.com", "hgjhk", 0);

		User receiver= new User ("Sen", "Senya", "Ivanov", birthDay,
				"Middle school #3", "Seller", "Kiev", "kabaev@ukr.net", "kaba123", 0);
		
		Wall wallmsg2 = new Wall(sender, receiver, "Hello, my friend");
		Wall wallmsg3 = new Wall(sender, receiver, "Hello, my friend");
		service.saveWallMessage(wallmsg2);
		service.saveWallMessage(wallmsg3);
		service.delWallMessage(wallmsg2);
		
		assertEquals(wallRepository.getWallMsg().isEmpty(), false);
		
		assertEquals(wallRepository.getWallMsg().get(wallRepository.getWallMsg().size() - 1), wallmsg3);
	}
	
	
	
	
}
