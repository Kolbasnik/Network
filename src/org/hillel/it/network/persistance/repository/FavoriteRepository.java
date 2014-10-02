package org.hillel.it.network.persistance.repository;

public class FavoriteRepository {
	void addFavorite(int id);
	void delFavorite(int id);
	List <Favorite> getFavorites(int userId);
}
