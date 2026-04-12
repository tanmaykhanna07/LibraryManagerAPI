package com.library.library_checkout_system.Repositories;

import com.library.library_checkout_system.models.Book;
import com.library.library_checkout_system.models.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer> {
    public Integer countBooksByMember(Member member);
}
