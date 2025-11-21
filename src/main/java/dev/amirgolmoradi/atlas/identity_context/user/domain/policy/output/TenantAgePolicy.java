package dev.amirgolmoradi.atlas.identity_context.user.domain.policy.output;

// Policy must work with Value object.

import dev.amirgolmoradi.atlas.identity_context.user.domain.policy.input.AgePolicy;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Age;

public class TenantAgePolicy implements AgePolicy {
    private static final int MINIMUM_AGE = 18;

    @Override
    public boolean isSatisfiedBy(Age age) {
        return age.getValue() >= MINIMUM_AGE;
    }
}
