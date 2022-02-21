package week.pro.advice.exception;

public class LikeNotFoundException extends RuntimeException{

    public LikeNotFoundException() {
        super();
    }

    public LikeNotFoundException(String message) {
        super(message);
    }
}
