package com.hotelreservation.microservices.controller;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.exceptions.GuestNotFoundException;
import com.hotelreservation.microservices.service.IGuestService;
import com.hotelreservation.microservices.vo.GuestVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by e068635 on 6/10/2019.
 */

@RestController
@Api(value="guests", description = "Data service operations on guests", tags=("guests"))
public class GuestController {

    @Autowired
    private IGuestService guestService;

    @RequestMapping(method=RequestMethod.POST, value="api/guests")
    @ApiOperation(value="Register a new guest", notes="Register a new guest in the Hotel", nickname="saveGuest")
    public ResponseEntity<GuestVO> registerNewGuest(@RequestBody Guest guest) {
        GuestVO registeredGuest = null;
        try {
            registeredGuest = guestService.registerNewGuest(guest);
            return new ResponseEntity<>(registeredGuest, HttpStatus.OK);
        } catch (GuestAlreadyRegisteredException e) {
            return new ResponseEntity<>(registeredGuest, HttpStatus.BAD_REQUEST);
        }
    }


    @RequestMapping(method=RequestMethod.GET,value="api/guests/{guestId}")
    @ApiOperation(value="Get guest by id", notes="Gets an specific guest by code", nickname="getGuestById")
    public ResponseEntity<GuestVO> findGuestById(@PathVariable(name="guestId") Long guestId){
        GuestVO guestVO = null;
        try {
            guestVO = guestService.findGuestById(guestId);
            return new ResponseEntity<>(guestVO, HttpStatus.OK);
        } catch (GuestNotFoundException e) {
            return new ResponseEntity<>(guestVO, HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(method=RequestMethod.GET,value="guests/{lastName}")
    @ApiOperation(value="Get guest by last name", notes="Gets an specific guest by last name", nickname="getGuestByLastName")
    public ResponseEntity<GuestVO> findGuestByLastName(@PathVariable(name="lastName") String lastName) {
        GuestVO guestVO = null;
        try {
            guestVO = guestService.findGuestByLastName(lastName);
            return new ResponseEntity<>(guestVO, HttpStatus.OK);
        } catch (GuestNotFoundException e) {
            return new ResponseEntity<>(guestVO, HttpStatus.BAD_REQUEST);
        }

    }

    @RequestMapping(method=RequestMethod.GET,value="api/guests")
    @ApiOperation(value="Gets all guests registered", notes="Gets all guests registered", nickname="getAllGuests")
    public ResponseEntity<List<GuestVO>> findAll() {
        return new ResponseEntity<>(guestService.findAll(), HttpStatus.OK);
    }


    /*
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
    */

}
