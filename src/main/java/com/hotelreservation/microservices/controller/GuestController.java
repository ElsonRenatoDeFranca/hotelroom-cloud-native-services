package com.hotelreservation.microservices.controller;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.entity.Room;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.exceptions.RoomFullException;
import com.hotelreservation.microservices.exceptions.RoomNotFoundException;
import com.hotelreservation.microservices.service.IGuestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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
    @ApiOperation(value="Register a new guest", notes="Register a new guest in the Hotel", nickname="saveGuest")
    public ResponseEntity<Guest> registerNewGuest(@RequestBody Guest guest) {
        Guest registeredGuest = null;
        try {
            registeredGuest = guestService.registerNewGuest(guest);
            return new ResponseEntity<>(registeredGuest, HttpStatus.OK);
        } catch (GuestAlreadyRegisteredException e) {
            return new ResponseEntity<>(registeredGuest, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.POST, value="/guests/{guestCode}/rooms",produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value="Guest check in", notes="Check a new guest in the Hotel", nickname="saveGuest")
    public ResponseEntity<Guest> checkin(@PathVariable(name="guestCode") String guestCode, @RequestBody Room room){

        Guest registeredGuest = null;
        try {
            registeredGuest = guestService.checkIn(guestCode, room);
            return new ResponseEntity<> (registeredGuest,HttpStatus.OK);
        } catch (RoomNotFoundException prodEx) {
            System.err.println(prodEx.getMessage());
            return new ResponseEntity<>(registeredGuest, HttpStatus.BAD_REQUEST);
        }
        catch(RoomFullException roomFullEx){
            return new ResponseEntity<>(registeredGuest, HttpStatus.BAD_REQUEST);
        }
    }

}
