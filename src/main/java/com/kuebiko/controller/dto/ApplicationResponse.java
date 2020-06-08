package com.kuebiko.controller.dto;

public class ApplicationResponse {
	private int code;
	private String status;
	private String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ApplicationResponse [code=" + code + ", status=" + status + ", message=" + message + "]";
	}
	
	
	
	
	
}
