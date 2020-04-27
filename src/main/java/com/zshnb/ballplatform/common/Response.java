package com.zshnb.ballplatform.common;

public class Response<T> {
	private int code;

	private String message;

	private T data;

	public static <T> Response<T> ok(T data) {
		Response<T> response = new Response<>();
		response.code = 200;
		response.data = data;
		return response;
	}

	public static <T> Response<T> error(String message) {
		Response<T> response = new Response<>();
		response.code = 400;
		response.message = message;
		return response;
	}
}
