package com.drovahkinn;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.drovahkinn.handlers.TrafficHandler;
import com.drovahkinn.logger.ServerLogger;

public class Minik {

    private static final int DEFAULT_PORT = 8083;

	private static final int N_THREADS = 3;

	public static void main(String args[]) {
		try {
			new Minik().initialize(validatePort(args));
		} catch (Exception e) {
            // e.printStackTrace();
			ServerLogger.getInstance().error(e.getMessage());
		}
	}

    /**
	 * Initializes server.
	 */
	public void initialize(int port) {
		try (ServerSocket s = new ServerSocket(port)) {
            System.out.println("🧪[🇲🇲] Server running on port: " + port + " ( ⚠️ CTRL-C to quit!)");
            System.out.println("🧪[🇲🇲] Number of Threads: " + N_THREADS + "⛓️.");
			ServerLogger.getInstance().info("🧪[🇲🇲] Server running on port: " + port);
            ExecutorService executor = Executors.newFixedThreadPool(N_THREADS);
            while (true) {
            	executor.submit(new TrafficHandler(s.accept()));
            }
        } catch (IOException e) {
			ServerLogger.getInstance().error(e.getMessage());
        }
	}

	/**
	 * Parse command line arguments (string[] args) for valid port number
	 * 
	 * @return int valid port number or default value (8083)
	 */
	static int validatePort(String args[]) throws IllegalArgumentException {
		if (args.length > 0) {
			int port = Integer.parseInt(args[0]);
			if (port > 1024 && port < 65535) {
				return port;
			} else {
				throw new IllegalArgumentException(" ⛔ Invalid port! Range: 1️⃣0️⃣2️⃣4️⃣ 🇹🇴 6️⃣5️⃣5️⃣3️⃣5️⃣");
			}
		}
		return DEFAULT_PORT;
	}
    
}
