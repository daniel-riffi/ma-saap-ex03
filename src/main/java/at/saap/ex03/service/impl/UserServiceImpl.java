package at.saap.ex03.service.impl;

import at.saap.ex03.business.UserBusiness;
import at.saap.ex03.models.entity.User;
import at.saap.ex03.models.request.UserCreateRequest;
import at.saap.ex03.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    private final UserBusiness userBusiness;

    public UserServiceImpl(UserBusiness userBusiness) {
        this.userBusiness = userBusiness;
    }

    @Override
    public User createUser(UserCreateRequest userCreateRequest) {
        return userBusiness.createUser(userCreateRequest);
    }
}
