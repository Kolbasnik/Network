package org.hillel.it.network.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.hillel.it.network.infa.config.Configuration;
import org.hillel.it.network.model.entity.Group;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.model.entity.Wall;
import org.hillel.it.network.persistance.file.FileUserRepository;
import org.hillel.it.network.persistance.memory.MemoryGroupRepository;
import org.hillel.it.network.persistance.memory.MemoryMessageRepository;
import org.hillel.it.network.persistance.memory.MemoryWallRepository;
import org.hillel.it.network.persistance.repository.GroupRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;
import org.hillel.it.network.persistance.repository.UserRepository;
import org.hillel.it.network.persistance.repository.WallRepository;
import org.hillel.it.network.service.Service;

public class ServiceImpl implements Service, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserRepository userRepository;
	private GroupRepository groupRepository;
	private MessageRepository messageRepository;
	private WallRepository wallRepository;
	
	/**
	 * ??
	 * @param userRepository- repository for users
	 * @param groupRepository - repository for groups
	 * @param messageRepository -repository for messages
	 * @param wallRepository  -repository for wall messages
	 */
/*
	public ServiceImpl (UserRepository userRepository, GroupRepository groupRepository, MessageRepository messageRepository, WallRepository wallRepository) {
		if ((userRepository != null) && (groupRepository != null) && (messageRepository != null) && (wallRepository!=null)) {
			this.userRepository=userRepository;
			this.groupRepository=groupRepository;
			this.messageRepository=messageRepository;
			this.wallRepository=wallRepository;
		}
	}
*/	
	public ServiceImpl () {
		Configuration config = new Configuration();

		//		userRepository = new MemoryUserRepository();
		userRepository = new FileUserRepository(config.getPath());
		groupRepository = new MemoryGroupRepository();
		messageRepository = new MemoryMessageRepository();
		wallRepository=new MemoryWallRepository();
	}
	
	/**
	 * the method for saving the user to the repository
	 * 
	 */
	public void saveUser(User user){
		if (user != null) {
			userRepository.saveUser(user);
		}
	}
	/**
	 * the method for removing the user to the repository
	 */
	public void delUser(User user) {
		if (user != null) {
			userRepository.delUser(user);
		}
	}
	/**
	 * the method for searching a user into the repository
	 */
	public User searchUser (String searchParam) {
		if (!searchParam.isEmpty()) {
			return (userRepository.searchUser(searchParam));
		}
		else {
			return null;
		}
	}
/**
 * the method for saving a group to the repository
 */
	public void saveGroup(Group group) {
		if (group != null) {
			groupRepository.saveGroup(group);
		}
	}
/**
 * the method for removing a group to the repository
 */
	public void delGroup(Group group) {
		if (group != null) {
			groupRepository.delGroup(group);
		}
	}
/**
 * the method for searching a group into the repository
 */
	public Group searchGroup(String searchParam) {
		if (!searchParam.isEmpty()) {
			return groupRepository.searchGroup(searchParam);
		}
		else {
			return null;
		}
	}

	/**
	 * The method for saving the message into the repository
	 */
	public void saveMessage(Message message) {
		if ((message != null) && (!message.getSending())) {
			messageRepository.saveMessage(message);
		}
	}
	
	/**
	 * The method for delete the message from the repository
	 */
	public void delMessage(Message message){
		if (message != null) {
			messageRepository.delMessage(message);
		}
	}
	
	/**
	 * The method for searching the message in the repository
	 */
	public List <Message> searchMessage (String searchParam) {
		return messageRepository.searchMessage(searchParam);
	}
	
	public void sendMessage (Message message) {
		message.getReceiver().addNewMessage();	
		message.setSending();
		messageRepository.saveMessage(message);
	}
	
	/**
	 * The method for saving the wall message into the repository
	 */
	public void saveWallMessage(Wall wallMessage){
		if (wallMessage!=null){
			wallRepository.saveWallMessage(wallMessage);
		}
		
	}
	
	/**
	 * The method for removing the message from the repository
	 */
	public void delWallMessage(Wall wallMessage){
		if (wallMessage != null) {
			wallRepository.deleteWallMessage(wallMessage);
		}
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public GroupRepository getGroupRepository() {
		return groupRepository;
	}

	public void setGroupRepository(GroupRepository groupRepository) {
		this.groupRepository = groupRepository;
	}

	public MessageRepository getMessageRepository() {
		return messageRepository;
	}

	public void setMessageRepository(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public WallRepository getWallRepository() {
		return wallRepository;
	}

	public void setWallRepository(WallRepository wallRepository) {
		this.wallRepository = wallRepository;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
