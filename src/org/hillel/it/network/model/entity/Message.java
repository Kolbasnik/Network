package org.hillel.it.network.model.entity;

import java.util.List;

public class Message extends BaseEntity {
	private String subject;
	private int senderId;
	private int receiverId;
	private String text;
	private List <String> pictureURL;
	private boolean isSending;
	
	public Message (int senderId, int receiverId, String subject, String text, String[] pictureURL) {
		
		super();
		
		if ((receiverId > 0) || (text != "")) {
			this.setCreateBy(senderId);
			this.senderId=senderId;
			this.text = text;
			this.receiverId = receiverId;
			this.subject = subject;
			this.isSending=false;
			super.setCreateBy(senderId);
			calendar.getTime();
			setCreateDate(calendar);
		}
		else {
			System.out.println("Write down receiver or text");
		}
	}
	
	public boolean match (String searchParam) {
		if (searchParam.equalsIgnoreCase(subject)) {
			return true;
		}
		return false;
	}

	public int getReceiver() {
		return receiverId;
	}

	public void setReceiver(int receiverId) {
		this.receiverId = receiverId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public void setSending() {
		isSending = true;
	}

	public boolean getSending() {
		return isSending;
	}
}
