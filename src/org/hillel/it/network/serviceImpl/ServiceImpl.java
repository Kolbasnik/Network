package org.hillel.it.network.serviceImpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hillel.it.network.model.entity.Ad;
import org.hillel.it.network.model.entity.Device;
import org.hillel.it.network.model.entity.Favorite;
import org.hillel.it.network.model.entity.Group;
import org.hillel.it.network.model.entity.Manufacturer;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.model.entity.Wall;
import org.hillel.it.network.persistance.db.DBAdRepository;
import org.hillel.it.network.persistance.db.DBDeviceRepository;
import org.hillel.it.network.persistance.db.DBFavoriteRepository;
import org.hillel.it.network.persistance.db.DBManufacturerRepository;
import org.hillel.it.network.persistance.db.DBMessageRepository;
import org.hillel.it.network.persistance.db.DBUserRepository;
import org.hillel.it.network.persistance.memory.MemoryGroupRepository;
import org.hillel.it.network.persistance.memory.MemoryWallRepository;
import org.hillel.it.network.persistance.repository.AdRepository;
import org.hillel.it.network.persistance.repository.DeviceRepository;
import org.hillel.it.network.persistance.repository.FavoriteRepository;
import org.hillel.it.network.persistance.repository.GroupRepository;
import org.hillel.it.network.persistance.repository.ManufacturerRepository;
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
	private AdRepository adRepository;
	private FavoriteRepository favoriteRepository;
	private ManufacturerRepository manufacturerRepository; 
	private DeviceRepository deviceRepository; 
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
	public ServiceImpl (UserRepository userRepository, GroupRepository groupRepository, MessageRepository messageRepository, WallRepository wallRepository) {
		if ((userRepository != null) && (groupRepository != null) && (messageRepository != null) && (wallRepository!=null)) {
			this.userRepository=userRepository;
			this.groupRepository=groupRepository;
			this.messageRepository=messageRepository;
			this.wallRepository=wallRepository;
		}
	}
	
	public ServiceImpl () {
		
//		Configuration config = new Configuration();
//		Connection connection = null;
//		DBConnectionPool pull = DBConnectionPool.getInstance("jdbc:mysql://localhost:3306/networkdb", "admin", "123456789", 100);
//		if (pull != null) {
//			connection = pull.getConnection();
//			if (connection != null) {
//				userRepository = new DBUserRepository(connection);
//			}
//		}


		userRepository = new DBUserRepository();
		adRepository = new DBAdRepository();
		deviceRepository = new DBDeviceRepository();
		favoriteRepository = new DBFavoriteRepository();
		manufacturerRepository = new DBManufacturerRepository();
		groupRepository = new MemoryGroupRepository();
		messageRepository = new DBMessageRepository();
		wallRepository=new MemoryWallRepository();
		
	}

	//-----------------------------------------------------------------------------------	
	/**
	 * the method for saving the user to the repository
	 * 
	 */
	public void saveUser(User user){
		if (user != null) {
			System.out.println("service user= " + user);
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
	
	public String getUserNickname (Object user) {
		User curUser = (User) user;
		
		return curUser.getNickname();
	}

	public String getUserName (Object user) {
		User curUser = (User) user;
		
		return curUser.getName();
	}

	public String getUserSurname (Object user) {
		User curUser = (User) user;
		
		return curUser.getSurname();
	}

	public String getUserEmail (Object user) {
		User curUser = (User) user;
		
		return curUser.getEmail();
	}

	public String getUserEducation (Object user) {
		User curUser = (User) user;
		
		return curUser.getEducation();
	}

	public User userIsValidate (String email, String password ) {
		User user = userRepository.searchUserByEmail(email);
		
		if ((user != null) && (user.validUser(email, password))) {
			return user;
		}
		else {
			return null;
		}
	}

	public Map<Integer, String> getUsersIdName() {
		List <User> users;
		Map <Integer, String> usersIdName = new HashMap<Integer, String>();
		
		users=userRepository.getUsers();
		for (User currentUsers: users) {
			usersIdName.put(currentUsers.getId(), currentUsers.getName());
		}
		
		Map <Integer, String> map = usersIdName;
  		for(Map.Entry<Integer, String> currentUser : map.entrySet()){
  			System.out.println( currentUser.getKey() + " " + currentUser.getValue());
  		}
		
		return usersIdName;
	}

	// Group part
	//-----------------------------------------------------------------------------------	
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
//		message.getReceiver().addNewMessage();	
//		message.setSending();
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

	@Override
	public List<Message> getMessages() {
		Message msg = new Message(1, 2, "test", "message");
		List <Message> messages = new ArrayList<Message>();;
		
//	    private int messageId;
//	   	private int senderId;
//		private int receiverId;
//	    private String subject;
//		private String text;
		messages.add(msg);

		return messages;
	}
	
	// Ad part
	//-----------------------------------------------------------------------------------	
	public void saveAd(Ad ad) {
		adRepository.saveAd(ad);
	}

	public boolean delAd(int id) {
		return adRepository.delAd(id);
	}

	public Ad getAdById(int id) {
		if (id > 0) {
			return adRepository.getAdById(id);
		}
		else
			return null;
	}

	public List<Ad> getAds() {
		return adRepository.getAds();
	}

	public List<Ad> getOwnerAds(int idOwner) {
		if (idOwner > 0) {
			return adRepository.getOwnerAds(idOwner);
		}
		else
			return null;
	}

	// Favorite_ads part
	//-----------------------------------------------------------------------------------	
	public void addFavorite(Favorite favoriteAd) {
		if (favoriteAd != null) {
			favoriteRepository.addFavorite(favoriteAd);
		}
	}

	public void delFavorite(int ad_id) {
		favoriteRepository.delFavorite(ad_id);
	}

	public void delFavoriteByUser(int userId) {
		List<Favorite> favoriteAds = null; //new ArrayList<Favorite>();
		
		favoriteAds=favoriteRepository.getFavorites(userId);
		if (favoriteAds != null) {
			for (int i=0; i<favoriteAds.size(); i++) {
				favoriteRepository.delFavorite(favoriteAds.get(i).getAdId());
			}
		}
	}

	public List<Ad> getFavorites(int userId) {
		List <Ad> ads=new ArrayList<Ad>();
		List <Favorite> favoriteAds = null;

		favoriteAds=favoriteRepository.getFavorites(userId);
		if (favoriteAds != null) {
			for (int i=0; i<favoriteAds.size(); i++) {
				ads.add(adRepository.getAdById(favoriteAds.get(i).getAdId()));
			}
		}
		
		return ads;
	}
	
	public boolean matchFavorite (Ad ad, Object user) {
		User usr=(User) user;
		boolean isMatch = false;
		if (ad != null || user != null) {
			isMatch=favoriteRepository.matchFavorite(ad.getId(), usr.getId());
		}
		return isMatch;
	}

	// Manufacturers part
	//-----------------------------------------------------------------------------------	
	public List<Manufacturer> getManufacturers() {
		return manufacturerRepository.getManufacturers();
	}

	public boolean addManufacturer(Manufacturer manufacturer) {
		boolean isAdded = true;
		List <Manufacturer> mf = new ArrayList <Manufacturer> ();
		mf = manufacturerRepository.getManufacturers();
		
		if (mf != null) {
			for (int i=0; i< mf.size(); i++) {
				if (mf.get(i).getName().equalsIgnoreCase(manufacturer.getName())){
					isAdded=false;
				}
			}
			if (isAdded == true) {
				manufacturerRepository.addManufacturer(manufacturer);
			}
		}
		else {
			isAdded=false;
		}
		return isAdded;
	}

	public void delManufacturer(Manufacturer manufacturer) {
		manufacturerRepository.delManufacturer(manufacturer);
	}

	
	// Device part
	//-----------------------------------------------------------------------------------	
	@Override
	public List<Device> getDevices() {
		return deviceRepository.getDevices();
	}

	public List<Device> getDevicesByManufacturer(int idManufacturer) {
		return deviceRepository.getDevicesByManufacturer(idManufacturer);
	}

	public boolean addDevice(Device device) {
		boolean isAdded = true;
		List <Device> devices = new ArrayList <Device> ();
		devices = deviceRepository.getDevices();
		
		if (devices != null) { 
			for (int i=0; i< devices.size(); i++) {
				if (devices.get(i).getName().equalsIgnoreCase(device.getName())){
					isAdded=false;
				}
			}
			if (isAdded == true) {
				deviceRepository.addDevice(device);
			}
		}
		else {
			isAdded=false;
		}
		return isAdded;
	}

	public void delDevice(Device device) {
		deviceRepository.delDevice(device);
	}
}
