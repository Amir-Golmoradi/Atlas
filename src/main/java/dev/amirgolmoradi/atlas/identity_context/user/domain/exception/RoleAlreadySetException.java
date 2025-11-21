package dev.amirgolmoradi.atlas.identity_context.user.domain.exception;

public class RoleAlreadySetException extends RuntimeException {
    public RoleAlreadySetException(String message) {
        super(message);
    }
}
