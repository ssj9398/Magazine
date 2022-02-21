package week.pro.advice.exception;

public class LikeBoardCreateException extends RuntimeException{
    public LikeBoardCreateException() {
        super();
    }

    public LikeBoardCreateException(String message) {
        super(message);
    }
}
