package at.saap.ex03.business;

import at.saap.ex03.models.entity.User;
import at.saap.ex03.models.request.UserCreateRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public interface UserBusiness {
    User createUser(@Valid @NotNull UserCreateRequest userCreateRequest);
}
