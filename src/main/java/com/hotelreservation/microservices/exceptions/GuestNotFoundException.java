package com.hotelreservation.microservices.exceptions;

/**
 * Created by e068635 on 6/10/2019.
 */
public class GuestNotFoundException extends Exception {

    private static final long serialVersionUID = 7837828512143246689L;

    public GuestNotFoundException(String message) {
        super(message);
    }

}
