package dev.amirgolmoradi.atlas.identity_context.user.application.dto.request;

public record UserRequestDto(
    String email,
    String fullName,
    byte age,
    String password
) {
}
