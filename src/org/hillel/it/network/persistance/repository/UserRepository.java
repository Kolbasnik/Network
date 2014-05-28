package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.User;

/**
 * The interface which includes the methods for saving and removing the User from the repository.
 * It also includes the search method (search the user by some parameter).
 * 
 *
 */
public interface UserRepository {
	void saveUser (User user);
	void delUser (User user);	//if we del user - we must delete this user from all groups and messages
	User searchUser (String searchParam);
	public List<User> getUsers(); 
}
