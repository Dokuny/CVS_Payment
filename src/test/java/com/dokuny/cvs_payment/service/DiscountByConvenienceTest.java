package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.dto.PayRequest;
import com.dokuny.cvs_payment.type.ConvenienceType;
import com.dokuny.cvs_payment.type.PayMethodType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiscountByConvenienceTest {
    DiscountByConvenience discountByConvenience = new DiscountByConvenience();

    @Test
    void discountTest(){
        //given
        PayRequest payRequestByGS25 = new PayRequest(PayMethodType.MONEY, ConvenienceType.GS25, 1000);
        PayRequest payRequestByCU = new PayRequest(PayMethodType.MONEY, ConvenienceType.CU, 1000);
        PayRequest payRequestBySEVEN = new PayRequest(PayMethodType.MONEY, ConvenienceType.SEVEN, 1000);

        //when
        Integer gs25 = discountByConvenience.getDiscountedAmount(payRequestByGS25);
        Integer cu = discountByConvenience.getDiscountedAmount(payRequestByCU);
        Integer seven = discountByConvenience.getDiscountedAmount(payRequestBySEVEN);

        //then
        assertEquals(800,gs25);
        assertEquals(900,cu);
        assertEquals(1000,seven);
    }

}