package com.dokuny.cvs_payment.dto;

import com.dokuny.cvs_payment.type.ConvenienceType;
import com.dokuny.cvs_payment.type.PayMethodType;

public class PayCancelRequest {

    // 결제수단 종류
    PayMethodType payMethodType;
    // 편의점 종류
    ConvenienceType convenienceType;
    // 취소 금액
    Integer payCancelAmount;

    public PayCancelRequest(PayMethodType payMethodType, ConvenienceType convenienceType, Integer payCancelAmount) {
        this.payMethodType = payMethodType;
        this.convenienceType = convenienceType;
        this.payCancelAmount = payCancelAmount;
    }

    public ConvenienceType getConvenienceType() {
        return convenienceType;
    }

    public void setConvenienceType(ConvenienceType convenienceType) {
        this.convenienceType = convenienceType;
    }

    public Integer getPayCancelAmount() {
        return payCancelAmount;
    }

    public void setPayCancelAmount(Integer payCancelAmount) {
        this.payCancelAmount = payCancelAmount;
    }

    public PayMethodType getPayMethodType() {
        return payMethodType;
    }

    public void setPayMethodType(PayMethodType payMethodType) {
        this.payMethodType = payMethodType;
    }
}
