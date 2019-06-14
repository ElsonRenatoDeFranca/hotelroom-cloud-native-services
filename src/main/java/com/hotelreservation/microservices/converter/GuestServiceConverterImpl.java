package com.hotelreservation.microservices.converter;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.vo.GuestVO;
import org.springframework.stereotype.Service;

/**
 * Created by e068635 on 6/13/2019.
 */
@Service
public class GuestServiceConverterImpl implements IGuestServiceConverter {

    @Override
    public GuestVO convertEntityToVO(Guest guest) {
        GuestVO guestVO = new GuestVO();

        guestVO.setState(guest.getState());
        guestVO.setPhoneNumber(guest.getPhoneNumber());
        guestVO.setLastName(guest.getLastName());
        guestVO.setGuestId(guest.getGuestId());
        guestVO.setFirstName(guest.getFirstName());
        guestVO.setEmailAddress(guest.getEmailAddress());
        guestVO.setCountry(guest.getCountry());
        guestVO.setAddress(guest.getAddress());

        return guestVO;
    }

    @Override
    public Guest convertVOToEntity(GuestVO guestVO) {
        Guest guest = new Guest();

        guest.setState(guestVO.getState());
        guest.setPhoneNumber(guestVO.getPhoneNumber());
        guest.setLastName(guestVO.getLastName());
        guest.setGuestId(guestVO.getGuestId());
        guest.setFirstName(guestVO.getFirstName());
        guest.setEmailAddress(guestVO.getEmailAddress());
        guest.setCountry(guestVO.getCountry());
        guest.setAddress(guestVO.getAddress());

        return guest;
    }
}
