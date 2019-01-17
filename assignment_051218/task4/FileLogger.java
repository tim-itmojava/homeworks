package assignment_051218.task4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileLogger implements ILogger {

    @Override
    public void write(String msg) {
        byte[] buf = msg.getBytes();
        try (FileOutputStream fout = new FileOutputStream(AdvancedLogging.getLogfile())) {
            for (byte bytes : buf) {
                fout.write(bytes);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Logging the following in the log-file: " + msg);
    }
}

class TimeFileLogger extends FileLogger {

    @Override
    public void write(String msg) {
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String message = (msg + " ").concat(((SimpleDateFormat) formatter).format(date));

        super.write(message);
    }
}

class ConsoleLogger implements ILogger {

    @Override
    public void write(String msg) {

        System.out.println("Logging the following: " + msg);

    }
}
