package dev.amirgolmoradi.atlas.residency_context.lease.domain.exception;

public class InvalidUuidFormatException extends RuntimeException {
    public InvalidUuidFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
