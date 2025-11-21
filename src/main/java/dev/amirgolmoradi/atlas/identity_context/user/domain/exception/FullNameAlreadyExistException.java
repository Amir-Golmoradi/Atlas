package dev.amirgolmoradi.atlas.identity_context.user.domain.exception;

public class FullNameAlreadyExistException extends RuntimeException {
    public FullNameAlreadyExistException(String message) {
        super(message);
    }
}
