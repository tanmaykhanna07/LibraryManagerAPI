package com.library.library_checkout_system.exceptions;

public class TooManyBooksCheckOutException extends RuntimeException {
    public TooManyBooksCheckOutException(String message) {
        super(message);
    }
}
