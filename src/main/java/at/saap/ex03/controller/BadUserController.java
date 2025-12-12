package at.saap.ex03.controller;

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
    Map<UUID, User> users = new HashMap<>();

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
        // do some request validation...
        // authorize user...
        User newUser = new User(UUID.randomUUID(), userCreateRequest.firstName(), userCreateRequest.lastName(), userCreateRequest.email());
        users.put(newUser.getId(), newUser);
        sendRegistrationEmail(newUser);
        return UserResponse.fromUser(newUser);
    }

    private void sendRegistrationEmail(User user) {
        System.out.printf("Sending registration email to %s%n", user.getEmail());
    }
}
