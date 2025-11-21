package dev.amirgolmoradi.atlas.identity_context.user.domain.exception;

public class PasswordAlreadyExistException extends RuntimeException {
    public PasswordAlreadyExistException(String message) {
        super(message);
    }
}
