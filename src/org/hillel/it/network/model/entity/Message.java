package org.hillel.it.network.model.entity;

public class Message extends TextMessage {
	private User receiver;
	private String subject;
	
		
	public Message (User sender, User receiver, String subject, String text) {
		
		if ((receiver != null) || (text != "")) {
			this.setCreateBy(sender);
			this.sender=sender;
			this.text = text;
			this.receiver = receiver;
			this.subject = subject;
			this.isSending=false;
			setCreateBy(sender);
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

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
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
