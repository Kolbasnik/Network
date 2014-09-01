package org.hillel.it.network.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * The class GROUP is a group of people which have the same interests, for e.g. in music.
 *
 */
public class Group extends BaseEntity {
	private String groupName;
	private List <User> members;
	User userCreater;
	
	/**
	 * 
	 * The object Group should have the name and its members. The information about 
	 * the creator of the group should be also included.
	 * @param groupName - the name of the Group, for e.g. "Movies"
	 * @param members - people which are members of this group
	 * @param userCreater - the person which create the current group. 
	 * It can be also the administrator.
	 * @calendar The time, when the group was created 
	 * 
	 */
	public Group (String groupName, List <User> members, User userCreater) {
	
		if ((groupName != "") && (!members.isEmpty())) {
			this.groupName=groupName;
			this.members = new ArrayList<User>();
			this.members=members;
			this.userCreater=userCreater;
			setCreateBy(userCreater.getId());
			calendar.getTime();
			setCreateDate(calendar);
		}
	}

	/**
	 * The method which search the Group by its name.
	 * @param searchParam - search pattern
	 * 
	 */
	public boolean match (String searchParam) {
		if (searchParam.equalsIgnoreCase(groupName)) {
			return true;
		}
		return false;
	}
	
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public User getUserCreater() {
		return userCreater;
	}

	public void setUserCreater(User userCreater) {
		this.userCreater = userCreater;
	}
}
