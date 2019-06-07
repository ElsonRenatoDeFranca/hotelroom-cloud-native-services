package com.hotelreservation.microservices.repository;


import com.hotelreservation.microservices.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by e068635 on 6/6/2019.
 */
public interface RoomRepository extends JpaRepository<Room, Long> {

    Room findByRoomNumber(String roomNumber);
}
