package com.hotelreservation.microservices.converter;


import com.hotelreservation.microservices.entity.Room;
import com.hotelreservation.microservices.vo.RoomVO;
import org.springframework.stereotype.Service;

/**
 * Created by e068635 on 6/7/2019.
 */
@Service
public class RoomServiceConverterImpl implements IRoomServiceConverter{


    @Override
    public RoomVO convertEntityToVO(Room room) {
        RoomVO roomVO = new RoomVO();
        roomVO.setRoomNumber(room.getRoomNumber());
        roomVO.setId(room.getId());
        roomVO.setName(room.getName());
        roomVO.setBedInfo(room.getBedInfo());
        roomVO.setId(room.getId());

        return roomVO;
    }

    @Override
    public Room convertVOToEntity(RoomVO roomVO) {
        Room room = new Room();
        room.setId(roomVO.getId());
        room.setBedInfo(roomVO.getBedInfo());
        room.setName(roomVO.getName());
        room.setRoomNumber(roomVO.getRoomNumber());
        return room;
    }
}
