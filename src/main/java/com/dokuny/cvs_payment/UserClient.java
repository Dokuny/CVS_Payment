package com.dokuny.cvs_payment;

import com.dokuny.cvs_payment.config.ApplicationConfig;
import com.dokuny.cvs_payment.dto.PayCancelRequest;
import com.dokuny.cvs_payment.dto.PayCancelResponse;
import com.dokuny.cvs_payment.dto.PayRequest;
import com.dokuny.cvs_payment.dto.PayResponse;
import com.dokuny.cvs_payment.service.ConveniencePayService;
import com.dokuny.cvs_payment.type.ConvenienceType;
import com.dokuny.cvs_payment.type.PayMethodType;

public class UserClient {
    public static void main(String[] args) {

        ApplicationConfig applicationConfig = new ApplicationConfig();
        // 사용자 -> 편의점 결제 서비스 -> 머니
        ConveniencePayService conveniencePayService =
                applicationConfig.conveniencePayServiceDiscountPayMethod();

        // 결제 1000원
        PayRequest payRequest = new PayRequest(PayMethodType.CARD,ConvenienceType.GS25, 50);
        PayResponse payResponse = conveniencePayService.pay(payRequest);

        System.out.println(payResponse);
        // 취소 500원
        PayCancelRequest payCancelRequest = new PayCancelRequest(PayMethodType.MONEY,ConvenienceType.CU, 500);
        PayCancelResponse payCancelResponse = conveniencePayService.payCancel(payCancelRequest);
        System.out.println(payCancelResponse);

    }
}
