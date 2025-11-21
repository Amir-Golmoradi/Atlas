package dev.amirgolmoradi.atlas.residency_context.lease.domain.value_object;

import dev.amirgolmoradi.atlas.residency_context.lease.domain.exception.InvalidUuidFormatException;
import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import lombok.Getter;

import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

@Getter
public final class LeaseId extends ValueObject {
    private final UUID value; // CRITICAL: VALUE OBJECTS MUST BE IMMUTABLE.

    public LeaseId(UUID value) {
        this.value = Objects.requireNonNull(value, "LeaseId value cannot be null.");
    }

    public static LeaseId generateNew() {
        return new LeaseId(UUID.randomUUID());
    }

    public static LeaseId fromString(String value) {
        Objects.requireNonNull(value, "LeaseId String cannot be null.");

        try {
            return new LeaseId(UUID.fromString(value));
        } catch (IllegalArgumentException e) {
            throw new InvalidUuidFormatException("Invalid UUID format for LeaseId: " + value, e);
        }
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return Collections.singleton(value);
    }
}
