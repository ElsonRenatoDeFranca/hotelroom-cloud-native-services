package com.hotelreservation.microservices.service.impl;

import com.hotelreservation.microservices.converter.IRoomServiceConverter;
import com.hotelreservation.microservices.exceptions.RoomNotFoundException;
import com.hotelreservation.microservices.repository.RoomRepository;
import com.hotelreservation.microservices.service.IRoomService;
import com.hotelreservation.microservices.vo.RoomVO;
import com.hotelreservation.microservices.constants.DemoAppConstants;
import com.hotelreservation.microservices.entity.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class RoomServiceImpl implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Autowired
    private IRoomServiceConverter roomServiceConverter;

    @Override
    public List<RoomVO> findAll() {
        return roomRepository.findAll().stream().
               map(roomServiceConverter::convertEntityToVO).collect(Collectors.toList());

    }

    @Override
    public Room findByRoomNumber(String roomNumber) throws RoomNotFoundException {
        return Optional.of(roomRepository.findByRoomNumber(roomNumber)).
                orElseThrow(() -> new RoomNotFoundException(DemoAppConstants.ROOM_NOT_FOUND_ERROR_MESSAGE));

    }

}
