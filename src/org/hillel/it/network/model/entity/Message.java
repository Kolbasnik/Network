package org.hillel.it.network.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="messages")
public class Message extends BaseEntity {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "message_id")
    private int messageId;
    
    @Column(name="senderId")
   	private int senderId;
    
    @Column(name="receiverId")
	private int receiverId;
    
    @Column(name="subject")
    private String subject;

    @Column(name="text")
	private String text;
    /*
    @Column(name="picturesURL")
	private List <String> picturesURL;
*/
    @Column(name="isSending")
	private boolean isSending;
	
    public Message () {
    	
    }
    	
    public Message (int senderId, int receiverId, String subject, String text) {
		
//		super();
		
		if ((receiverId > 0) || (text != "")) {
//			this.setCreateBy(senderId);
			this.senderId=senderId;
			this.text = text;
			this.receiverId = receiverId;
			this.subject = subject;
			this.isSending=false;
//			super.setCreateBy(senderId);
//			calendar.getTime();
//			setCreateDate(calendar);
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
