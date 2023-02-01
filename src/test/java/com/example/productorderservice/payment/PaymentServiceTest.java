package com.example.productorderservice.payment;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PaymentServiceTest {
    private PaymentService paymentService;
    private PaymentPort paymentPort;


    @BeforeEach
    void setUp() {
        final PaymentGateway paymentGateway = new ConsolePaymentGateway();
        final PaymentRepository paymentRepository = new PaymentRepository();
        paymentPort = new PaymentAdapter(paymentGateway, paymentRepository);
        paymentService = new PaymentService(paymentPort);
    }

    @Test
    @DisplayName("주문을 결제한다.")
    void payOrder() {
        final PaymentRequest request = PaymentSteps.newPaymentRequest();
        paymentService.payOrder(request);
    }
}
