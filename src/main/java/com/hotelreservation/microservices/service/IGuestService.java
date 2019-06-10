package com.hotelreservation.microservices.service;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.entity.Room;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.exceptions.GuestNotFoundException;
import com.hotelreservation.microservices.exceptions.RoomFullException;
import com.hotelreservation.microservices.exceptions.RoomNotFoundException;

/**
 * Created by e068635 on 6/10/2019.
 */
public interface IGuestService {

    /**
     *
     * @param id
     * @return
     */
    Guest retrieveGuestById(Long id)  throws GuestNotFoundException;


    /**
     *
     * @param newGuest
     * @return
     * @throws GuestAlreadyRegisteredException
     */
    Guest registerNewGuest(Guest newGuest) throws GuestAlreadyRegisteredException;


    /**
     *
     * @param guestId
     * @param room
     * @return
     * @throws RoomFullException
     * @throws RoomNotFoundException
     */
    Guest checkIn(String guestId, Room room) throws RoomFullException, RoomNotFoundException;


    /**
     *
     * @param guestId
     * @param room
     * @return
     * @throws RoomFullException
     * @throws RoomNotFoundException
     */
    Guest checkOut(String guestId, Room room) throws RoomFullException, RoomNotFoundException;

}
