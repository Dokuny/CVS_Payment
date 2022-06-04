package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.dto.*;
import com.dokuny.cvs_payment.type.MoneyUseCancelResult;
import com.dokuny.cvs_payment.type.MoneyUseResult;
import com.dokuny.cvs_payment.type.PayCancelResult;
import com.dokuny.cvs_payment.type.PayResult;

public class ConveniencePayService {
    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    public PayResponse pay(PayRequest payRequest) {
        MoneyUseResult moneyUseResult = moneyAdapter.use(payRequest.getPayAmount());

        // fail fast
        if (moneyUseResult == MoneyUseResult.USE_FAIL) {
            return new PayResponse(PayResult.FAIL, 0);
        }

        // Success Case
        return new PayResponse(PayResult.SUCCESS, payRequest.getPayAmount());
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        MoneyUseCancelResult moneyUseCancelResult = moneyAdapter.useCancel(payCancelRequest.getPayCancelAmount());
        if (moneyUseCancelResult == MoneyUseCancelResult.MONEY_USE_CANCEL_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }
        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,payCancelRequest.getPayCancelAmount());
    }
}
