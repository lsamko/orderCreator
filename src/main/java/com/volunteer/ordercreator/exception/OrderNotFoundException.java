package com.volunteer.ordercreator.exception;

public class OrderNotFoundException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Order with ID '%s' is not found";

    public OrderNotFoundException(String parameter) {
        super(ERROR_MESSAGE);
    }
}
