package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.Wall;

public interface WallRepository {
	void saveWallMessage (Wall message);
	void deleteWallMessage (Wall message);
	List<Wall> getWallMsg();
}
