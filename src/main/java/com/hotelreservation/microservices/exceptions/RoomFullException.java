package com.hotelreservation.microservices.exceptions;

/**
 * Created by e068635 on 3/10/2019.
 */
public class RoomFullException extends Exception {

    private static final long serialVersionUID = 7899928512143245128L;

    public RoomFullException(String message) {
        super(message);
    }

}
