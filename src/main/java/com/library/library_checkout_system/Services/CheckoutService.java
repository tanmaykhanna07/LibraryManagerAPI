package com.library.library_checkout_system.Services;

import com.library.library_checkout_system.Repositories.BookRepository;
import com.library.library_checkout_system.Repositories.MemberRepository;
import com.library.library_checkout_system.dto.CheckoutRequestDTO;
import com.library.library_checkout_system.dto.CheckoutResponseDTO;
import com.library.library_checkout_system.enums.BookStatus;
import com.library.library_checkout_system.exceptions.BookAlreadyCheckedOutException;
import com.library.library_checkout_system.exceptions.MemberSuspendedException;
import com.library.library_checkout_system.exceptions.ResourceNotFoundException;
import com.library.library_checkout_system.exceptions.TooManyBooksCheckOutException;
import com.library.library_checkout_system.models.Book;
import com.library.library_checkout_system.models.Member;
import org.springframework.stereotype.Service;

@Service
public class CheckoutService {
    private final MemberRepository memberRepository;
    private  final BookRepository bookRepository;

    public CheckoutService(MemberRepository memberRepository, BookRepository bookRepository) {
        this.memberRepository = memberRepository;
        this.bookRepository = bookRepository;
    }

    public CheckoutResponseDTO registerBook(CheckoutRequestDTO checkoutRequestDTO){
        Member rawMember = memberRepository.findById(checkoutRequestDTO.getMemberId()).orElseThrow(
                () -> new ResourceNotFoundException("Couldn't find member, recheck your member id")
        );
        Book rawBook = bookRepository.findById(checkoutRequestDTO.getBookId()).orElseThrow(
                () -> new ResourceNotFoundException("Book not found, Please check book id again")
        );
        if(rawMember.isSuspended()){
            throw new MemberSuspendedException("This member is suspended. Cannot checkout book");
        }
        if(rawBook.getStatus() != BookStatus.IN_SHELF){
            throw new BookAlreadyCheckedOutException("This book isn't in shelf");
        }
        int bookCount = bookRepository.countBooksByMember(rawMember);
        if(bookCount >= 5){
            throw new TooManyBooksCheckOutException("This member has already checkout out more than 5 books");
        }
        rawBook.setStatus(BookStatus.BORROWED);
        rawBook.setMember(rawMember);
        rawMember.getBooks().add(rawBook);

        Member updatedMember = memberRepository.save(rawMember);
        Book updatedBook = bookRepository.save(rawBook);

        return convertToDTO(updatedBook,updatedMember);
    }



    private CheckoutResponseDTO convertToDTO(Book rawBook, Member rawMember){
        return new CheckoutResponseDTO(
                rawMember.getMemberId(),
                rawMember.getName(),
                rawBook.getBookId(),
                rawBook.getTitle(),
                rawBook.getStatus()
        );
    }
}
