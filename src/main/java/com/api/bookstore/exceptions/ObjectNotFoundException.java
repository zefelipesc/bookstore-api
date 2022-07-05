package com.api.bookstore.exceptions;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String s) {
        super(s);
    }

    public ObjectNotFoundException(String s, Throwable throwable) {
        super(s, throwable);
    }
}
