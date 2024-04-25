package com.amalitech.upskilling.week_two.lab_one.structural.adapter.payment_processing;

public interface ModernPaymentGateway {
    boolean authorize(String transactionDetailsJson);
    boolean executePayment(String paymentDetailsJson);
}
