package com.volunteer.ordercreator.exception;

public class OrderWithNameAlreadyExistsException extends RuntimeException {

    public OrderWithNameAlreadyExistsException(String message) {
        super(message);
    }

}
