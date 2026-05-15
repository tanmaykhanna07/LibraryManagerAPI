package com.library.library_checkout_system.Controllers;

import com.library.library_checkout_system.Services.UserService;
import com.library.library_checkout_system.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    private final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    @PostMapping("/register")
    public User register(User user){
        user.setPassword(encoder.encode(user.getPassword()));
        return userService.register(user);
    }
}
