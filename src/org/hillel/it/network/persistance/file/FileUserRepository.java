package org.hillel.it.network.persistance.file;

import java.io.FileInputStream;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;
import org.hillel.it.network.persistance.repository.UserRepository;

public class FileUserRepository extends MemoryUserRepository implements UserRepository, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected String path;
	protected List <User> users;
	Calendar calendar;
	
	/**
	 * The constructor for the user repository;
	 * The user re pository include the list of all users
	 * and the date they were saved.
	 */
	public FileUserRepository (String path) {
		super();
		this.path=path;
		users = new ArrayList <User>();
		calendar = new GregorianCalendar();
		readData();
	}

/**
 * The method for saving the Users into the repository	
 */
	public void saveUser (User user) {
		super.saveUser(user);
		users=super.getUsers();
		saveData();
	}
	
	
	/**
	 * The method for removing a User from the repository
	 */
	public void delUser (User user) {
		super.delUser(user);
		saveData();
	}

	/**
	 * The method for searching a user by some parameter (name, surname, etc.)
	 */
	public User searchUser (String searchParam) {
		return super.searchUser(searchParam);
	}

	public final List<User> getUsers() {
		return super.getUsers();
	}
	
	private void saveData () {
		try{
			FileOutputStream file=new FileOutputStream (path, false);
			SerializationUtils.serialize((Serializable) users, file);
			file.close();
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	
	public void readData () {
try{
		FileInputStream file=new FileInputStream(path);		
		 users= (List<User>) SerializationUtils.deserialize(file);
	file.close();
	}catch (Exception e){
	e.printStackTrace();
}
		
	}
}
