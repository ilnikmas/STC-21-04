import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {
    private static final Logger logger = LogManager.getLogger(LoggerTest.class);

    public static void main(String[] args) {
        logger.info("info");
        logger.error("error");
        logger.warn("warning");
        logger.debug("debug");
        logger.trace("trace");
    }
}
