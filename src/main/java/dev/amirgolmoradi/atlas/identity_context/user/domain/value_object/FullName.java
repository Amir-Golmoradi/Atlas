package dev.amirgolmoradi.atlas.identity_context.user.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public final class FullName extends ValueObject {
    private final static int MAX_CHAR_LENGTH = 100;
    private final static int MIN_CHAR_LENGTH = 2;
    private final String firstName;
    private final String lastName;

    public FullName(String firstName, String lastName) {
        validateFullName(firstName, lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }



    private void validateFullName(final String firstName, final String lastName) {

        // 1. Full Name should not be null or empty
        if (firstName == null || firstName.isBlank()) {
            throw new IllegalArgumentException("First name must not be empty");
        }
        if (lastName == null || lastName.isBlank()) {
            throw new IllegalArgumentException("Last name must not be empty");
        }

        // 2. 2 < first Name < 100  & 2 < lastName < 100
        if (firstName.length() <= MIN_CHAR_LENGTH || firstName.length() > MAX_CHAR_LENGTH) {
            throw new IllegalArgumentException(
                "First name length must be between " + MIN_CHAR_LENGTH + " and " + MAX_CHAR_LENGTH + " characters.");
        }

        if (lastName.length() <= MIN_CHAR_LENGTH || lastName.length() > MAX_CHAR_LENGTH) {
            throw new IllegalArgumentException(
                "Last name length must be between " + MIN_CHAR_LENGTH + " and " + MAX_CHAR_LENGTH + " characters.");
        }

        // 3. Full Name should be => FirstName + " " + LastName;
        String fullName = firstName.trim() + " " + lastName.trim();
        capitalize(fullName);
    }


    private String capitalize(String name) {
        return Arrays.stream(name.split(" "))
            .map(part -> part.substring(0, 1).toUpperCase() + part.substring(1))
            .collect(Collectors.joining(" "));
    }

    @Override
    public Iterable<Object> getAtomicValues() {
        return List.of(firstName, lastName);
    }

}
