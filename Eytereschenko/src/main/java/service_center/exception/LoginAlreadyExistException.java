package service_center.exception;

public class LoginAlreadyExistException extends Throwable {
    public LoginAlreadyExistException(String message) {
        super(message);
    }
}
