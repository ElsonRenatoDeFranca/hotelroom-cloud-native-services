package com.hotelreservation.microservices.repository;

import com.hotelreservation.microservices.entity.Guest;
import com.hotelreservation.microservices.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by e068635 on 6/10/2019.
 */
public interface GuestRepository extends JpaRepository<Guest, Long> {

    Room findBylastName(String lastName);
}
