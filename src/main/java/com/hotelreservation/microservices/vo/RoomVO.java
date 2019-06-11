package com.hotelreservation.microservices.vo;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by e068635 on 6/6/2019.
 */
@Getter
@Setter
public class RoomVO {

    private Long id;
    private String guestId;
    private String name;
    private String roomNumber;
    private String bedInfo;

}
