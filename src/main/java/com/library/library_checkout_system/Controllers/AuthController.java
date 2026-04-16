package com.library.library_checkout_system.Controllers;

import com.library.library_checkout_system.Services.AuthService;
import com.library.library_checkout_system.dto.RegisterRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequestDTO requestDTO) {
        return authService.registerUser(requestDTO);
    }

}