package com.library.library_checkout_system.Services;

import com.library.library_checkout_system.Repositories.BookRepository;
import com.library.library_checkout_system.dto.BookRequestDTO;
import com.library.library_checkout_system.dto.BookResponseDTO;
import com.library.library_checkout_system.enums.BookStatus;
import com.library.library_checkout_system.models.Book;
import org.springframework.stereotype.Service;

@Service
public class BookServices {

    private final BookRepository bookRepository;

    public BookServices(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponseDTO addBook(BookRequestDTO requestDTO){
        Book newBook = new Book();
        newBook.setTitle(requestDTO.getTitle());
        newBook.setAuthor(requestDTO.getAuthor());
        newBook.setIsbn(requestDTO.getIsbn());
        newBook.setStatus(BookStatus.IN_SHELF);

        return convertToDto(bookRepository.save(newBook));
    }

    private BookResponseDTO convertToDto(Book newBook){
        return new BookResponseDTO(
                newBook.getBookId(),
                newBook.getTitle(),
                newBook.getAuthor(),
                newBook.getIsbn(),
                newBook.getStatus()
        );
    }
}
