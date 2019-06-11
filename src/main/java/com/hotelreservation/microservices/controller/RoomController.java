package com.hotelreservation.microservices.controller;


import com.hotelreservation.microservices.entity.Room;
import com.hotelreservation.microservices.exceptions.RoomNotFoundException;
import com.hotelreservation.microservices.service.IRoomService;
import com.hotelreservation.microservices.vo.RoomVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@Api(value="rooms", description = "Data service operations on rooms", tags=("rooms"))
public class RoomController {

    @Autowired
    private IRoomService roomService;

    @RequestMapping(method=RequestMethod.GET, value = "api/rooms")
    @ApiOperation(value="Get all rooms", notes="Gets all rooms in the system", nickname="getRooms")
    public ResponseEntity<List<RoomVO>> findAll(){
        return new ResponseEntity<>(roomService.findAll(), HttpStatus.OK);
    }


    @RequestMapping(method=RequestMethod.GET,value="/api/rooms/{roomNumber}")
    @ApiOperation(value="Get room by number", notes="Gets an specific number", nickname="getSpecificRoomNumber")
    public ResponseEntity<Room> retrieveRoomByNumber(@PathVariable String roomNumber)throws RoomNotFoundException{

        try {
            Room room = roomService.findByRoomNumber(roomNumber);
            return new ResponseEntity<>(room, HttpStatus.OK);

        }catch(RoomNotFoundException roomNotFoundEx){
            System.err.println(roomNotFoundEx.getMessage());
            return new ResponseEntity<> (HttpStatus.BAD_REQUEST);
        }

    }

}
