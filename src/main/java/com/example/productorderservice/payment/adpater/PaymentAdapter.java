package com.example.productorderservice.payment.adpater;

import com.example.productorderservice.order.domain.Order;
import com.example.productorderservice.order.adapter.OrderRepository;
import com.example.productorderservice.payment.application.port.PaymentPort;
import com.example.productorderservice.payment.domain.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentAdapter implements PaymentPort {
    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    PaymentAdapter(final PaymentGateway paymentGateway, final OrderRepository orderRepository,
                   final PaymentRepository paymentRepository) {
        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
        this.paymentRepository = paymentRepository;
    }

    @Override
    public Order getOrder(final Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new IllegalArgumentException("주문이 존재하지 않습니다."));
    }

    @Override
    public void pay(final int totalPrice, final String cardNumber) {
        paymentGateway.execute(totalPrice, cardNumber);
    }

    @Override
    public void save(final Payment payment) {
        paymentRepository.save(payment);
    }
}
