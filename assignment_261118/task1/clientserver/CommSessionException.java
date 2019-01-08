package assignment_261118.task1.clientserver;

public class CommSessionException extends Exception {

    public CommSessionException(String message) {
        super(message);
    }

    public CommSessionException(String message, Throwable cause) {
        super(message, cause);
    }
}