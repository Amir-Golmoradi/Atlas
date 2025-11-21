package dev.amirgolmoradi.atlas.residency_context.buildings.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;

public class BuildingId extends ValueObject {
    private final Long value;

    public BuildingId(Long value) {
        this.value = value;
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return null;
    }
}
