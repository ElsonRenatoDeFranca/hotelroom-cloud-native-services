package com.hotelreservation.microservices.service;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.entity.Room;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.exceptions.GuestNotFoundException;
import com.hotelreservation.microservices.exceptions.RoomFullException;
import com.hotelreservation.microservices.exceptions.RoomNotFoundException;
import com.hotelreservation.microservices.vo.GuestVO;
import com.hotelreservation.microservices.vo.RoomVO;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by e068635 on 6/10/2019.
 */
public interface IGuestService {

    /**
     *
     * @param id
     * @return
     */
    GuestVO findGuestById(Long id)  throws GuestNotFoundException;

    /**
     *
     * @param lastName
     * @return
     */
    GuestVO findGuestByLastName(String lastName)  throws GuestNotFoundException;


    /**
     *
     * @param newGuest
     * @return
     * @throws GuestAlreadyRegisteredException
     */
    GuestVO registerNewGuest(Guest newGuest) throws GuestAlreadyRegisteredException;

    /**
     *
     * @param guestId
     * @return
     * @throws GuestNotFoundException
     */
    void deleteGuest(Long guestId) throws GuestNotFoundException;

    /**
     *
     * @return
     */
    List<GuestVO> findAll();


}
