package com.dags.searchforusersimplilearn.service;

import com.dags.searchforusersimplilearn.domain.User;
import com.dags.searchforusersimplilearn.repository.UserRepository;
import lombok.extern.log4j.Log4j;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

    @Autowired
    UserRepository userRepository;

    private User currentUser;

    public boolean userInformationHasBeenUpdated(String username, String password, String description) {

        boolean change = false;

        if (!username.isBlank() && !username.contains(" ")) {
            currentUser.setUsername(username);
            change = true;
        }

        if (!password.isBlank() && !password.contains(" ")) {
            currentUser.setPassword(password);
            change = true;
        }

        if (!description.isBlank()) {
            currentUser.setDescription(description);
            change = true;
        }

        if (change) {
            userRepository.save(currentUser);
            log.info("Saved update of user id: " + currentUser.getId());
        }

        return change;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }
}
