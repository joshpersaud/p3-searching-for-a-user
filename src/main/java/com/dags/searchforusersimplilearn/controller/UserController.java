package com.dags.searchforusersimplilearn.controller;

import com.dags.searchforusersimplilearn.domain.User;
import com.dags.searchforusersimplilearn.repository.UserRepository;
import com.dags.searchforusersimplilearn.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@RestController
@Log4j2
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;


    @GetMapping("/")
    public ModelAndView displaySearch() {
        return new ModelAndView("search-form");
    }

    @PostMapping("/search")
    public ModelAndView searchForUser(@RequestParam Long id) {

        ModelMap modelMap = new ModelMap();

        if (userRepository.existsById(id)) {

            Optional<User> optionalUser = userRepository.findById(id);
            User user = optionalUser.get();
            modelMap.addAttribute("user", user);

            userService.setCurrentUser(user);

            return new ModelAndView("index", modelMap);
        }

        log.warn("Admin entered invalid id: " + id);
        return new ModelAndView("error-id-doesnt-exist");
    }

    @PostMapping("/update")
    public ModelAndView updateUser(String username, String password, String description) {
        if(userService.userInformationHasBeenUpdated(username, password, description)){
            return new ModelAndView("successful-update");
        }
        return new ModelAndView("search-form");
    }
}
