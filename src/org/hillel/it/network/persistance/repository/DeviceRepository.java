package org.hillel.it.network.persistance.repository;

import java.util.List;

import org.hillel.it.network.model.entity.Device;

public interface DeviceRepository {
	List <Device> getDevices();
	List <Device> getDevicesByManufacturer(int idManufacturer);
	void addDevice(Device device);
	void delDevice(Device device);
}
