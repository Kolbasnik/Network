package org.hillel.it.network.persistance.repository;

import java.util.List;
import org.hillel.it.network.model.entity.Ad;

// Fields of "Ad" entity are 
// int id;
// String manufacturer;
// String model;
// String note;
// Calendar createDate;
// int lifeTime;
// int idOwner;

public interface AdRepository {
	void saveAd (Ad ad);
	boolean delAd (int id);
	Ad getAdById (int id);
	List <Ad> getAds ();
	List <Ad> getOwnerAds (int idOwner);
}