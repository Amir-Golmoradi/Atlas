package dev.amirgolmoradi.atlas.residency_context.lease.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Collections;

@Getter
public final class RentAmount extends ValueObject {
    private final BigDecimal amount;

    public RentAmount(BigDecimal amount) {
        validateRentAmount(amount);
        this.amount = amount;
    }

    public static RentAmount of(BigDecimal amount) {
        return new RentAmount(amount);
    }

    private void validateRentAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
    }


    @Override
    public Iterable<Object> getAtomicValues() {
        return Collections.singletonList(amount);
    }
}
