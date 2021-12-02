package com.drovahkinn.handlers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import com.drovahkinn.http.entities.HttpMethod;
import com.drovahkinn.http.entities.HttpRequest;
import com.drovahkinn.logger.ServerLogger;

public class RequestHandler {

	HttpRequest request;

    public RequestHandler(InputStream is) {
        request = new HttpRequest();
		try {
            parse(new BufferedReader(new InputStreamReader(is)));
        } catch (IOException e) {
            // log
            ServerLogger.getInstance().error(e.getMessage());
        }
		
	}

    private void parse(BufferedReader reader) throws IOException{
        String str = reader.readLine();
		parseRequestLine(str);

		while (!str.equals("")) {
			str = reader.readLine();
			parseRequestHeader(str);
		}
    }

    private void parseRequestLine(String str) {
		// log.info(str);
		String[] split = str.split("\\s+");
		try {
            request.setHttpMethod(HttpMethod.valueOf(split[0]));
		} catch (Exception e) {
            request.setHttpMethod(HttpMethod.UNRECOGNIZED);
            ServerLogger.getInstance().error(e.getMessage());
		}

        request.setPath(split[1]);
        request.setVersion(split[2]);
	}

	private void parseRequestHeader(String str) {
		// log.info(str);
        String[] headers = str.split("\\:\\s");
        if( headers.length == 2)
            request.addHeader(headers[0], headers[1]);
	}

    public HttpRequest getRequest() {
        return request;
    }

    
}
