package com.drovahkinn.http.entities;

public enum HttpMethod {
	GET("GET"), 
	HEAD("HEAD"), 
	POST("POST"), 
	PUT("PUT"), 
	DELETE("DELETE"), 
	TRACE("TRACE"), 
	CONNECT("CONNECT"), 
	UNRECOGNIZED(null); 

	private final String method;

	HttpMethod(String method) {
		this.method = method;
	}
}
