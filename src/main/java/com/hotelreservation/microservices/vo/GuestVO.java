package com.hotelreservation.microservices.vo;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;


/**
 * Created by e068635 on 6/13/2019.
 */
@Getter
@Setter
public class GuestVO {

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;

    private Long guestId;

    private String firstName;

    private String lastName;

    private String emailAddress;

    private String address;

    private String state;

    private String country;

    private String phoneNumber;

}
