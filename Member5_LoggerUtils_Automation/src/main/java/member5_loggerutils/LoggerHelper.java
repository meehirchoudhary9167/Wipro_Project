package member5_loggerutils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerHelper {

    // This method will return a Logger object for any class we pass
    public static Logger getLogger(Class<?> cls) {
        return LogManager.getLogger(cls);
    }
}
