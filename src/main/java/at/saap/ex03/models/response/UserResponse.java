package at.saap.ex03.models.response;

import at.saap.ex03.models.entity.User;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record UserResponse(@NotNull UUID id, @NotNull String firstName, @NotNull String lastName, @NotNull String email) {
    public static UserResponse fromUser(User user) {
        return new UserResponse(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
