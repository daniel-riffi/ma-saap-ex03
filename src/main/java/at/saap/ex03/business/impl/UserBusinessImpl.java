package at.saap.ex03.business.impl;

import at.saap.ex03.business.EmailBusiness;
import at.saap.ex03.business.UserBusiness;
import at.saap.ex03.models.entity.User;
import at.saap.ex03.models.request.UserCreateRequest;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UserBusinessImpl implements UserBusiness {
    private final EmailBusiness emailBusiness;
    Map<UUID, User> users = new HashMap<>();

    public UserBusinessImpl(EmailBusiness emailBusiness) {
        this.emailBusiness = emailBusiness;
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        User newUser = new User(UUID.randomUUID(), userCreateRequest.firstName(), userCreateRequest.lastName(), userCreateRequest.email());
        users.put(newUser.getId(), newUser);
        emailBusiness.sendRegistrationEmail(newUser);
        return newUser;
    }
}
