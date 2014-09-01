package org.hillel.it.network.bootstrap;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import com.mysql.jdbc.Driver;

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
		String city;
		String email;
		String password;
		int accesLevel; // 0-user, 1-admin

		Connection connection = null;
		
//		Configuration config = new Configuration();

		NetworkPull pull = new ReUsableNetworkPull(10, "jdbc:mysql://localhost:3306/networkdb" );

		connection = pull.getConnection();
//		userRepository = new DBUserRepository(connection);

//		System.out.println("DB URL= " + config.getDbUrl());
//		System.out.println("MaxConnections " + config.getMaxConnections());
		System.out.println("connection= " + connection);

		
	}
}
