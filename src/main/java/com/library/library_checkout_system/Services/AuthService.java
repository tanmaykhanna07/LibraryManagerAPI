package com.library.library_checkout_system.Services;

import com.library.library_checkout_system.Repositories.UserAccountRepository;
import com.library.library_checkout_system.dto.RegisterRequestDTO;
import com.library.library_checkout_system.models.UserAccount;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserAccountRepository userAccountRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserAccountRepository userAccountRepository, PasswordEncoder passwordEncoder) {
        this.userAccountRepository = userAccountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String registerUser(RegisterRequestDTO requestDTO){
        UserAccount newUser = new UserAccount();
        newUser.setUsername(requestDTO.getUsername());
        newUser.setRole(requestDTO.getRole());

        String hashedPassword  = passwordEncoder.encode(requestDTO.getPassword());
        newUser.setPassword(requestDTO.getPassword());

        userAccountRepository.save(newUser);

        return "User " + newUser.getUsername() + " saved successfully";
    }
}
