package com.hotelreservation.microservices.common;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by e068635 on 6/13/2019.
 */
@Getter
public enum ReservationStatus implements Serializable{

    CONFIRMED("CONFIRMED"),
    CANCELLED("CANCELLED"),
    PENDING_CONFIRMATION("PENDING CONFIRMATION");

    private String bookingId;

    ReservationStatus(String id) {
        bookingId = id;
    }


}
