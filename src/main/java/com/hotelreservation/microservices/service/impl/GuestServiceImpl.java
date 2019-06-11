package com.hotelreservation.microservices.service.impl;

import com.hotelreservation.microservices.constants.DemoAppConstants;
import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.entity.Room;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.exceptions.GuestNotFoundException;
import com.hotelreservation.microservices.exceptions.RoomFullException;
import com.hotelreservation.microservices.exceptions.RoomNotFoundException;
import com.hotelreservation.microservices.repository.GuestRepository;
import com.hotelreservation.microservices.repository.RoomRepository;
import com.hotelreservation.microservices.service.IGuestService;
import com.hotelreservation.microservices.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by e068635 on 6/10/2019.
 */
@Service
public class GuestServiceImpl implements IGuestService {


    @Autowired
    private IRoomService roomService;

    @Autowired
    private GuestRepository guestRepository;


    @Override
    public Guest retrieveGuestById(Long id) throws GuestNotFoundException {
        return guestRepository.getOne(id);
    }

    @Override
    public Guest registerNewGuest(Guest newGuest) throws GuestAlreadyRegisteredException {

        Guest existingGuest = guestRepository.findBylastName(newGuest.getLastName());

        if(!newGuest.equals(existingGuest)){
            guestRepository.save(newGuest);
        }else{
            throw new GuestAlreadyRegisteredException (DemoAppConstants.GUEST_ALREADY_REGISTERED_ERROR_MESSAGE);
        }
        return newGuest;
    }


    @Override
    public Guest checkIn(String guestCode, Room room) throws RoomFullException, RoomNotFoundException {

        Guest checkedInGuest = guestRepository.findByguestCode(guestCode);
        checkedInGuest.getRooms().add(room);
        guestRepository.save(checkedInGuest);

        return checkedInGuest;
    }

    @Override
    public Guest checkOut(String guestId, Room room) throws RoomFullException, RoomNotFoundException {
        return null;
    }
}
