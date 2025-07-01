package com.producerconsumerproblem;

public class Message {
	private int messageId;
	private String message;

	public Message(int id, String message) {
		this.messageId = id;
		this.message = message;
	}

	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return "" + this.messageId + " : " + this.message;
	}

}
