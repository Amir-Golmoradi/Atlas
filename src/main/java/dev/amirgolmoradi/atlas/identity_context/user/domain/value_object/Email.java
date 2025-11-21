package dev.amirgolmoradi.atlas.identity_context.user.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;

import java.util.List;
import java.util.regex.Pattern;

public final class Email extends ValueObject {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n");
    private final String value;

    public Email(String value) {
        validateEmail(value);
        this.value = value;
    }



    private void validateEmail(String email) {
        // Email should not be null or empty
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Email should not be null or empty");
        }

        if(!EMAIL_PATTERN.matcher(email).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }

    }







    @Override
    public Iterable<Object> getAtomicValues() {
        return List.of(value);
    }
}
