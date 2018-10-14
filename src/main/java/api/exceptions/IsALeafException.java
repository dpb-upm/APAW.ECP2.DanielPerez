package api.exceptions;

public class IsALeafException extends RuntimeException {

    private static final long serialVersionUID = -642045799876625537L;

    public IsALeafException(String detail) {
        super(detail);
    }
}
