package com.volunteer.ordercreator.exception;

public class OrderWithNameAlreadyExistsException extends RuntimeException {

    private static final String ERROR_MESSAGE = "Order with name '%s' already exists";

    public OrderWithNameAlreadyExistsException(String parameter) {

        super(ERROR_MESSAGE);
    }

}
