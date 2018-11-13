package com.sandov.domain;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import com.sandov.dto.LoggerDto;

@Entity
@Table(name="log_values")
public class LoggerDomain {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Lob
    private String message;	

	@Enumerated(EnumType.STRING)
	@Column(name="type")
	private LoggerTypeEnum type;
	
	@Column(name = "create_by")
	private Instant date = null;
	
	protected LoggerDomain() {	
		this.date = Instant.now();
	}
	public LoggerDomain(String message, LoggerTypeEnum type) {
		this();
		this.message = message;
		this.type = type;
	}
	
	public LoggerDomain(String message, String type) {
		this(message, LoggerTypeEnum.findByLabel(type));
	}
	public LoggerDomain(LoggerDto blogger) {
		this(blogger.getMessage(), blogger.getType());
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LoggerTypeEnum getType() {
		return type;
	}

	public void setType(LoggerTypeEnum type) {
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
		return String.format("LogValue [id=%s, message=%s, type=%s, date=%s]", id, message, type, date);
	}

}
