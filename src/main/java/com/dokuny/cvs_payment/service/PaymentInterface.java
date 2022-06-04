package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.type.CancelPaymentResult;
import com.dokuny.cvs_payment.type.PayMethodType;
import com.dokuny.cvs_payment.type.PaymentResult;

public interface PaymentInterface {
    PayMethodType getPayMethodType();
    PaymentResult payment(Integer payAmount);
    CancelPaymentResult cancelPayment(Integer cancelPayAmount);
}
