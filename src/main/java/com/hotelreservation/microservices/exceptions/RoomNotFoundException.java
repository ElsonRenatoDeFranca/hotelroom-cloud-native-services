package com.hotelreservation.microservices.exceptions;

public class RoomNotFoundException extends Exception{

    private static final long serialVersionUID = 7837828512143245128L;

    public RoomNotFoundException(String message) {
        super(message);
    }

}






