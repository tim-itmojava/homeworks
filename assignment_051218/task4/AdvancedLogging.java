package assignment_051218.task4;

import java.io.File;

public class AdvancedLogging {

    private static ILogger logger;
    private static File logfile = new File("/Users/timursuyargulov/IdeaProjects/homeworks/src/logCommander.txt");

    private AdvancedLogging() {
    }

    public static ILogger setLogger(ILogger log) {
        logger = log;
        return log;
    }

    public static void write(String msg) {
        logger.write(msg);
    }

    public static File getLogfile() {
        return logfile;
    }

}