import org.apache.log4j.Logger;


public class LoggerTest {
	private static final Logger logger = Logger.getLogger(LoggerTest.class);
	public static void main(String[] args) {
		logger.debug("this is a sample debug log message..........");
		logger.info("this is a sample info log message.");
		logger.warn("this is a sample warn log message.");
		logger.error("this is a sample error log message.");
		logger.fatal("this is a sample fatal log message.");
		System.out.println("<<Loaded>>");
	}
}
