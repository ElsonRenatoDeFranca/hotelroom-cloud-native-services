package com.hotelreservation.microservices.converter;

import com.hotelreservation.microservices.vo.RoomVO;
import com.hotelreservation.microservices.entity.Room;

/**
 * Created by e068635 on 6/7/2019.
 */
public interface IRoomServiceConverter {

    /**
     *
     * @param room
     * @return
     */
    RoomVO convertEntityToVO(Room room);

    /**
     *
     * @param roomVO
     * @return
     */
    Room convertVOToEntity(RoomVO roomVO);
}
