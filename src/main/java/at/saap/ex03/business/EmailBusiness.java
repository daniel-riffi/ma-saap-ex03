package at.saap.ex03.business;

import at.saap.ex03.models.entity.User;

public interface EmailBusiness {
    void sendRegistrationEmail(User user);
}
