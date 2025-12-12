package at.saap.ex03.models.request;

import jakarta.validation.constraints.NotNull;

public record UserCreateRequest(@NotNull String firstName, @NotNull String lastName, @NotNull String email) {
}
