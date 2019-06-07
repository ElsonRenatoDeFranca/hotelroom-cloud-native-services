package com.hotelreservation.microservices.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by e068635 on 6/7/2019.
 */


@Entity
@Table(name="GUEST")
@Getter
@Setter
public class Guest {

    @Id
    @Column(name="GUEST_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

}
