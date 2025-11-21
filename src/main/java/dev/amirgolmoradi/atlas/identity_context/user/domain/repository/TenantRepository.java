package dev.amirgolmoradi.atlas.identity_context.user.domain.repository;

import dev.amirgolmoradi.atlas.identity_context.user.domain.model.Tenant;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Id;

import java.util.Optional;

public interface TenantRepository {
    Optional<Tenant> getTenantById(Id id);

    Tenant save(Tenant tenant);

}
