package com.hotelreservation.microservices.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
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
@Table(name="RESERVATION")
@Getter
@Setter
@EqualsAndHashCode
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer identifier;

    @ManyToOne(cascade = CascadeType.ALL)
    private Guest guest;

    private Integer nights;

    private Integer adults;

    private Integer children;

    @Temporal(TemporalType.DATE)
    private Date arrival;

    @Temporal(TemporalType.DATE)
    private Date departure;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<Room> rooms;
}
