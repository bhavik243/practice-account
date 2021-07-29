package com.practice.response;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
@NoArgsConstructor
public class CommonDataResponse extends Response {

	Object data;
	
	public CommonDataResponse(int code, String message, Map<String, Object> data) {
		super(code, message);
		this.data = data;
	}

	public CommonDataResponse(HttpStatus httpstatuscode,int code, String message, Object data) {
		super(httpstatuscode,code, message);
		this.data = data;
	}

}
