package com.library.library_checkout_system.Controllers;

import com.library.library_checkout_system.Services.CheckoutService;
import com.library.library_checkout_system.dto.CheckoutRequestDTO;
import com.library.library_checkout_system.dto.CheckoutResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/libraryApi/checkout")
class CheckoutController {
    private final CheckoutService checkoutService;

    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @PostMapping
    public CheckoutResponseDTO registerBook(@Valid @RequestBody CheckoutRequestDTO checkoutRequestDTO){
        return checkoutService.registerBook(checkoutRequestDTO);
    }

}
