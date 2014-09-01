package org.hillel.it.network.model.entity;


import java.util.Calendar;
import java.util.GregorianCalendar;

public class Wall extends TextMessage {
private User receiver;
	
	
	public Wall(User sender, User receiver, String text){
		super();

		if(text ==""){
			throw new RuntimeException("There is no text");
		}
		else {
			super.setCreateBy(sender.getId());
			this.setSender(sender);
			this.receiver=receiver;
			this.setText(text);
			this.isSending=false;
			Calendar calendar=new GregorianCalendar();
			calendar.getTime();
			super.setCreateDate(calendar);
			super.setCreateBy(sender.getId());
		}
	}
		
	public void setSending(boolean isSending) {
		this.isSending = isSending;
	}	
}