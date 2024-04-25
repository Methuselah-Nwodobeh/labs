package com.amalitech.upskilling.week_two.lab_one.structural.adapter.payment_processing;

import com.amalitech.upskilling.OutPut;

public class Main {
    public static void main(String[] args) {

        PaymentAdapter paymentAdapter = new PaymentAdapter(new ModernPaymentGatewayImpl());
        paymentAdapter.initializeTransaction(100.0, "USD");
if (paymentAdapter.executeTransaction()) {
    OutPut.printColoredTextBlock("Transaction successfully executed through modern gateway.", OutPut.Colors.GREEN);
} else {
    OutPut.printColoredTextBlock("Transaction execution failed.", OutPut.Colors.RED);
}
    }
}
