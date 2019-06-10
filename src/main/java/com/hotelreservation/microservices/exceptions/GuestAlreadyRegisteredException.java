package com.hotelreservation.microservices.exceptions;

/**
 * Created by e068635 on 6/10/2019.
 */
public class GuestAlreadyRegisteredException  extends Exception  {

    private static final long serialVersionUID = 7837829522244246689L;

    public GuestAlreadyRegisteredException(String message) {
        super(message);
    }
}
