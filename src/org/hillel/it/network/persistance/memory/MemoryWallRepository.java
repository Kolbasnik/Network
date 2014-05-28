package org.hillel.it.network.persistance.memory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.model.entity.Wall;
import org.hillel.it.network.persistance.repository.WallRepository;

public class MemoryWallRepository implements WallRepository{

	private List <Wall> wallMessages;
	private static int wallMessageId; 
	Calendar calendar=new GregorianCalendar();
	
	
	public MemoryWallRepository () {
		wallMessages = new ArrayList <Wall>();
	}

	public void saveWallMessage(Wall wallMessage) {
		if (wallMessage == null) {
			throw new RuntimeException("There is no message to save");}
		
		int index = wallMessages.indexOf(wallMessage);

		if (index < 0) {
			wallMessage.setId(wallMessageId++);
			wallMessages.add(wallMessage);
		}
		else {
			calendar.getTime();
			wallMessage.setModifiedDate(calendar);
			wallMessages.set(index, wallMessage);
		}
		
	}
	
	public void deleteWallMessage(Wall message) {
		if(!wallMessages.remove(message)) {
			System.out.println("Not found such message");
		}
	}
	
	public List<Wall> getWallMsg(){
		return wallMessages;
	}
}