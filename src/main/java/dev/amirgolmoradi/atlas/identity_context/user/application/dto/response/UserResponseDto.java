package dev.amirgolmoradi.atlas.identity_context.user.application.dto.response;

import dev.amirgolmoradi.atlas.identity_context.user.domain.enums.Role;

import java.time.Instant;

public record UserResponseDto(
    String email,
    String fullName,
    byte age,
    Role role,
    boolean isActive,
    Instant createdAt,
    Instant updatedAt
) {
}
