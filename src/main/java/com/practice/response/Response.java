package com.practice.response;


import org.springframework.http.HttpStatus;

public class Response {

	int responseCode;
	String responseMessage;
	HttpStatus httpStatus;


	public Response() {
	}
	public Response(int responseCode, String responseMessage) {
		super();
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public Response(HttpStatus httpStatus, int responseCode, String responseMessage) {
		super();
		this.httpStatus = httpStatus;
		this.responseCode = responseCode;
		this.responseMessage = responseMessage;
	}
	public int getResponseCode() {
		return responseCode;
	}
	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}