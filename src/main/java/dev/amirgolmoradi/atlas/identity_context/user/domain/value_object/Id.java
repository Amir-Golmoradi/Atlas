package dev.amirgolmoradi.atlas.identity_context.user.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import org.springframework.modulith.NamedInterface;

import java.util.List;
import java.util.Objects;

@NamedInterface
public final class Id extends ValueObject {
    private final Long id;

    public Id(Long id) {
        validateUserId(id);
        this.id = id;
    }

    public static Id of(Long value) {
        return new Id(value);
    }


    private void validateUserId(Long id) {
        if (Objects.isNull(id) || id <= 0) {
            throw new IllegalArgumentException("userId cannot be null Or zero");
        }
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return List.of(id);
    }
}
