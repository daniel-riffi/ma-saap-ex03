package at.saap.ex03.business.impl;

import at.saap.ex03.business.EmailBusiness;
import at.saap.ex03.models.entity.User;
import org.springframework.stereotype.Service;

@Service
public class EmailBusinessImpl implements EmailBusiness {
    @Override
    public void sendRegistrationEmail(User user) {
        System.out.printf("Sending registration email to %s%n", user.getEmail());
    }
}
