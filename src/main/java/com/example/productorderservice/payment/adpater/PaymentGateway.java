package com.example.productorderservice.payment.adpater;

interface PaymentGateway {
    void execute(int totalPrice, String cardNumber);
}
