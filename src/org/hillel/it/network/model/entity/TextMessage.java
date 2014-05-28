package org.hillel.it.network.model.entity;

public class TextMessage extends BaseEntity {
	protected User sender;
	protected String text;
	protected boolean isSending;
	
	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	public boolean isSending() {
		return isSending;
		}
}
