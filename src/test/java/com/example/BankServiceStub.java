package com.example;

public class BankServiceStub implements BankService {

    private boolean paymentResult;

    public BankServiceStub(boolean paymentResult) {
        this.paymentResult = paymentResult;
    }

    @Override
    public void pay(String id, double amount) {
        if (!paymentResult) {
            throw new RuntimeException("Payment failed");
        }
    }

    public void setPaymentResult(boolean paymentResult) {
        this.paymentResult = paymentResult;
    }
}
