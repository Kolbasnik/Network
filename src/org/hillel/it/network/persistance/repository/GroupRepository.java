package org.hillel.it.network.persistance.repository;

import java.util.List;

/**
 * Interface which include methods for saving and removing the group. 
 * Also it contains method for searching the group by some pattern, for e.g. by the name of the group.
 */
import org.hillel.it.network.model.entity.Group;

/**
 *  The interface which includes the methods for saving and removing the group from the repository.
 * It also includes the search method (search the group by name).
 * 
 *
 */
public interface GroupRepository {
	void saveGroup (Group group);
	void delGroup (Group group);
	Group searchGroup (String searchParam);
	List <Group> getGroups();
}
