package dev.amirgolmoradi.atlas.identity_context.user.domain.policy.input;

import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Age;

public interface AgePolicy{
    boolean isSatisfiedBy(Age age);
}
