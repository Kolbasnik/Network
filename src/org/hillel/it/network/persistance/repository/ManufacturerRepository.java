package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.Manufacturer;

public interface ManufacturerRepository {
	List <Manufacturer> getManufacturers();
	void addManufacturer(Manufacturer manufacturer);
	void delManufacturer(Manufacturer manufacturer);
}
