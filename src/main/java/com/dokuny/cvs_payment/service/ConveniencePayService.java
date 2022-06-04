package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.dto.*;
import com.dokuny.cvs_payment.type.*;

public class ConveniencePayService {

    private final MoneyAdapter moneyAdapter = new MoneyAdapter();
    private final CardAdapter cardAdapter = new CardAdapter();
    private final DiscountInterface discountInterface = new DiscountByPayMethod();

    public PayResponse pay(PayRequest payRequest) {
        PaymentInterface paymentInterface;

        if (payRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        Integer discountedAmount =
                discountInterface.getDiscountedAmount(payRequest);

        PaymentResult paymentResult =
                paymentInterface.payment(discountedAmount);

        // fail fast
        if(paymentResult == PaymentResult.PAYMENT_FAIL)
            return new PayResponse(PayResult.FAIL, 0);

        // Success Case
        return new PayResponse(PayResult.SUCCESS, discountedAmount);
    }

    public PayCancelResponse payCancel(PayCancelRequest payCancelRequest) {
        PaymentInterface paymentInterface;

        if (payCancelRequest.getPayMethodType() == PayMethodType.CARD) {
            paymentInterface = cardAdapter;
        } else {
            paymentInterface = moneyAdapter;
        }

        CancelPaymentResult cancelPaymentResult = paymentInterface.cancelPayment(payCancelRequest.getPayCancelAmount());

        if (cancelPaymentResult == CancelPaymentResult.CANCEL_PAYMENT_FAIL) {
            return new PayCancelResponse(PayCancelResult.PAY_CANCEL_FAIL, 0);
        }

        return new PayCancelResponse(PayCancelResult.PAY_CANCEL_SUCCESS,payCancelRequest.getPayCancelAmount());
    }
}
