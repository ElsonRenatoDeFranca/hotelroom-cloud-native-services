package com.hotelreservation.microservices.entity;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by e068635 on 6/7/2019.
 */


@Entity
@Table(name="GUEST")
@Getter
@Setter
@EqualsAndHashCode
public class Guest {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(name="GUEST_ID", length = 20)
    private Long guestId;

    @Column(name="FIRST_NAME", length = 64)
    private String firstName;

    @Column(name="LAST_NAME", length = 64)
    private String lastName;

    @Column(name="EMAIL_ADDRESS", length = 64)
    private String emailAddress;

    @Column(name="ADDRESS", length = 64)
    private String address;

    @Column(name="STATE", length = 12)
    private String state;

    @Column(name="COUNTRY", length = 64)
    private String country;

    @Column(name="PHONE_NUMBER", length = 24)
    private String phoneNumber;

    /*@ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE
            })

    @JoinTable(name = "BOOKING",
            joinColumns = { @JoinColumn(name = "GUEST_ID") },
            inverseJoinColumns = { @JoinColumn(name = "ROOM_ID") })
    private List<Room> rooms;
    */



}
