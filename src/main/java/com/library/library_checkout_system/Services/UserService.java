package com.library.library_checkout_system.Services;

import com.library.library_checkout_system.Repositories.UserRepository;
import com.library.library_checkout_system.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }
}
