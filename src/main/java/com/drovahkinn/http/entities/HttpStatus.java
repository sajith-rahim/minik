package com.drovahkinn.http.entities;

public enum HttpStatus {
	x100("100 Continue"), 
	x101("101 Switching Protocols"), 
	x200("200 OK"), 
	x201("201 Created"), 
	x202("202 Accepted"), 
	x203("203 Non-Authoritative Information"), 
	x204("204 No Content"), 
	x205("205 Reset Content"), 
	x206("206 Partial Content"), 
	x300("300 Multiple Choices"), 
	x301("301 Moved Permanently"), 
	x302("302 Found"), 
	x303("303 See Other"), 
	x304("304 Not Modified"), 
	x305("305 Use Proxy"), 
	x307("307 Temporary Redirect"), 
	x400("400 Bad Request"), 
	x401("401 Unauthorized"), 
	x402("402 Payment Required"), 
	x403("403 Forbidden"), 
	x404("404 Not Found"), 
	x405("405 Method Not Allowed"), 
	x406("406 Not Acceptable"), 
	x407("407 Proxy Authentication Required"), 
	x408("408 Request Time-out"), 
	x409("409 Conflict"), 
	x410("410 Gone"), 
	x411("411 Length Required"), 
	x412("412 Precondition Failed"), 
	x413("413 Request Entity Too Large"), 
	x414("414 Request-URI Too Large"), 
	x415("415 Unsupported Media Type"), 
	x416("416 Requested range not satisfiable"), 
	x417("417 Expectation Failed"), 
	x500("500 Internal Server Error"), 
	x501("501 Not Implemented"), 
	x502("502 Bad Gateway"), 
	x503("503 Service Unavailable"), 
	x504("504 Gateway Time-out"), 
	x505("505 HTTP Version not supported"); 

	private final String status;

	HttpStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return status;
	}
}
