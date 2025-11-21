package dev.amirgolmoradi.atlas.identity_context.user.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import lombok.Getter;

import java.util.List;

@Getter
public final class Age extends ValueObject {
    private final byte value;

    public Age(byte value) {
        validateAge(value);
        this.value = value;
    }

    private void validateAge(byte age) {
        if (age <= 0) {
            throw new IllegalArgumentException("Age must be greater than zero");
        }
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return List.of(value);
    }
}
