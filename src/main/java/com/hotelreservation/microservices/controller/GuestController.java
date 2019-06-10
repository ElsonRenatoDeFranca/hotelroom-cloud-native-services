package com.hotelreservation.microservices.controller;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.service.IGuestService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by e068635 on 6/10/2019.
 */

@RestController
@Api(value="guests", description = "Data service operations on guests", tags=("guests"))
public class GuestController {

    @Autowired
    private IGuestService guestService;

    @RequestMapping(method=RequestMethod.POST, value="/guests")
    public ResponseEntity<Guest> registerNewGuest(@RequestBody Guest guest) {
        Guest persistedCart = null;
        try {
            persistedCart = guestService.registerNewGuest(guest);
            return new ResponseEntity<>(persistedCart, HttpStatus.OK);
        } catch (GuestAlreadyRegisteredException e) {
            return new ResponseEntity<>(persistedCart, HttpStatus.BAD_REQUEST);
        }
    }

}
