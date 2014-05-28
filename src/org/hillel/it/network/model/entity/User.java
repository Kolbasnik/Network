package org.hillel.it.network.model.entity;

import java.io.Serializable;
import java.util.Calendar;

public class User extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nikname;
	private String name;
	private String surname;
	private Calendar birthDay;
	private String education;
	private String job;
	private String city;
	private String email;
	private String password;
	private int accesLevel; // 0-user, 1-admin
	private int countNewMessages;
	private int countNewWallMessages;
	
	public User(String nikname, String name, String surname, Calendar birthDay,
			String education, String job, String city, String email,
			String password, int accesLevel) {

		if (nikname.equals("") || password.equals("") || nikname == null || password == null) {
			new throw ("Error");
		}
		else {
			this.nikname = nikname;
			this.name = name;
			this.surname = surname;
			this.birthDay = birthDay;
			this.education = education;
			this.job = job;
			this.city = city;
			this.email = email;
			this.password = password;
			this.accesLevel = accesLevel;
			this.countNewMessages=0;
			this.countNewWallMessages=0;
			calendar.getTime();
			setCreateDate(calendar);
			setCreateBy(this);
		}
	}
	
	public boolean match (String searchParam) {
		if (searchParam.equalsIgnoreCase(name)) {
			return true;
		}
		if (searchParam.equalsIgnoreCase(surname)) {
			return true;
		}
		if (searchParam.equalsIgnoreCase(nikname)) {
			return true;
		}
		if (searchParam.equalsIgnoreCase(email)) {
			return true;
		}
		return false;
	}

	public String getNickname() {
		return nikname;
	}

	public void setNickname(String nikname) {
		this.nikname = nikname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Calendar getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Calendar birthDay) {
		this.birthDay = birthDay;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccesLevel() {
		return accesLevel;
	}

	public void setAccesLevel(int accesLevel) {
		this.accesLevel = accesLevel;
	}

	public int getCountNewMessages() {
		return countNewMessages;
	}

	public void setCountNewMessages(int countNewMessages) {
		this.countNewMessages = countNewMessages;
	}

	public void addNewMessage () {
		countNewMessages++;
	}

	public int getcountNewMessages () {
		return countNewMessages;
	}

	public void noNewMessages () {
		countNewMessages=0;;
	}

	public int getCountNewWallMessages() {
		return countNewWallMessages;
	}

	public void setCountNewWallMessages(int countNewWallMessages) {
		this.countNewWallMessages = countNewWallMessages;
	}
	public void addNewWallMessage(){
		countNewWallMessages++;
	}
}
