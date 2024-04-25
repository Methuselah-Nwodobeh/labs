package com.amalitech.upskilling.week_two.lab_one.structural.adapter.payment_processing;

public interface LegacyPaymentProcessor {
    void initializeTransaction(double amount, String currency);

    boolean executeTransaction();
}
