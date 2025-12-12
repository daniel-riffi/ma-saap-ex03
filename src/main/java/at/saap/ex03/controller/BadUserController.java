package at.saap.ex03.controller;

import at.saap.ex03.business.EmailBusiness;
import at.saap.ex03.models.entity.User;
import at.saap.ex03.models.request.UserCreateRequest;
import at.saap.ex03.models.response.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
public class BadUserController {
    private final EmailBusiness emailBusiness;
    Map<UUID, User> users = new HashMap<>();

    public BadUserController(EmailBusiness emailBusiness) {
        this.emailBusiness = emailBusiness;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User newUser = new User(UUID.randomUUID(), userCreateRequest.firstName(), userCreateRequest.lastName(), userCreateRequest.email());
        users.put(newUser.getId(), newUser);
        emailBusiness.sendRegistrationEmail(newUser);
        return UserResponse.fromUser(newUser);
    }
}
