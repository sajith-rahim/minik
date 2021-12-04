package com.drovahkinn.logger;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;



public class ServerLogger {
    
    private static Logger logger_; 

	
	/*public ServerLogger(Class classname) {
		logger_  = ServerLogger.getLogger(classname);
	}

	@SuppressWarnings("rawtypes")
	public static Logger getLogger(Class cl) {
		return LogManager.getLogger(cl.getSimpleName()); 
	}*/


	public ServerLogger(String classname) {
		logger_  = ServerLogger.getLogger(classname);
		// BasicConfigurator.configure();
	}

	
	public static Logger getLogger(String cl) {
		return LogManager.getLogger(cl); 
	}

	public static synchronized Logger getInstance(){
		if(logger_ != null){
			return logger_;
		}
		else{
			logger_  = ServerLogger.getLogger("Minik.class");
			return logger_;
		}
		
		
	}

	public static synchronized void error(String msg, Throwable thrown) {
		logger_.log(Level.FATAL, msg, thrown);
	}

	public static synchronized void info(String msg) {
		logger_.info(msg);
	}
}

