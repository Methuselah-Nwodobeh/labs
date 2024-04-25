package com.amalitech.upskilling.week_two.lab_one.structural.adapter.payment_processing;

public class PaymentAdapter implements LegacyPaymentProcessor {

    private final ModernPaymentGateway modernGateway;
    private String transactionDetailsJson;

    public PaymentAdapter(ModernPaymentGateway modernGateway) {
        this.modernGateway = modernGateway;
    }

    @Override
    public void initializeTransaction(double amount, String currency) {
        try {
            TransactionDetails details = new TransactionDetails(amount, currency);
            this.transactionDetailsJson = details.toJson();
        } catch (Exception e) {
            throw new RuntimeException("Error initializing transaction", e);
        }
    }

    @Override
    public boolean executeTransaction() {
        try {
            if (modernGateway.authorize(this.transactionDetailsJson)) {
                return modernGateway.executePayment(this.transactionDetailsJson);
            }
            return false;
        } catch (Exception e) {
            throw new RuntimeException("Error executing transaction", e);
        }
    }

    // Inner class to hold transaction details, simplifying this example
    private record TransactionDetails(double amount, String currency) {

        public String toJson() {
            return "{" +
                    "\"amount\":" +
                    amount +
                    "," +
                    "\"currency\":\"" +
                    currency +
                    "\"" +
                    "}";
        }
    }
}
