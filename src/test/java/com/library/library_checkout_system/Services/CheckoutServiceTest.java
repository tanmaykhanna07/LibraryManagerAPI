package com.library.library_checkout_system.Services;

import com.library.library_checkout_system.Repositories.BookRepository;
import com.library.library_checkout_system.Repositories.MemberRepository;
import com.library.library_checkout_system.dto.CheckoutRequestDTO;
import com.library.library_checkout_system.exceptions.MemberSuspendedException;
import com.library.library_checkout_system.models.Book;
import com.library.library_checkout_system.models.Member;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class CheckoutServiceTest {

    @Mock
    private MemberRepository memberRepository;

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private CheckoutService checkoutService;

    @Test
    public void whenMemberIsSuspended_throwMemberSuspendedException(){
        CheckoutRequestDTO requestDTO = new CheckoutRequestDTO(1,100);
        Member member = new Member();
        member.setMemberId(1);
        member.setSuspended(true);

        Book availableBook = new Book();
        availableBook.setBookId(100);

        Mockito.when(memberRepository.findById(member.getMemberId())).thenReturn(Optional.of(member));
        Mockito.when(bookRepository.findById(availableBook.getBookId())).thenReturn(Optional.of(availableBook));

        assertThrows(MemberSuspendedException.class, () -> {
           checkoutService.registerBook(requestDTO);
        });
    }

}
