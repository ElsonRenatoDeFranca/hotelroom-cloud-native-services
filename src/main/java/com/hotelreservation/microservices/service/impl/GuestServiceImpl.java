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

        Guest existingGuest = guestRepository.getOne(newGuest.getId());

        if(!newGuest.equals(existingGuest)){
            guestRepository.save(newGuest);
        }else{
            throw new GuestAlreadyRegisteredException (DemoAppConstants.GUEST_ALREADY_REGISTERED_ERROR_MESSAGE);
        }
        return newGuest;
    }


    @Override
    public Guest checkIn(String guestId, Room room) throws RoomFullException, RoomNotFoundException {

        /*Room availableRoom = roomService.findByRoomNumber(room.getRoomNumber());


        Guest guest = roomRepository.findById(Long.parseLong(guestId)).orElse(registerNewGuest(Long.parseLong(guestId)));

        if(guest != null){

        }
        */

        return null;
    }

    private Guest registerNewGuest(Long guestId){

        Guest guest = new Guest();
        guest.setId(guestId);

        return guest;
    }
    @Override
    public Guest checkOut(String guestId, Room room) throws RoomFullException, RoomNotFoundException {
        return null;
    }
}
