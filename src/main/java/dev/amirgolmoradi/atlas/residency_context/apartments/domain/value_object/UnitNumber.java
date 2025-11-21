package dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import lombok.Getter;

import java.util.Collections;

@Getter
public class UnitNumber extends ValueObject {
    private final int value;

    public UnitNumber(int value) {
        validateUnitNumber(value);
        this.value = value;
    }


    private void validateUnitNumber(int unitNumber) {
        if (unitNumber <= 0) {
            throw new IllegalArgumentException("Unit Number must be positive");
        }
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return Collections.singleton(value);
    }
}
