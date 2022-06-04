package com.dokuny.cvs_payment.service;

import com.dokuny.cvs_payment.dto.PayRequest;

public interface DiscountInterface {
    Integer getDiscountedAmount(PayRequest payRequest);
}
