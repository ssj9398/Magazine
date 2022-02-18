package week.pro.advice.exception;


public class BoardNotFoundException extends RuntimeException {

    public BoardNotFoundException(String msg) {
        super(msg);
    }

    public BoardNotFoundException() {
        super();
    }
}
