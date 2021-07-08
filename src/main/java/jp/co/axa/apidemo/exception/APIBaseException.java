package jp.co.axa.apidemo.exception;

public class APIBaseException extends RuntimeException {

    public APIBaseException() {
        super();
    }

    public APIBaseException(String message) {
        super(message);
    }

    public APIBaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public APIBaseException(Throwable cause) {
        super(cause);
    }

    public APIBaseException(String message, Throwable cause, boolean e, boolean w) {
        super(message, cause, e, w);
    }
}
