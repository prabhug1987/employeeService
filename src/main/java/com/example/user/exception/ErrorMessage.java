package com.example.user.exception;

import java.time.LocalDateTime;

public class ErrorMessage {
	private LocalDateTime localDateTime;
	private String message;
	private String description;

	public ErrorMessage(LocalDateTime localDateTime, String message, String description) {
		super();
		this.localDateTime = localDateTime;
		this.message = message;
		this.description = description;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
