package org.hillel.it.network.persistance.memory;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.hillel.it.network.model.entity.Group;
import org.hillel.it.network.persistance.repository.GroupRepository;

public class MemoryGroupRepository implements GroupRepository{
	private static int groupId;
	private List <Group> groups;
	Calendar calendar;
	
	
	/**
	 * The constructor for the group repository.
	 * It contains the list of groups and the time when they where created.
	 * 
	 */
	public MemoryGroupRepository () {
		groups = new ArrayList <Group>();
		calendar = new GregorianCalendar();
	}
	
	
	/**
	 * The method, which realize saving the group in the repository.
	 */
	public void saveGroup(Group group) {
		if (group == null) {
			System.out.println("No group to save");
		}
		else {
			int index = groups.indexOf(group);
			
			if (index < 0) { 
				group.setId(groupId++);
				groups.add(group);
			}
			else {
				calendar.getTime();
				group.setModifiedDate(calendar);
				groups.set(index, group);
			}
		}
	}

	
/**
 * The method for removing the group from the repository.	
 */
	public void delGroup(Group group) {
		if(!groups.remove(group)) {
			System.out.println("Not found such group");
		}
	}

	/**
	 * The method for searching the group in the repository by some pattern, for e.g. the group name.
	 */
	public Group searchGroup (String searchParam) {
		for (Group currentGroup: groups) {
			if (currentGroup.match(searchParam)) {
				return currentGroup;
			}
		}
		return null;
	}

	public List<Group> getGroups() {
		return groups;
	}
}
