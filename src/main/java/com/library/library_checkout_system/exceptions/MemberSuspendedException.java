package com.library.library_checkout_system.exceptions;

public class MemberSuspendedException extends RuntimeException {
    public MemberSuspendedException(String message) {
        super(message);
    }
}
