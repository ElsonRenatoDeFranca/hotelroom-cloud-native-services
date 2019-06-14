package com.hotelreservation.microservices.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by e068635 on 6/6/2019.
 */
@Entity
@Table(name="ROOM")
@Getter
@Setter
public class Room {


    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name = "NAME", length = 16)
    private String name;

    @Column(name ="ROOM_NUMBER", length = 2)
    private String roomNumber;

    @Column(name = "BED_INFO", length = 2)
    private String bedInfo;

    /*@JsonIgnore
    @ManyToMany(mappedBy = "rooms")
    private List<Guest> guests = new ArrayList();
   */
    @ManyToOne(cascade = CascadeType.ALL)
    private Booking booking;

}
