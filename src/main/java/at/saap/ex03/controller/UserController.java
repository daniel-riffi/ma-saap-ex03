package at.saap.ex03.controller;

import at.saap.ex03.models.entity.User;
import at.saap.ex03.models.request.UserCreateRequest;
import at.saap.ex03.models.response.UserResponse;
import at.saap.ex03.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v2/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = userService.createUser(userCreateRequest);
        return UserResponse.fromUser(user);
    }
}
