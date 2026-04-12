package com.library.library_checkout_system.exceptions;

public class BookAlreadyCheckedOutException extends RuntimeException {
    public BookAlreadyCheckedOutException(String message) {
        super(message);
    }
}
