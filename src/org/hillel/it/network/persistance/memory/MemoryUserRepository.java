package org.hillel.it.network.persistance.memory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.repository.UserRepository;

public class MemoryUserRepository implements UserRepository{
	protected static int userId;
	protected List <User> users;
	Calendar calendar;

	/**
	 * The constructor for the user repository;
	 * The user repository include the list of all users
	 * and the date they were saved.
	 */
	public MemoryUserRepository () {
		users = new ArrayList <User>();
		calendar = new GregorianCalendar();
	}

/**
 * The method for saving the Users into the repository	
 */
	public void saveUser (User user) {
		if (user == null) {
			System.out.println("No user to save");
		}
		else {
			int index = users.indexOf(user);

			if (index < 0) {
				user.setId(userId++);
				users.add(user);
			}
			else {
				calendar.getTime();
				user.setModifiedDate(calendar);
				users.set(index, user);
			}
		}
	}
	
	/**
	 * The method for removing a User from the repository
	 */
	public void delUser (User user) {
		if(!users.remove(user)) {
			System.out.println("Not found this user");
		}
	}

	/**
	 * The method for searching a user by some parameter (name, surname, etc.)
	 */
	public User searchUser (String searchParam) {
		for (User currentUser: users) {
			if (currentUser.match(searchParam)) {
				return currentUser;
			}
		}
		return null;
	}

	public List <User>  getUsers() {
		return users;
	}
}
