package dev.amirgolmoradi.atlas.identity_context.user.domain.aggregate;

import dev.amirgolmoradi.atlas.identity_context.user.domain.enums.Role;
import dev.amirgolmoradi.atlas.identity_context.user.domain.exception.*;
import dev.amirgolmoradi.atlas.identity_context.user.domain.policy.input.AgePolicy;
import dev.amirgolmoradi.atlas.identity_context.user.domain.value_object.*;

import java.time.LocalDateTime;
import java.util.Objects;

public class User {
    private final Id id;
    private final Age age;
    private final LocalDateTime createdAt;
    private Role role;
    private Email email;
    private FullName fullName;
    private Password password;
    private boolean isActive;
    private LocalDateTime lastLogin;
    private LocalDateTime updatedAt;
    private LocalDateTime deactivatedAt;


    public User(Id id, Age age, FullName fullName, Email email, Password password, Role role, AgePolicy agePolicy) {
        this.id = Objects.requireNonNull(id);
        this.age = Objects.requireNonNull(age);
        this.fullName = Objects.requireNonNull(fullName);
        this.email = Objects.requireNonNull(email);
        this.password = Objects.requireNonNull(password);

        if (!agePolicy.isSatisfiedBy(age)) {
            throw new AgePolicyViolationException("User age does not meet the requirements for role: " + role);
        }

        this.role = Objects.requireNonNullElse(role, Role.TENANT);
        this.isActive = true;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = LocalDateTime.now();
        this.lastLogin = null;
        this.deactivatedAt = null;

    }


    public static User create(
        Long id,
        byte age, String firstName, String lastName,
        String email, String password, Role initialRole, AgePolicy policy
    ) {
        return new User(
            new Id(id),
            new Age(age),
            new FullName(firstName, lastName),
            new Email(email),
            new Password(password),
            initialRole,
            policy
        );
    }

    //=== === === === DOMAIN METHODS === === === ===

    public void changeFullName(FullName newFullName) {
        if (fullName.equals(newFullName)) {
            throw new FullNameAlreadyExistException("Full name already exists");
        }
        fullName = newFullName;
        updatedAt = LocalDateTime.now();

    }

    public void changeEmail(Email newEmail) {
        if (email.equals(newEmail)) {
            throw new EmailAlreadyExistException("Email already exists");
        }
        email = newEmail;
        updatedAt = LocalDateTime.now();
    }


    public void changePassword(Password newPassword) {
        if (password.equals(newPassword)) {
            throw new PasswordAlreadyExistException("Password already exists");
        }
        password = newPassword;
        updatedAt = LocalDateTime.now();
    }

    public void changeRole(Role newRole) {
        if (role == newRole) {
            throw new RoleAlreadySetException("User already holds the role: " + newRole);
        }
        role = newRole;
        updatedAt = LocalDateTime.now();
    }

    //TODO: SOFT DELETE MECHANISM
    public void deactivate() {
        // USER MUST BE AVAILABLE TO BE DEACTIVATED.
        if (id == null) {
            throw new IllegalArgumentException("userId cannot be null");
        }

        if (!isActive) return;
        isActive = false;
        deactivatedAt = LocalDateTime.now();
    }

    public void activate() {
        if (isActive) return;
        isActive = true;
        deactivatedAt = null;
        updatedAt = LocalDateTime.now();
    }


    // TODO: AFTER DELETING CURRENT USER WITH ROLE_TENANT,
    //  TENANT MUST BE ADDED IN APARTMENT's HISTORY.
}
