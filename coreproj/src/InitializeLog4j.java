/*
 * The log4j levels follow the following order. 
	DEBUG 
	INFO 
	WARN 
	ERROR 
	FATAL 
*/

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;


public class InitializeLog4j {

	static final Logger logger = Logger.getLogger(InitializeLog4j.class);
	
	public static void main(String[] args) {
		PropertyConfigurator.configure("log4j.properties");
		
		
		System.out.println(System.getProperty("line.seprator"));
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		logger.fatal("Sample fatal message");
	}
}