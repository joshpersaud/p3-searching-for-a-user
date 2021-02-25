package com.dags.searchforusersimplilearn.bootstrap;

import com.dags.searchforusersimplilearn.domain.User;
import com.dags.searchforusersimplilearn.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        User user1 = new User();
        user.setPassword("pass");
        user.setDescription("User Description");
        user.setUsername("Josh");
        user1.setPassword("pass");
        user1.setDescription("User 2 description");
        user1.setUsername("Tommy");

        userRepository.save(user);
        userRepository.save(user1);
    }
}
