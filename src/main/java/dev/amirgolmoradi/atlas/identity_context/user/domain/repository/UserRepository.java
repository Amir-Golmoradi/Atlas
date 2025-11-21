package dev.amirgolmoradi.atlas.identity_context.user.domain.repository;


import dev.amirgolmoradi.atlas.identity_context.user.domain.aggregate.User;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Email;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.FullName;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.Id;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findUserById(Id id);

    Optional<User> findUserByEmail(Email email);

    Optional<User> findUserByName(FullName fullName);

    Optional<List<User>> findAllActiveUser(boolean isActive);

    Optional<List<User>> findAllNotActiveUser(boolean isActive);

    User save(User user);
}

