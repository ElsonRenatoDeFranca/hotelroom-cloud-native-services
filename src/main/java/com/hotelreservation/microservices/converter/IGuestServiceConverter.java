package com.hotelreservation.microservices.converter;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.vo.GuestVO;

/**
 * Created by e068635 on 6/13/2019.
 */
public interface IGuestServiceConverter {

    /**
     *
     * @param guest
     * @return
     */
    GuestVO convertEntityToVO(Guest guest);

    /**
     *
     * @param guestVO
     * @return
     */
    Guest convertVOToEntity(GuestVO guestVO);
}
