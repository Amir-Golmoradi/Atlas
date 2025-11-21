package dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import lombok.Getter;

import java.util.Collections;

@Getter
public class Floor extends ValueObject {
    public static final int PARKING_VALUE = 0;
    public static final int MIN_RESIDENTIAL = 1;
    public static final int MAX_RESIDENTIAL = 15;
    public static final int ROOFTOP_VALUE = 16;

    private final int value;

    public Floor(int value) {
        validateApartmentFloor(value);
        this.value = value;
    }


    private void validateApartmentFloor(int floorLevel) {
        if (floorLevel == PARKING_VALUE) {
            return;
        } else if (floorLevel == ROOFTOP_VALUE) {
            return;
        } else if (floorLevel >= MIN_RESIDENTIAL && floorLevel <= MAX_RESIDENTIAL) {
            return;
        } else {
            throw new IllegalArgumentException(
                "Invalid floor. Must be Parking (0), Rooftop (16), or Residential (1-15). Received: " + floorLevel
            );
        }
    }

    public boolean isParking() {
        return this.value == PARKING_VALUE;
    }

    public boolean isRooftop() {
        return this.value == ROOFTOP_VALUE;
    }

    public boolean isResidential() {
        return this.value >= MIN_RESIDENTIAL && this.value <= MAX_RESIDENTIAL;
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return Collections.singleton(value);
    }
}
