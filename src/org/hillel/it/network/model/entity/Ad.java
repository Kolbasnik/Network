package org.hillel.it.network.model.entity;

import java.io.Serializable;
import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ads")
public class Ad implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ad_id")
	private int id;
	
	@Column(name="manufacturer")
	private String manufacturer;

	@Column(name="model")
	private String model;

	@Column(name="note")
	private String note;

	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="life_time")
	private int lifeTime;
	
	@Column(name="id_owner")
	private int idOwner;
	
	@Column(name="price")
	private int price;

	public Ad () {
		Calendar c = new GregorianCalendar();
	    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
		createDate=c.getTime();
	}
	
	public Ad (String manufacturer, String model, String note, int lifeTime, int idOwner, int price) {
		this.manufacturer=manufacturer;
		this.model=model;
		this.note=note;
		Calendar c = new GregorianCalendar();
	    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
		createDate=c.getTime();
		this.lifeTime=lifeTime;
		this.idOwner=idOwner;
		this.price=price;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date date) {
		this.createDate = date;
	}

	public int getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(int lifeTime) {
		this.lifeTime = lifeTime;
	}

	public int getIdOwner() {
		return idOwner;
	}

	public void setIdOwner(int idOwner) {
		this.idOwner = idOwner;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
