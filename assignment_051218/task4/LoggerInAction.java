package assignment_051218.task4;

public class LoggerInAction {

    public static void main(String[] args) {

        ConsoleHelper console = new ConsoleHelper();
        ILogger logger = null;

        while(true) {

            while (true) {

                console.writeString("Please choose one of the following methods to write out into a log (1|2|3):");
                console.writeString("1 - the console;");
                console.writeString("2 - a log file;");
                console.writeString("3 - a log file w time stamp;");
                console.writeString("0 - to quit");


                switch (Integer.parseInt(console.readString())) {
                    case 1:
                        logger = new ConsoleLogger();
                        break;
                    case 2:
                        logger = new FileLogger();
                        break;
                    case 3:
                        logger = new TimeFileLogger();
                        break;
                    case 0:
                        break;
                    default: {
                        System.out.println("Incorrect method chosen. Please try again, or enter 0 to quit");
                        logger = null;
                        break;
                    }
                }
                break;
            }
            if (logger != null) {

                console.writeString("Please enter a message to be logged into the log or ^C to quit");

                String message = console.readString();
                if(!message.equals("^C")) {
                    AdvancedLogging.setLogger(logger).write(message);
                }
                else break;
            }
        }
    }
}
