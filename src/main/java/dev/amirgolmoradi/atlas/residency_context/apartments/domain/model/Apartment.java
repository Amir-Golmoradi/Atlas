package dev.amirgolmoradi.atlas.residency_context.apartments.domain.model;

import dev.amirgolmoradi.atlas.residency_context.apartments.domain.enums.ApartmentStatus;
import dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object.ApartmentId;
import dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object.Floor;
import dev.amirgolmoradi.atlas.residency_context.apartments.domain.value_object.UnitNumber;
import dev.amirgolmoradi.atlas.residency_context.buildings.domain.value_object.BuildingId;

public class Apartment {
    private final ApartmentId id;
    private final BuildingId buildingId;
    private final UnitNumber unitNumber;
    private final Floor floor;
    private ApartmentStatus status;

    private Apartment(ApartmentId id, BuildingId buildingId, UnitNumber unitNumber, Floor floor) {
        this.id = id;
        this.buildingId = buildingId;
        this.unitNumber = unitNumber;
        this.floor = floor;
    }
}
