package org.hillel.it.network.bootstrap;

import java.sql.Connection;

import org.hillel.it.network.persistance.db.DBUserRepository;
import org.hillel.it.network.persistance.memory.MemoryGroupRepository;
import org.hillel.it.network.persistance.memory.MemoryMessageRepository;
import org.hillel.it.network.persistance.repository.GroupRepository;
import org.hillel.it.network.persistance.repository.MessageRepository;
import org.hillel.it.network.persistance.repository.UserRepository;
import org.hillel.it.network.persistance.repository.WallRepository;
import org.hillel.it.network.pull.DBConnectionPool;

public class Starter {

	public static void main(String[] args){
		System.out.println("Progect was running");
		
//		private UserRepository userRepository;
//		private GroupRepository groupRepository;
//		private MessageRepository messageRepository;
//		private WallRepository wallRepository;

		Connection connection = null;

		DBConnectionPool pull = DBConnectionPool.getInstance("jdbc:mysql://localhost:3306/networkdb", "admin", "123456789", 100);
		
		if (pull != null) {
			connection = pull.getConnection();
			if (connection != null) {
				userRepository = new DBUserRepository(connection);
			}
		}

		
//		userRepository = new FileUserRepository(config.getPath());
		groupRepository = new MemoryGroupRepository();
		messageRepository = new MemoryMessageRepository();
	
	}
}
