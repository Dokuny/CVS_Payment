package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.type.MoneyUseCancelResult;
import com.dokuny.cvs_payment.type.MoneyUseResult;
import org.junit.jupiter.api.Test;

import static com.dokuny.cvs_payment.type.MoneyUseResult.USE_FAIL;
import static com.dokuny.cvs_payment.type.MoneyUseResult.USE_SUCCESS;
import static org.junit.jupiter.api.Assertions.*;

class MoneyAdapterTest {

    MoneyAdapter moneyAdapter = new MoneyAdapter();
    @Test
    void money_use_fail(){
        //given
        Integer payAmount = 1000_001;
        //when
        MoneyUseResult useResult = moneyAdapter.use(payAmount);
        //then
        assertEquals(USE_FAIL, useResult);
    }

    @Test
    void money_use_success(){
        //given
        Integer payAmount = 1000_000;
        //when
        MoneyUseResult useResult = moneyAdapter.use(payAmount);
        //then
        assertEquals(USE_SUCCESS, useResult);

    }

    @Test
    void money_use_cancel_success(){
        //given
        Integer payCancelAmount = 101;
        //when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelAmount);
        //then
        assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_SUCCESS, moneyUseCancelResult);

    }

    @Test
    void money_use_cancel_fail(){
        //given
        Integer payCancelAmount = 99;
        //when
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelAmount);
        //then
        assertEquals(MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL, moneyUseCancelResult);
    }


}