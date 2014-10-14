package org.hillel.it.network.service;

import java.util.List;
import java.util.Map;

import org.hillel.it.network.model.entity.Ad;
import org.hillel.it.network.model.entity.Device;
import org.hillel.it.network.model.entity.Favorite;
import org.hillel.it.network.model.entity.Group;
import org.hillel.it.network.model.entity.Manufacturer;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.Wall;

/**
 * This interface which includes all methods for the entities
 * 
 *
 */
public interface Service {
	void saveUser(User user);
	void delUser(User user);
	User searchUser(String searchParam);
	User userIsValidate (String login, String password);
	Map <Integer, String> getUsersIdName();

	void saveAd (Ad ad);
	boolean delAd (int id);
	Ad getAdById (int id);
	List <Ad> getAds ();
	List <Ad> getOwnerAds (int idOwner);
	
	void addFavorite(Favorite favoriteAd);
	void delFavorite(int adId, int userId);
	void delFavoriteByUser (int userId);
	List <Ad> getFavorites(int userId);
	public boolean matchFavorite (Ad ad, Object user);

	List <Manufacturer> getManufacturers();
	boolean addManufacturer(Manufacturer manufacturer);
	void delManufacturer(Manufacturer manufacturer);

	List <Device> getDevices();
	List <Device> getDevicesByManufacturer(int idManufacturer);
	boolean addDevice(Device device);
	void delDevice(Device device);
	
	void saveGroup (Group group);
	void delGroup (Group group);
	Group searchGroup (String searchParam);

	void saveMessage (Message message);
	void delMessage (Message message);
	List <Message> searchMessage (String searchParam);
	void sendMessage (Message message);
	List <Message> getMessages();
	
	void saveWallMessage(Wall wallMessage);
	void delWallMessage(Wall wallMessage);
}
