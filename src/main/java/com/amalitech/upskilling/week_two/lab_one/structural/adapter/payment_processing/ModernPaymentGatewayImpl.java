package com.amalitech.upskilling.week_two.lab_one.structural.adapter.payment_processing;

public class ModernPaymentGatewayImpl implements ModernPaymentGateway {

    @Override
    public boolean authorize(String transactionDetailsJson) {
        return true;
    }

    @Override
    public boolean executePayment(String paymentDetailsJson) {
        return true;
    }

}
