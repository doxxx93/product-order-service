package com.example.productorderservice.payment;

import com.example.productorderservice.order.OrderService;
import com.example.productorderservice.order.OrderSteps;
import com.example.productorderservice.product.ProductService;
import com.example.productorderservice.product.ProductSteps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PaymentServiceTest {
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;
    @Autowired
    private PaymentService paymentService;

    @Test
    @DisplayName("주문을 결제한다.")
    void payOrder() {
        productService.addProduct(ProductSteps.newAddProductRequest());
        orderService.createOrder(OrderSteps.newCreateOrderRequest());
        final PaymentRequest request = PaymentSteps.newPaymentRequest();

        paymentService.payOrder(request);
    }
}
