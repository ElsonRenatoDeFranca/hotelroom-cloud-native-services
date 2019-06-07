package com.hotelreservation.microservices.exceptions;

/**
 * Created by e068635 on 3/10/2019.
 */
public class RoomAlreadyExistsException extends Exception {

    private static final long serialVersionUID = 7899928512143245128L;

    public RoomAlreadyExistsException(String message) {
        super(message);
    }

}
