package com.dokuny.cvs_payment.config;

import com.dokuny.cvs_payment.service.*;

import java.util.Arrays;
import java.util.HashSet;

public class ApplicationConfig {

    public ConveniencePayService conveniencePayServiceDiscountConvenience() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByConvenience()
        );
    }

    public ConveniencePayService conveniencePayServiceDiscountPayMethod() {
        return new ConveniencePayService(
                new HashSet<>(
                        Arrays.asList(new MoneyAdapter(), new CardAdapter())
                ),
                new DiscountByPayMethod()
        );
    }

}
