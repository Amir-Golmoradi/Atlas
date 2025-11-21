package dev.amirgolmoradi.atlas.identity_context.user.domain.policy.output;

import dev.amirgolmoradi.atlas.identity_context.user.domain.policy.input.AgePolicy;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Age;

public class ManagerAgePolicy implements AgePolicy {
    // Use strict logic
    private static final int MIN_AGE = 18;
    private static final int MAX_AGE = 75;

    @Override
    public boolean isSatisfiedBy(Age age) {
        return age.getValue() >= MIN_AGE && age.getValue() <= MAX_AGE;
    }
}
