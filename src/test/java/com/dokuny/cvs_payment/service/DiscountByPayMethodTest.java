package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.dto.PayRequest;
import com.dokuny.cvs_payment.type.ConvenienceType;
import com.dokuny.cvs_payment.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByPayMethodTest {
    DiscountByPayMethod discountByPayMethod = new DiscountByPayMethod();

    @Test
    void discountSuccess() {
        //given
        PayRequest payRequestMoney = new PayRequest(PayMethodType.MONEY,
                ConvenienceType.GS25, 1000);
        PayRequest payRequestCard = new PayRequest(PayMethodType.CARD,
                ConvenienceType.GS25, 1000);

        //when
        Integer money =
                discountByPayMethod.getDiscountedAmount(payRequestMoney);
        Integer card =
                discountByPayMethod.getDiscountedAmount(payRequestCard);

        //then
        assertEquals(money,700);
        assertEquals(card,1000);
    }

}