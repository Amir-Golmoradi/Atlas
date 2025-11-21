package dev.amirgolmoradi.atlas.identity_context.user.domain.exception;

public class EmailAlreadyExistException extends RuntimeException {
    public EmailAlreadyExistException(String message) {
        super(message);
    }
}
