package com.hotelreservation.microservices.common;

import lombok.Getter;

/**
 * Created by e068635 on 6/14/2019.
 */
@Getter
public enum PaymentType {

    CASH(1L),
    DEBIT_CARD(2L),
    CREDIT_CARD(3L),
    BIT_COIN(4L);

    private Long paymentType;

    PaymentType(Long id) {
        paymentType = id;
    }

}
