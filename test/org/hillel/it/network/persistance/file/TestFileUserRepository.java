package org.hillel.it.network.persistance.file;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.SerializationUtils;
import org.hillel.it.network.model.entity.User;
import org.junit.Test;

public class TestFileUserRepository {
	private String path="D:\\test_java.txt";
		
	@Test
	public void saveUser(){
		FileUserRepository fileRepository=new FileUserRepository(path);

		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 3);
		birthDay.set(Calendar.MONTH, 3);
		birthDay.set(Calendar.YEAR, 1988);

		User userTosave = new User ("Tata", "Tanya", "Khristova", birthDay,
				"High school", "student", "Tokyo", "tanya@gmail.com", "hgjhk", 0);
		
		fileRepository.saveUser(userTosave);
		
		//read the contents of the file
		fileRepository.saveUser(userTosave);
		List<User> usersFromFile =null;
		try{
			FileInputStream file=new FileInputStream(path);		
			usersFromFile= (List<User>) SerializationUtils.deserialize(file);
		file.close();
		}catch (Exception e){
		e.printStackTrace();
	}
		
		
		assertEquals(usersFromFile.isEmpty(), false);
		assertEquals(usersFromFile.get(0).getName(), "Tanya");
	}
	
	
	@Test
	public void delUser(){
		FileUserRepository fileRepository=new FileUserRepository(path);

		Calendar birthDay = new GregorianCalendar();
		birthDay.set(Calendar.DAY_OF_MONTH, 3);
		birthDay.set(Calendar.MONTH, 3);
		birthDay.set(Calendar.YEAR, 1988);

		User userTosave = new User ("Tata", "Tanya", "Khristova", birthDay,
				"High school", "student", "Tokyo", "tanya@gmail.com", "hgjhk", 0);
		
		fileRepository.saveUser(userTosave);
		fileRepository.delUser(userTosave);
		
		//read the contents of the file
		//fileRepository.saveUser(userTosave);
		List<User> usersFromFile =null;
		try{
			FileInputStream file=new FileInputStream(path);		
			usersFromFile= (List<User>) SerializationUtils.deserialize(file);
		file.close();
		}catch (Exception e){
		e.printStackTrace();
	}
		
		assertEquals(usersFromFile.isEmpty(), true);
		//System.out.println(usersFromFile.get(0).getName());
		System.out.println(usersFromFile.size());
	}
}
