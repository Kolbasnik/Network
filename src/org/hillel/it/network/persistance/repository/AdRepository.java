package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.Ad;

public interface AdRepository {
	void saveAd (Ad ad);
	boolean delAd (int id);
	Ad getAdById (int id);
	List <Ad> getAds ();
	List <Ad> getOwnerAds (int idOwner);
}
