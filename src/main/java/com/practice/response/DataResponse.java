package com.practice.response;

import java.util.Map;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Setter
@Getter
public class DataResponse extends Response {

	Object data;

	public DataResponse(int code, String message,HttpStatus httpstatuscode, Object data) {
		super(httpstatuscode,code, message);
		this.data = data;
	}

	public DataResponse() {

	}

	public DataResponse(HttpStatus httpstatuscode, int code, String message, Map<String, Object> data) {
		super(httpstatuscode,code, message);
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}
