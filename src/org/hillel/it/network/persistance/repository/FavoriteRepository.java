package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.Favorite;

public interface FavoriteRepository {
	void addFavorite(Favorite favoriteAd);
	void delFavorite(int ad_id);
	List <Favorite> getFavorites(int userId);
	public boolean matchFavorite(int adId, int userId);
}
