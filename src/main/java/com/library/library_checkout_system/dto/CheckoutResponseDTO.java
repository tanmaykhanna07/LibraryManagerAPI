package com.library.library_checkout_system.dto;

import com.library.library_checkout_system.enums.BookStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class CheckoutResponseDTO {
    @NotNull
    private Integer memberId;
    @NotBlank
    private String name;
    @NotNull
    private Integer bookId;
    @NotBlank
    private String title;
    @NotNull
    private BookStatus status;

    public CheckoutResponseDTO(Integer memberId, String name, Integer bookId, String title, BookStatus status) {
        this.memberId = memberId;
        this.name = name;
        this.bookId = bookId;
        this.title = title;
        this.status = status;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) {
        this.status = status;
    }
}
