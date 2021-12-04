package com.drovahkinn.handlers;

import java.net.Socket;

import com.drovahkinn.logger.ServerLogger;

public class TrafficHandler implements Runnable {


	private Socket socket;

	public TrafficHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			RequestHandler req = new RequestHandler(socket.getInputStream());
			ResponseHandler res = new ResponseHandler(req);
			res.write(socket.getOutputStream());
			socket.close();
		} catch (Exception e) {
			ServerLogger.getInstance().error(e.getMessage());
		}
	}
}

