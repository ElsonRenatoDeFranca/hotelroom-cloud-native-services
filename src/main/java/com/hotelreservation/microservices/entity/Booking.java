package com.hotelreservation.microservices.entity;

import com.hotelreservation.microservices.common.BookingStatus;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

/**
 * Created by e068635 on 6/12/2019.
 */

@Entity
@Table(name="BOOKING")
@Getter
@Setter
@EqualsAndHashCode
public class Booking {

    @Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private Integer id;

    @Column(name = "NUMBER_OF_ADULTS", length = 16)
    private Integer numberOfAdults;

    @Column(name = "NUMBER_OF_CHILDREN", length = 16)
    private Integer numberOfChildren;

    @Temporal(TemporalType.DATE)
    @Column(name = "ARRIVAL_DATE", length = 16)
    private Date arrivalDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "DEPARTURE_DATE", length = 16)
    private Date departureDate;

    @ManyToOne(cascade = CascadeType.ALL)
    private Guest guest;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Room> rooms;

    @Column(name = "BOOKING_STATUS",length = 16)
    private BookingStatus bookingStatus;

}
