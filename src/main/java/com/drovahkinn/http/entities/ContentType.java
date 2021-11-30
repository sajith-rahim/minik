package com.drovahkinn.http.entities;

public enum ContentType {
    HTML("HTML"),
    TXT("TXT"),
    XML("XML"),
    JSON("JSON"),

	CSS("CSS"),
	GIF("GIF"),
	ICO("ICO"),
	JPEG("JPEG"),
	PNG("PNG");
	
	

	private String extension = "TXT";

    ContentType(String extension) {
        this.extension = extension;
    }

	@Override
	public String toString() {
		switch (this) {
			case CSS:
				return "Content-Type: text/css";
			case GIF:
				return "Content-Type: image/gif";
			case HTML:
				return "Content-Type: text/html";
			case ICO:
				return "Content-Type: image/gif";
			case JPEG:
				return "Content-Type: image/jpeg";
			case PNG:
				return "Content-Type: image/png";
			case TXT:
				return "Content-type: text/plain";
			case XML:
				return "Content-type: text/xml";
			default:
				return "Content-type: text/plain";
		}
	}
}