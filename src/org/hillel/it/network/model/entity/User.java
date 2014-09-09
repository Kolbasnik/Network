package org.hillel.it.network.model.entity;

import java.io.Serializable;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="user")
public class User extends BaseEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
	private int id;
	
	@Column(name="nickname")
	private String nickname;

	@Column(name="name")
	private String name;

	@Column(name="surname")
	private String surname;

	@Column(name="birthday")
	private Calendar birthDay;
	
	@Column(name="education")
	private String education;
	
	@Column(name="job")
	private String job;
	
	@Column(name="city")
	private String city;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="acces_level")
	private int accesLevel; // 0-user, 1-admin
	
	@Column(name="countNewMessages")
	private int countNewMessages;

	@Column(name="countNewWallMessages")
	private int countNewWallMessages;
	
	@Column(name="messages_id")
	private List <Integer> messageId;
	
	public User(String nikname, String name, String surname, String city, String email,
			String password, int accesLevel) {

		if (nikname.equals("") || password.equals("") || nikname == null || password == null) {
			throw new IllegalStateException ("Incorrect data for user");
		}
		else {
			this.nickname = nikname;
			this.name = name;
			this.surname = surname;
			this.city = city;
			this.email = email;
			this.password = password;
			this.accesLevel = accesLevel;
			this.countNewMessages=0;
			this.countNewWallMessages=0;
			calendar.getTime();
			setCreateDate(calendar);
//			setCreateBy(getId());
		}
	}
	
	public boolean match (String searchParam) {
		if (searchParam.equalsIgnoreCase(name)) {
			return true;
		}
		if (searchParam.equalsIgnoreCase(surname)) {
			return true;
		}
		if (searchParam.equalsIgnoreCase(nickname)) {
			return true;
		}
		if (searchParam.equalsIgnoreCase(email)) {
			return true;
		}
		
		return false;
	}

	public boolean validUser (String searchEmail, String searchPassword) {
		System.out.println("vlidate email "+searchEmail);
		System.out.println("vlidate pass "+searchPassword);
		
		if (searchEmail.equalsIgnoreCase(email) && searchPassword.equalsIgnoreCase(password)) {
			System.out.println("vlidate");
			return true;
		}

		System.out.println("Wrong vlidate");
		return false;
	}
	

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nikname) {
		this.nickname = nikname;
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
}
