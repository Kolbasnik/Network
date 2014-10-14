package org.hillel.it.network.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Devices")
public class Device implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_manufacturer")
	private int idManufacturer;
		
	@Column(name="name")
	private String name;

	public Device () {
	}

	public Device (int idManufacturer, String name) {
		this.idManufacturer = idManufacturer;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdManufacturer() {
		return idManufacturer;
	}

	public void setIdManufacturer(int idManufacturer) {
		this.idManufacturer = idManufacturer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
