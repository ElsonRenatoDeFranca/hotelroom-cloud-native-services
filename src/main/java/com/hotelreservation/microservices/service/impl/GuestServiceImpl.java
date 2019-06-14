package com.hotelreservation.microservices.service.impl;

import com.hotelreservation.microservices.constants.DemoAppConstants;
import com.hotelreservation.microservices.converter.IGuestServiceConverter;
import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.exceptions.GuestAlreadyRegisteredException;
import com.hotelreservation.microservices.exceptions.GuestNotFoundException;
import com.hotelreservation.microservices.repository.GuestRepository;
import com.hotelreservation.microservices.service.IGuestService;
import com.hotelreservation.microservices.vo.GuestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by e068635 on 6/10/2019.
 */
@Service
public class GuestServiceImpl implements IGuestService {

    @Autowired
    private GuestRepository guestRepository;

    @Autowired
    private IGuestServiceConverter guestServiceConverter;


    @Override
    public GuestVO findGuestById(Long id) throws GuestNotFoundException {
        return Optional.of(guestRepository.findByguestId(id)).
                map(guestServiceConverter::convertEntityToVO).orElseThrow(() ->
                new GuestNotFoundException (DemoAppConstants.GUEST_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public GuestVO findGuestByLastName(String lastName) throws GuestNotFoundException {

       return  Optional.of(guestRepository.findBylastName(lastName)).
                map(guestServiceConverter::convertEntityToVO).
                orElseThrow(() -> new GuestNotFoundException (DemoAppConstants.GUEST_NOT_FOUND_ERROR_MESSAGE));
    }

    @Override
    public GuestVO registerNewGuest(Guest newGuest) throws GuestAlreadyRegisteredException {

        Optional<Guest> optionalGuest = Optional.ofNullable(guestRepository.findByguestId(newGuest.getGuestId()));

        if(!optionalGuest.isPresent()){
            return Optional.of(guestRepository.save(newGuest)).
                    map(guestServiceConverter::convertEntityToVO).orElseThrow(() ->new GuestAlreadyRegisteredException (DemoAppConstants.GUEST_NOT_FOUND_ERROR_MESSAGE));
        }else{
            throw new GuestAlreadyRegisteredException (DemoAppConstants.GUEST_ALREADY_REGISTERED_ERROR_MESSAGE);
        }

    }


    @Override
    public void deleteGuest(Long guestId) throws GuestNotFoundException {
        Optional.of(guestRepository.findByguestId(guestId)).ifPresent(item -> guestRepository.delete(item));
    }

    @Override
    public List<GuestVO> findAll() {
        return guestRepository.findAll().stream().
                map(guestServiceConverter::convertEntityToVO).
                collect(Collectors.toList());
    }

}
