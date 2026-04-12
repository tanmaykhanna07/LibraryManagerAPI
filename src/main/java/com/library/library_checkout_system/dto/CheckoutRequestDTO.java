package com.library.library_checkout_system.dto;

import jakarta.validation.constraints.NotNull;

public class CheckoutRequestDTO {
    @NotNull
    private Integer memberId;
    @NotNull
    private Integer bookId;

    public CheckoutRequestDTO(Integer memberId, Integer bookId) {
        this.memberId = memberId;
        this.bookId = bookId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }
}
