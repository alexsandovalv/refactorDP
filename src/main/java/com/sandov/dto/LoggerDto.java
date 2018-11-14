package com.sandov.dto;

import java.time.Instant;

import com.sandov.domain.LoggerDomain;

public class LoggerDto {
	
	private String message;	
	private String type;
	private Instant date;
	
	public LoggerDto() {
		this.date = Instant.now();
	}
	
	public LoggerDto(String message, String type, Instant date) {
		this.message = message;
		this.type = type;
		this.date = date;
	}
	
	public LoggerDto(String message, String type) {
		this(message, type, Instant.now());
	}
	
	public LoggerDto(LoggerDomain domain) {
		this(domain.getMessage(), domain.getType().getLabel(), domain.getDate());
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Instant getDate() {
		return date;
	}
	public void setDate(Instant date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return String.format("BLogger [message=%s, type=%s, date=%s]", message, type, date);
	}
	
}
