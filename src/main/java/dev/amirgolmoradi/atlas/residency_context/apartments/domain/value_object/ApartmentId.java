package dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import lombok.Getter;

import java.util.List;

@Getter
public final class ApartmentId extends ValueObject {
    private final Long value;

    public ApartmentId(Long value) {
        validateApartmentId(value);
        this.value = value;
    }

    public static ApartmentId of(Long value) {
        return new ApartmentId(value);
    }


    private void validateApartmentId(Long value) {
        if (value == null) {
            throw new IllegalArgumentException("Apartment id cannot be null");
        }
        if (value <= 0) {
            throw new IllegalArgumentException("Apartment id must be greater than zero");
        }
    }


    @Override
    public Iterable<Object> getAtomicValues() {
        return List.of(value);
    }
}
