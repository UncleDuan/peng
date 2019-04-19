package util.logger;

import org.apache.log4j.Logger;

public class LoggerTest {
    private static Logger logger=Logger.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.info("Test logger");
    }
}
