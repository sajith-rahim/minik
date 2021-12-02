package com.drovahkinn.handlers;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.drovahkinn.http.entities.ContentType;
import com.drovahkinn.http.entities.HttpRequest;
import com.drovahkinn.http.entities.HttpStatus;
import com.drovahkinn.logger.ServerLogger;

public class ResponseHandler {
    public static final String VERSION = "HTTP/1.0";
	List<String> headers = new ArrayList<String>();
	byte[] body;

    public ResponseHandler(RequestHandler req){
        handleRequest(req.getRequest());
    }


    private void handleRequest(HttpRequest request){
        switch (request.getHttpMethod()) {
			case HEAD:
				setHeaders(HttpStatus.x200, request.getVersion());
				break;
			case GET:
                handleGet(request);
				break;
            case POST:
                notImplemented(request);
                break;
            case PUT:
                notImplemented(request);
                break;
            case DELETE:
                notImplemented(request);
                break;
			case UNRECOGNIZED:
				setHeaders(HttpStatus.x400, request.getVersion());
				setResponse(HttpStatus.x400.toString());
				break;
			default:
				setHeaders(HttpStatus.x501, request.getVersion());
				setResponse(HttpStatus.x501.toString());
		}
    }


    

    private void setContentType(String uri, List<String> list) {
		try {
			String ext = uri.substring(uri.indexOf(".") + 1);
			list.add(ContentType.valueOf(ext.toUpperCase()).toString());
		} catch (Exception e) {
			ServerLogger.getInstance().error("ContentType not found!" + e.getMessage());
		}
	}

    private void handleGet(HttpRequest request){
        try {
            File file = new File("." + request.getPath());
            if (file.isDirectory()) {
                setHeaders(HttpStatus.x200, request.getVersion());
                
                headers.add(ContentType.HTML.toString());
                StringBuilder result = new StringBuilder("<html><head><title>👾Index of ");
                result.append(request.getPath());
                result.append("</title></head><body><h1>🧪[🇲🇲] Index of ");
                result.append(request.getPath());
                result.append("</h1><hr><pre>");

                
                File[] files = file.listFiles();
                for (File subfile : files) {
                    result.append(" <a href=\"" + subfile.getPath() + "\">" + subfile.getPath() + "</a>\n");
                }
                result.append("<hr></pre></body></html>");
                setResponse(result.toString());
            } else if (file.exists()) {
                setHeaders(HttpStatus.x200, request.getVersion());
                setContentType(request.getPath(), headers);
                setResponse(getBytes(file));
            } else {
                ServerLogger.getInstance().error("File Not Found"+ request.getPath());
                setHeaders(HttpStatus.x404, request.getVersion());
                setResponse(HttpStatus.x404.toString());
            }
        } catch (Exception e) {
            ServerLogger.getInstance().error(e.getMessage());
            setHeaders(HttpStatus.x400, request.getVersion());
            setResponse(HttpStatus.x400.toString());
        }
    }


    private void notImplemented(HttpRequest request) {
        StringBuilder res = new StringBuilder("<html><head><title> Mimik v0.3");
        res.append("</title></head><body>Not Implemented!</body></html>");
        setResponse(res.toString());
    }


    private void setHeaders(HttpStatus status, String httpVersion) {
		headers.add(httpVersion + " " + status.toString());
		headers.add("Connection: close");
		headers.add("Server: Mimik v0.3");
	}

	private void setResponse(String response) {
		body = response.getBytes();
	}

	private void setResponse(byte[] response) {
		body = response;
	}


    private byte[] getBytes(File file){
		int length = (int) file.length();
		byte[] array = new byte[length];
		try (InputStream in = new FileInputStream(file)) {
            int offset = 0;
            while (offset < length) {
            	int count = in.read(array, offset, (length - offset));
            	offset += count;
            }
            in.close();
        } catch (IOException e) {
            // LOG
        }
		return array;
	}

    public void write(OutputStream os) throws IOException {
		DataOutputStream output = new DataOutputStream(os);
		for (String header : headers) {
			output.writeBytes(header + "\r\n");
		}
		output.writeBytes("\r\n");
		if (body != null) {
			output.write(body);
		}
		output.writeBytes("\r\n");
		output.flush();
	}

    
}
