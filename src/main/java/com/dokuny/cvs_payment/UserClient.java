package com.dokuny.cvs_payment;

import com.dokuny.cvs_payment.dto.PayCancelRequest;
import com.dokuny.cvs_payment.dto.PayCancelResponse;
import com.dokuny.cvs_payment.dto.PayRequest;
import com.dokuny.cvs_payment.dto.PayResponse;
import com.dokuny.cvs_payment.service.ConveniencePayService;
import com.dokuny.cvs_payment.type.ConvenienceType;

public class UserClient {
    public static void main(String[] args) {
        // 사용자 -> 편의점 결제 서비스 -> 머니
        ConveniencePayService conveniencePayService = new ConveniencePayService();

        // 결제 1000원
        PayRequest payRequest = new PayRequest(ConvenienceType.GS25, 1000);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);
        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(ConvenienceType.CU, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println(payCancelResponse);

    }
}
