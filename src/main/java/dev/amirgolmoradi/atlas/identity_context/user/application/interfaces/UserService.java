package dev.amirgolmoradi.atlas.identity_context.user.application.interfaces;

import dev.amirgolmoradi.atlas.identity_context.user.application.dto.response.UserResponseDto;

import java.util.List;

public interface UserService {
    List<UserResponseDto> selectAll();

    List<UserResponseDto> selectAllActiveUser();

    List<UserResponseDto> selectAllNotActiveUser();

    UserResponseDto selectUserById(long id);

    UserResponseDto selectUserByEmail(String email);

    UserResponseDto selectUserByName(String name);

    /**
     * Updates the full name of a user identified by their ID.
     */
    void updateUserName(long userId, String firstName, String lastName);

    /**
     * Updates the user's email address. Validation is performed in the Domain layer.
     */
    void updateUserEmail(long userId, String newEmail);

    /**
     * Updates the user's password. The service must ensure proper hashing is used
     * before persisting the User model.
     */
    void updateUserPassword(long userId, String newPassword);

    /**
     * Updates the user's primary role and manages the corresponding role profile
     * (Tenant, Manager, or Owner) creation/deletion.
     */
    void updateUserRole(long userId, String roleName);

}
