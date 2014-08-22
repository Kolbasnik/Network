package org.hillel.it.network.bootstrap;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.infa.config.Configuration;
import org.hillel.it.network.model.entity.Group;
import org.hillel.it.network.model.entity.Message;
import org.hillel.it.network.model.entity.User;
import org.hillel.it.network.model.entity.Wall;
import org.hillel.it.network.persistance.file.FileUserRepository;
import org.hillel.it.network.persistance.memory.MemoryGroupRepository;
import org.hillel.it.network.persistance.memory.MemoryMessageRepository;
import org.hillel.it.network.persistance.memory.MemoryUserRepository;
import org.hillel.it.network.persistance.memory.MemoryWallRepository;
import org.hillel.it.network.persistance.repository.GroupRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;
import org.hillel.it.network.persistance.repository.UserRepository;
import org.hillel.it.network.persistance.repository.WallRepository;
import org.hillel.it.network.persistance.sql.NetworkDb;
import org.hillel.it.network.pull.NetworkPull;
import org.hillel.it.network.pull.ReUsableNetworkPull;
import org.hillel.it.network.service.Service;
import org.hillel.it.network.serviceImpl.ServiceImpl;

public class Starter {

	public static void main(String[] args){

		String nickname;
		String name;
		String surname;
		Calendar birthDay = new GregorianCalendar ();
		String education;
		String job;
		String city;
		String email;
		String password;
		int accesLevel; // 0-user, 1-admin
		
		Configuration config = new Configuration();

		NetworkPull pull = new ReUsableNetworkPull(Integer.valueOf(config.getMaxConnections()), config.getDbUrl());
		
		NetworkDb db = new NetworkDb(pull.getConnection());
		// http://stackoverflow.com/questions/2362032/howto-access-properties-file-from-java-ee-web-application
		
		db.createTable("users", "id nick_name");
		
		System.out.println(config.getPath());
		System.out.println(config.getDbUrl());
		System.out.println(config.getMaxConnections());

//		UserRepository userRepository = new MemoryUserRepository();
		UserRepository userRepository = new FileUserRepository(config.getPath());
		GroupRepository groupRepository = new MemoryGroupRepository();
		MessageRepository messageRepository = new MemoryMessageRepository();
		WallRepository wallRepository=new MemoryWallRepository();

		Service service = new ServiceImpl (userRepository, groupRepository, messageRepository, wallRepository);
		
		//create users and admin
		nickname="Kolbasnik";
		name="Sasha";
		surname="Baydarov";
		birthDay.set(Calendar.DAY_OF_MONTH, 6);
		birthDay.set(Calendar.MONTH, 6);
		birthDay.set(Calendar.YEAR, 1983);
		education="High";
		job="Programmer";
		city="Odessa";
		email="kolbastnik@gmail.com";
		password="06071983";
		accesLevel=1; // 0-user, 1-admin

		User user = new User (nickname, name, surname, birthDay,
				education, job, city, email, password, accesLevel);

		service.saveUser(user);
		
		nickname="Tata";
		name="Tetiana";
		surname="Khristova";
		birthDay.set(Calendar.DAY_OF_MONTH, 10);
		birthDay.set(Calendar.MONTH, 1);
		birthDay.set(Calendar.YEAR, 1988);
		education="High";
		job="Scientist";
		city="Odessa";
		email="tanya07-88@mail.ru";
		password="10021988";
		accesLevel=1; // 0-user, 1-admin

		User user2 = new User (nickname, name, surname, birthDay,
				education, job, city, email, password, accesLevel);

		service.saveUser(user2);
		//service.delUser(user2);
		
		
	/**
	 * Create and remove the group "Open Space"
	 */
		String groupName = "Open Space";
		List <User> members = new ArrayList<User>();
		User maker=user;
		members.add(user);
		Group group = new Group(groupName, members, maker);
		service.saveGroup(group);
		service.delGroup(group);
		
		group=service.searchGroup("tanya07-88@mail.ru");

		/**
		 * Message
		 */		
			
				Message msg=new Message (user, user2, "Hello", "How are you?");
				service.saveMessage(msg);
				service.delMessage(msg);
		/**
		 * Wall message
		 * 
		 */	
				
				Wall wallMsg=new Wall(user, user2, "How are you?");
				service.saveWallMessage(wallMsg);
				service.delWallMessage(wallMsg);
				
		
//		test block GROUP
//		User sender=user;
//		User receiver=user2;
//		List <User> receivers = new ArrayList <User>();
//		receivers.add(user);
//		receivers.add(user2);
//		String subject="Test mail";
//		String text = "Hellow world";
//		Message message = new Message (sender, receivers, subject, text);
//		service.addMessage (message);
//
//		subject="Fokus";
//		text = "By-by world";
//		message = new Message (sender, receivers, subject, text);
//		service.addMessage (message);
//		
//		System.out.println(service.searchMessage("Tata").get(0).getText());
//		
//		Wall wallmessage =new Wall(receiver, sender, text);
//		service.addWallMessage(wallmessage);
//		
//		
//
//		end block
		
		
		
		
//		//test block
//		String searchText;
//		searchText="tanya07-88@mail.ru";
//		
//		user=service.searchUser(searchText);
//		System.out.println(user.getEmail());
//		
//		System.out.println("Crate by '"+user.getCreateBy().getSurname()+ "'");
//
//		service.delUser(user);
//		user=service.searchUser("searchText");
//		
//		if (user!= null) {
//			System.out.println(user.getEmail());
//		}
//		else {
//			System.out.println("This user was delete");
//		}
		
		
				

		
		
//create group
//		List groupList=new ArrayList<User>();
//		Group movies=new Group ("Movies", groupList, admin);
//		groupList.add(admin);
//		groupList.add(firstUser);
//		movies.setUsers(groupList);
		
//inMemoryUserRepository		
		
//		inMemoryUserRepository inmemoryrep=new inMemoryUserRepository();
		
//		inmemoryrep.fromMemoryUserRepository(firstUser);
//		
//		inmemoryrep.newUser ("Ivan", "Ivan", "Ivanov", 10.02.1988, "College", null,
//				"Odessa", "IvanIvanov@mail.ru", "10021988", 0, user);
//		inmemoryrep.editUser(firstUser);
//		inmemoryrep.delUser(firstUser);
		
	
//	db.createTable("test45", "sender varchar (50), receiver varchar (50), subject varchar (50), text varchar (100)");
//	db.insert("test45", msg);
//	db.select("test45");
	
	
	}
}
