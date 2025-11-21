package dev.amirgolmoradi.atlas.identity_context.user.domain.value_object;

import dev.amirgolmoradi.atlas.shared_context.building_block.ValueObject;

import java.util.List;
import java.util.regex.Pattern;

public final class Password extends ValueObject {
    private static final Pattern PASSWORD_REGEX = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[^A-Za-z0-9])\\S{8,}$\n");

    private final String password;

    public Password(String password) {
        validatePassword(password);
        this.password = password;
    }

    private void validatePassword(String password){
            /* Password should not be null or empty */

            if (password == null || password.isEmpty()) {
                throw new IllegalArgumentException("Password cannot be null or empty");
            }

            /* Password should follow the Regex */

        if (!PASSWORD_REGEX.matcher(password).matches()) {
            throw new IllegalArgumentException("Password contains invalid characters");
        }

    }


    @Override
    public Iterable<Object> getAtomicValues() {
        return List.of(password);
    }
}
