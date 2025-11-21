package dev.amirgolmoradi.atlas.identity_context.user.domain.aggregate;

import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Id;

public class Tenant {
    private final Id userId;

    public Tenant(Id id) {
        this.userId = id;
    }


// Todo: Before assigning an Apartment to specific Tenant,
//  AgePolicy MUST be Validated BEFORE ACCEPTING TENANT.
//  Domain Services are meant for this kind of actions.
}
