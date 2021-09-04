package com.example.employee.exception;

import java.util.Date;

public class ErrorMessage {
	private Date timestamp;
	private String message;
	private String description;

	public ErrorMessage(Date timestamp, String message, String description) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.description = description;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
