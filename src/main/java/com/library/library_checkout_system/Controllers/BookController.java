package com.library.library_checkout_system.Controllers;

import com.library.library_checkout_system.Services.BookServices;
import com.library.library_checkout_system.dto.BookRequestDTO;
import com.library.library_checkout_system.dto.BookResponseDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/libraryApi")
class BookController {

    private final BookServices bookServices;
    public BookController(BookServices bookServices){
        this.bookServices = bookServices;
    }
    @PostMapping("/newBook")
    public BookResponseDTO addBook(@Valid @RequestBody BookRequestDTO bookRequestDTO){
        return bookServices.addBook(bookRequestDTO);
    }
}
