package com.core.exceptions;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
public class ExceptionResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Date timespamp;
	private String message;
	private String details;
	
	public ExceptionResponse(Date timespamp, String message, String details) {
		this.timespamp = timespamp;
		this.message = message;
		this.details = details;
	}
	
	public Date getTimespamp() {
		return timespamp;
	}
	public void setTimespamp(Date timespamp) {
		this.timespamp = timespamp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	
}
